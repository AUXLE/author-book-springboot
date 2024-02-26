package org.example.recapproject1.bootstrap;

import org.example.recapproject1.domain.Author;
import org.example.recapproject1.domain.Book;
import org.example.recapproject1.domain.Publisher;
import org.example.recapproject1.repositories.AuthorRepository;
import org.example.recapproject1.repositories.BookRepository;
import org.example.recapproject1.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author robert = new Author();
        robert.setFirstName("Robert");
        robert.setLastName("Greene");

        Book laws = new Book();
        laws.setTitle("Laws of Power");
        laws.setIsbn("12345");

        Publisher rockwell = new Publisher();
        rockwell.setPublisherName("Rockwell");
        rockwell.setAddress("123, Main St");
        rockwell.setCity("Miami");
        rockwell.setState("Florida");
        rockwell.setZipcode("123456");

        Author robertSave = authorRepository.save(robert);
        Book lawsSave = bookRepository.save(laws);
        Publisher rockwellSave = publisherRepository.save(rockwell);

        robertSave.getBooks().add(lawsSave);
        lawsSave.getAuthors().add(robertSave);

        lawsSave.setPublisher(rockwellSave);

        authorRepository.save(robertSave);
        bookRepository.save(lawsSave);

        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Books count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
