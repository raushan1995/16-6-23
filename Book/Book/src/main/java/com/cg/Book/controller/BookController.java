package com.cg.Book.controller;

import java.util.List;

import com.cg.Book.model.Book;
import com.cg.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//mark class as Controller
@RestController
public class BookController
{
    //autowire the BookService class
    @Autowired
    BookService bookService;
    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Book> getAllBook()
    {
        return bookService.getAllBook();
    }
    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Book getBook(@PathVariable("bookid") int bookid)
    {
        return bookService.getBookById(bookid);
    }
    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
        bookService.delete(bookid);
    }
    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Book book)
    {
        bookService.saveOrUpdate(book);
        return book.getBookid();
    }
    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Book update(@RequestBody Book book)
    {
        bookService.saveOrUpdate(book);
        return book;
    }
}
