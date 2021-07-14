package com.sdu.test;

import com.sdu.bean.Book;
import com.sdu.dao.bookDao.BookDao;
import com.sdu.dao.bookDao.BookDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(0,"纯牛奶","光明",2.54,100,2000,null));
    }

    @Test
    public void deleteBook() {
        System.out.println(bookDao.deleteBook(21));
    }

    @Test
    public void updateBook() {
        System.out.println(bookDao.updateBook(new Book(20, "海明威传记", "海明威", 39.9, 5000, 200, null)));
    }

    @Test
    public void query4oneBook() {
        System.out.println(bookDao.query4oneBook(20));
    }

    @Test
    public void query4allBooks() {
        List<Book> books = bookDao.query4allBooks();
        System.out.println(books);
    }
}