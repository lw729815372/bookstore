package com.sdu.dao.bookDao;

import com.sdu.bean.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deleteBook(int id);
    public int updateBook(Book book);
    public Book query4oneBook(int id);
    public List<Book> query4allBooks();
}
