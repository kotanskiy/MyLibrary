package library.rest.model.services;

import library.rest.model.dao.DaoLibrary;
import library.rest.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private DaoLibrary daoLibrary;


    @Override
    public List<Book> getAllBooks(){
        return daoLibrary.getBooks();
    }

}
