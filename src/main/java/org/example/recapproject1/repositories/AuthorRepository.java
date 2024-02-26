package org.example.recapproject1.repositories;

import org.example.recapproject1.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
