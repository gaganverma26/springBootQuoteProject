package com.example.quoteProject20.Respository;

import com.example.quoteProject20.Model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    @Query(value = "SELECT * FROM quote WHERE author = ?1", nativeQuery = true)
    List<Quote> findByAuthorNameIgnoreCase(String authorName);
}
