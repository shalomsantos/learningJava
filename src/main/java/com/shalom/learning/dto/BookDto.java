package com.shalom.learning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDto
{
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Size(max = 255, message = "A sinopse não pode ter mais de 255 caracteres.")
    private String sinopse;

    @NotNull(message = "O gênero é obrigatório.")
    @JsonProperty("gender_id")
    private Long genderId;
}
