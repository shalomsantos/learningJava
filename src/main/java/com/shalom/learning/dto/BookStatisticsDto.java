package com.shalom.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookStatisticsDto {
    private Long id;
    private String nome; // Ajustado de Long para String
    private Long total_vendas; // Long é mais seguro para somas/contagens de DB
}