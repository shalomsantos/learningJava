package com.shalom.learning.controller;

import com.shalom.learning.dto.BookStatisticsDto;
import com.shalom.learning.entity.Sale;
import com.shalom.learning.entity.User;
import com.shalom.learning.service.BookService;
import com.shalom.learning.service.SaleService;
import com.shalom.learning.service.UserService;
import com.shalom.learning.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController
{
    @Autowired
    private SaleService saleService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Sale> index() { return saleService.all(); }

    @GetMapping("/statistics")
    public Object statistics() {
        long totalLivrosVendidos = bookService.totalLivrosCadastrados();
        User user = userService.findById(2L);

        List<BookStatisticsDto> statsList = saleService.getStatisticsBook();

        BookStatisticsDto maisVendido = !statsList.isEmpty() ? statsList.get(0) : null;
        BookStatisticsDto menosVendido = statsList.size() > 1 ? statsList.get(1) : null;

        return Helper.bodyResponseConstruct(
                "Total livros registrados", totalLivrosVendidos,
                "Usuário responsável", user.getNome(),
                "Livro + vendido", (maisVendido != null ? maisVendido.getNome() : "Nenhum"),
                "Total de vendas (+)", (maisVendido != null ? maisVendido.getTotal_vendas() : 0),
                "Livro - vendido", (menosVendido != null ? menosVendido.getNome() : "Nenhum"),
                "Total de vendas (-)", (menosVendido != null ? menosVendido.getTotal_vendas() : 0)
        );
    }
}
