package com.cognitech.springboot_docker_compose.controller;

import com.cognitech.springboot_docker_compose.entity.Book;
import com.cognitech.springboot_docker_compose.repo.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    //----------------------------------------------------------------------------------------------------------
    @PatchMapping("/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book)
    {
        Book repoBook = null;
        Optional<Book> optBook = this.bookRepository.findById(id);
        if (optBook.isPresent())
        {
            repoBook = optBook.get();
            if (book.getName() != null && !"".equals(book.getName()))
            {
                repoBook.setName(book.getName());
            }
            if (book.getIsbn() != null && !"".equals(book.getIsbn()))
            {
                repoBook.setIsbn(book.getIsbn());
            }
            this.bookRepository.save(repoBook);
        }
        return repoBook;
    }

    //----------------------------------------------------------------------------------------------------------
    @GetMapping("/book")
    public Book get(@RequestParam Long id)
    {
        Book repoBook = null;
        Optional<Book> optBook = this.bookRepository.findById(id);
        if (optBook.isPresent())
        {
            repoBook = optBook.get();
        }
        return repoBook;
    }
}
