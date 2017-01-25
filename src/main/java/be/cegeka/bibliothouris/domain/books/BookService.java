package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/**
 * Created by jensde on 25/01/2017.
 */
@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;

    private final AtomicLong counter = new AtomicLong();

    public void addBook(String title, Author author){
        bookRepository.addBook(new Book(counter.incrementAndGet(), title, author));
    }
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
}
