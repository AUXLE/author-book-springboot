package org.example.recapproject1.repositories;

import org.example.recapproject1.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
