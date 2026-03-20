package com.shalom.learning.service;

import com.shalom.learning.dto.BookStatisticsDto;
import com.shalom.learning.entity.Sale;
import com.shalom.learning.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService
{
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> all() { return saleRepository.findAll(); }

    public List<BookStatisticsDto> getStatisticsBook() {
        List<Object[]> results = saleRepository.findTopAndBottomBooksNative();

        return results.stream().map(result -> new BookStatisticsDto(
                ((Number) result[0]).longValue(), // id
                (String) result[1],               // nome
                (long) ((Number) result[2]).intValue()   // total_vendas
        )).collect(Collectors.toList());
    }
}
