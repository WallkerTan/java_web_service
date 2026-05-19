package com.example.ex4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ex4.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>  {
    
}
