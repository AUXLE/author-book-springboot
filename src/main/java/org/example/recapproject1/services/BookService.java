package org.example.recapproject1.services;

import org.example.recapproject1.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
