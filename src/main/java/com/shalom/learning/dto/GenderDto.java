package com.shalom.learning.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenderDto
{
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String descricao;
}
