package library.rest.model.dao;

import library.rest.model.entity.Book;
import org.hibernate.SessionFactory;

import java.util.List;

public interface DaoLibrary {
    void setSessionFactory(SessionFactory sessionFactory);

    List<Book> getBooks();

    void create(Book book);

    void delete(Book book);

    List<Book> getByName(String name);
}
