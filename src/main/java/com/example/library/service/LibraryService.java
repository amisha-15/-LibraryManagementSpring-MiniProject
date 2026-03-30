package com.example.library.service;

public interface LibraryService {

    void addBook(int id, String name);
    void issueBook(int id);
    void returnBook(int id);
    void showBooks();
}
