package com.shalom.learning.service;

import com.shalom.learning.dto.BookDto;
import com.shalom.learning.entity.Book;
import com.shalom.learning.entity.Gender;
import com.shalom.learning.repository.BookRepository;
import com.shalom.learning.repository.GenderRespository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenderRespository genderRepository;

    public List<Book> all() { return bookRepository.findAll(); }

    public Book create(BookDto bookDto)
    {
        Gender gender = genderRepository.findById(bookDto.getGenderId())
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado"));

        Book book = Book.builder() // 2. Montar o objeto Book usando o Builder (ou construtor)
                .nome(bookDto.getNome())
                .sinopse(bookDto.getSinopse())
                .gender(gender) // Aqui você associa o objeto Gender completo
                .build();

        // 3. Salvar e retornar
        return bookRepository.save(book);
    }

    public Book findById(Long id)
    {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));
    }

    public Long totalLivrosCadastrados() { return bookRepository.count(); }
}
