package library.rest.model.services;

import library.rest.model.entity.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 19.11.2016.
 */
public interface LibraryService {
    @Transactional
    List<Book> getAllBooks();
}
