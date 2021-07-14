package com.sdu.web;

import com.sdu.bean.Book;
import com.sdu.dao.bookDao.BookDao;
import com.sdu.dao.bookDao.BookDaoImpl;
import com.sdu.service.BookService;
import com.sdu.service.BookServiceImpl;
import com.sdu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    protected void list(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void addBook(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        Book book = WebUtils.copyParamtoBean(req.getParameterMap(), new Book());
        bookService.addBook(book);


    }

}
