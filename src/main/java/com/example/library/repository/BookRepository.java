package com.example.library.repository;

import org.springframework.stereotype.Repository;
import com.example.library.model.Book;
import com.example.library.exception.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found with id: " + id));
    }
}
