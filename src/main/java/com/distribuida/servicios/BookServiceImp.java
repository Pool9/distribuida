package com.distribuida.servicios;

import com.distribuida.config.Dbconfig;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@ApplicationScoped
public class BookServiceImp implements BookService {
    private final Dbconfig dbconfig;
    List books = new ArrayList();
    {
        Book b1= new Book();
        b1.setId(1);
        b1.setTitle("title");
        b1.setAuthor("autor");
        b1.setPrice(30.24);
        books.add(b1);
        Book b2= new Book();
        b2.setId(1);
        b2.setTitle("title2");
        b2.setAuthor("autor2");
        b2.setPrice(30.56);
        books.add(b2);

    }

    @Inject
    public BookServiceImp(Dbconfig dbconfig) {
        this.dbconfig = dbconfig;
    }

    public Book findById(Integer id){
        Handle handle = dbconfig.conf().open();
        return handle.createQuery("SELECT * FROM books WHERE id = :id")
                .bind("id",id)
                .mapToBean(Book.class)
                .findOnly();

   }

    @Override
    public void insert(Book book) {
        Handle handle = dbconfig.conf().open();
        handle.createUpdate("INSERT INTO books (isbn,title,author,price) Values (:isbn,:title,:author,:price)")
                .bindBean(book)
                .executeAndReturnGeneratedKeys()
                .mapToBean(Book.class)
                .findOnly();
    }


    public void delete(Integer id) {
        Handle handle = dbconfig.conf().open();
        handle.createUpdate("DELETE FROM books WHERE id = :id")
                .bind("id",id)
                .execute();

    }

    public void update(Book book, Integer id) {
        Handle handle = dbconfig.conf().open();
        handle.createUpdate("UPDATE books SET isbn = :isbn,title = :title, author = :author,price = :price WHERE id = :id")
                .bindBean(book)
                .bind("id",id)
                .executeAndReturnGeneratedKeys()
                .mapToBean(Book.class)
                .findOnly();
    }


    /// listar libros
    @Override
    public List<Book> findAll() {
        Handle handle = dbconfig.conf().open();
        return handle.createQuery("SELECT * FROM books")
                .mapToBean(Book.class)
                .list();
    }

}
