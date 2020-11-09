package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher p1 = new Publisher("Goldmann","Butzelstr. 1", "Butzelbach","12345","Schweiz");
        publisherRepository.save(p1);

        Author a1 = new Author("Eric","Cartman");
        Book b1 = new Book("IT","ABC1234");
        b1.setPublisher(p1);
        p1.getBooks().add(b1);
        a1.getBooks().add(b1);
        b1.getAuthorSet().add(a1);

        authorRepository.save(a1);
        bookRepository.save(b1);
        publisherRepository.save(p1);

        Author a2 = new Author("Bobby","Brown");
        Book b2 = new Book("Leisure Suite","avcbdsiu123");
        b2.setPublisher(p1);
        a2.getBooks().add(b2);
        p1.getBooks().add(b2);
        b2.getAuthorSet().add(a2);
        authorRepository.save(a2);
        bookRepository.save(b2);
        publisherRepository.save(p1);

    }
}
