package com.example.library.service;

import org.springframework.stereotype.Service;
import com.example.library.repository.BookRepository;
import com.example.library.model.Book;

@Service
public class LibraryServiceImpl implements LibraryService {

    private BookRepository repo;

    public LibraryServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addBook(int id, String name) {

        if (id <= 0 || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid book data");
        }

        repo.addBook(new Book(id, name));
        System.out.println("Book added!");
    }

    @Override
    public void issueBook(int id) {
        Book book = repo.findById(id);

        if (book.isIssued()) {
            throw new RuntimeException("Book already issued");
        }

        book.setIssued(true);
        System.out.println("Book issued!");
    }

    @Override
    public void returnBook(int id) {
        Book book = repo.findById(id);

        if (!book.isIssued()) {
            throw new RuntimeException("Book was not issued");
        }

        book.setIssued(false);
        System.out.println("Book returned!");
    }

    @Override
    public void showBooks() {
        repo.getAllBooks().forEach(System.out::println);
    }
}
