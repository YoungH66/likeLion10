package com.example.day11.manage.bookManage;

import java.util.Objects;

public class Book {
    private String bookName;
    private String author;
    private int date;

    public Book(String bookName, String author, int date) {
        this.bookName = bookName;
        this.author = author;
        this.date = date;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, author, date);
    }

    @Override
    public String toString() {
        return "{" + bookName + ", " + author + ", " + date + '}';
    }
}
