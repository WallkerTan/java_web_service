package com.example.ex4.service;

import java.util.List;
import java.util.Optional;
import com.example.ex4.model.entity.Book;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    boolean updateBook(Long id,Book book);
    boolean addBook(Book book);
    boolean deleteBookById(Long id);    
}
