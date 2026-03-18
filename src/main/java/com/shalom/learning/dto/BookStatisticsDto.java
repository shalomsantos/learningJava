package com.shalom.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookStatisticsDto
{
    private Long idMaisVendido;
    private Long idMenosVendido;
}
