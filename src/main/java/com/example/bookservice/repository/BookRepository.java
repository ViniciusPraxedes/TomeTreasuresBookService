package com.example.bookservice.repository;

import com.example.bookservice.model.Book;
import com.example.bookservice.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {
    Optional<Book> findByName(String bookName);
    Optional<Book> findByItemCode(String itemCode);
    @Query("SELECT DISTINCT b FROM Book b JOIN b.categories c WHERE c IN :categories")
    List<Book> findBooksByCategories(@Param("categories") Set<Category> categories);

}
