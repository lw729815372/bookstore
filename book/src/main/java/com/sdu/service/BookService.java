package com.sdu.service;

import com.sdu.bean.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(Book book);
    public Book queryBookById(int id);
    public List<Book> queryBooks();

}
