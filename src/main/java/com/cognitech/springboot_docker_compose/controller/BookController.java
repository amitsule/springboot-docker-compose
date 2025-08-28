package com.cognitech.springboot_docker_compose.controller;

import com.cognitech.springboot_docker_compose.entity.Book;
import com.cognitech.springboot_docker_compose.repo.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    //----------------------------------------------------------------------------------------------------------
    @PostMapping
    public Book saveBook(@RequestBody Book book)
    {
        return this.bookRepository.save(book);
    }

    //----------------------------------------------------------------------------------------------------------
    @GetMapping
    public List<Book> getBooks()
    {
        return this.bookRepository.findAll();
    }

}
