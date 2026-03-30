package com.example.library.model;

public class Book {

    private int id;
    private String name;
    private boolean issued;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.issued = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public boolean isIssued() { return issued; }
    public void setIssued(boolean issued) { this.issued = issued; }

    public String toString() {
        return id + " - " + name + " - " + (issued ? "Issued" : "Available");
    }
}