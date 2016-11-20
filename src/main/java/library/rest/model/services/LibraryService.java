package library.rest.model.services;

import library.rest.model.entity.Book;

import java.util.List;

/**
 * Created by Admin on 19.11.2016.
 */

public interface LibraryService {
    List<Book> getAllBooks();
}
