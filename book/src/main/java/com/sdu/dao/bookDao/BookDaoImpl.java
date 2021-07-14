package com.sdu.dao.bookDao;

import com.sdu.bean.Book;
import com.sdu.dao.BaseDao;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`sales`,`price`,`stock`,`img_path`) values(?,?,?,?,?,?)";

        return update(sql,book.getName(),book.getAuthor(),book.getSales(),book.getPrice(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBook(int id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?, `author`=?, `sales`=?, `price`=?, `stock`=?, `img_path`=? where id = ?";

        return update(sql,book.getName(),book.getAuthor(),book.getSales(),book.getPrice(), book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book query4oneBook(int id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where id =?";
        return queryOneBean(Book.class,sql,id);
    }

    @Override
    public List<Book> query4allBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book";
        return getListBeans(Book.class,sql);
    }
}
