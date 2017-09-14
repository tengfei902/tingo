package com.tingo.hessian;

import com.caucho.hessian.server.HessianServlet;
import com.tingo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by user on 17/9/13.
 */
public class BookApi extends HessianServlet {
    @Autowired
    private IBookService bookService;

    public List<Book> getBookList() {
        List<Book> books = bookService.getList();
        return books;
    }
}
