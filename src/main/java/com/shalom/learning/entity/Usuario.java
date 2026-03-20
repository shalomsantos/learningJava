package com.shalom.learning.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user") // Garante que aponte exatamente para a tabela 'Usuario'
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Útil para criar objetos de forma fluida
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;
}