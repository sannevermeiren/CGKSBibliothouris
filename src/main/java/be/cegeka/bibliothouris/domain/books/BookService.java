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

 //   private final AtomicLong counter = new AtomicLong();

    public void addBook(String isbn, String title, String authorFirstName, String authorLastName){
        bookRepository.addBook(new Book(isbn, title, authorFirstName, authorLastName));
    }
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

}
