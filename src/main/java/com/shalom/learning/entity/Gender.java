package com.shalom.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gender")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gender
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;
    
    @OneToMany(mappedBy = "gender")
    @JsonIgnore
    private List<Book> books = new ArrayList<>(); // contorna migração nula
}
