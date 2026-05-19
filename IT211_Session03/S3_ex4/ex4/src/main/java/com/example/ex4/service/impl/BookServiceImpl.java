package com.example.ex4.service.impl;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.ex4.model.entity.Book;
import com.example.ex4.repo.BookRepository;
import com.example.ex4.service.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean updateBook(Long id, Book book) {
        Book b = getBookById(id).get();
        if(b!=null){
            b.setAuthor(book.getAuthor());
            b.setDate(book.getDate());
            b.setName(book.getName());
            return bookRepository.save(b) != null;
        }
        return false;

    }

    @Override
    public boolean addBook(Book book) {
        return bookRepository.save(book)!=null;
    }

    @Override
    public boolean deleteBookById(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    } 
}
