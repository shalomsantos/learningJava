package com.shalom.learning.controller;

import com.shalom.learning.entity.Sale;
import com.shalom.learning.service.SaleService;
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

    @GetMapping
    public List<Sale> index()
    {
        return saleService.all();
    }
//    public String show() {}
//    public String update() {}
//    public String destroy() {}
//    public String store() {}
}
