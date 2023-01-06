package com.distribuida.servicios;


import com.distribuida.db.Book;

import java.util.List;

public interface BookService  {
    Book findById(Integer id);
    void insert(Book book);
    void delete(Integer id);
    void update(Book book, Integer id);

    List<Book>findAll();



}
