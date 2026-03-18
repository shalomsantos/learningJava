package com.shalom.learning.service;

import com.shalom.learning.entity.Sale;
import com.shalom.learning.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService
{
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> all() { return saleRepository.findAll(); }
}
