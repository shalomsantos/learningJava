package com.shalom.learning.repository;

import com.shalom.learning.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long>
{
    @Query(value = "(SELECT b.id, b.nome, COUNT(s.id) as total_vendas " +
            " FROM book b JOIN sale s ON b.id = s.book_id " +
            " GROUP BY b.id, b.nome ORDER BY total_vendas DESC LIMIT 1) " +
            " UNION ALL " +
            " (SELECT b.id, b.nome, COUNT(s.id) as total_vendas " +
            " FROM book b JOIN sale s ON b.id = s.book_id " +
            " GROUP BY b.id, b.nome ORDER BY total_vendas ASC LIMIT 1)",
            nativeQuery = true)
    List<Object[]> findTopAndBottomBooksNative();
}
