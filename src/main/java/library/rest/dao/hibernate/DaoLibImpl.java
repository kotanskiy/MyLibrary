package library.rest.dao.hibernate;


import library.rest.dao.DaoLibrary;
import library.rest.model.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DaoLibImpl implements DaoLibrary {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getBooks() {
        return sessionFactory.getCurrentSession().createQuery("from Book").list();
    }

    @Override
    public void create(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public void delete(Book book) {
        sessionFactory.getCurrentSession().createQuery("delete Book where id = :id").setParameter("id", book.getId()).executeUpdate();
    }

    @Override
    public List<Book> getByName(String name) {
        return sessionFactory.getCurrentSession().createQuery("from Book where name =:name").setParameter("name", name).list();
    }
}
