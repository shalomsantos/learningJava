package com.shalom.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SaleDto
{
    private BigDecimal preco;
    private Long user_id;
    private Long book_id;
    private String descricao;
}
