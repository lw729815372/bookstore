package com.sdu.service;

import com.sdu.bean.Book;
import com.sdu.dao.bookDao.BookDao;
import com.sdu.dao.bookDao.BookDaoImpl;

import java.util.List;

public class BookServiceImpl implements BookService{
    BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.query4oneBook(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.query4allBooks();
    }
}
