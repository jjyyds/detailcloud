package com.yc.springcloud812.security.service;


import com.yc.springcloud812.security.bean.Book;

import java.util.List;

public interface BookService {
    public Book getBook(Integer id);
    public List<Book> findAll();
}
