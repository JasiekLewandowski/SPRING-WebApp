package programowanie.lewandowski.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import programowanie.lewandowski.demo.domain.Author;
import programowanie.lewandowski.demo.domain.Book;
import programowanie.lewandowski.demo.domain.Publisher;
import programowanie.lewandowski.demo.repositories.AuthorRepository;
import programowanie.lewandowski.demo.repositories.BookRepository;
import programowanie.lewandowski.demo.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("SFG Publishing","Miodowa 7", "St Petersburg", "Texas", "123C");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Design Driven Domain", "12312");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE withour EJB", "4356353");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Books of publisher: " + publisher.getBooks().size());

    }
}
