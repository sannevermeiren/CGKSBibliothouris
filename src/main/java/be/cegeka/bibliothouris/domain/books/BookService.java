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
    private List<LendABook> lendedBooks;

    @Inject
    private BookRepository bookRepository;

 //   private final AtomicLong counter = new AtomicLong();

    public void addBook(String isbn, String title, String authorFirstName, String authorLastName){
        bookRepository.addBook(new Book(isbn, title, authorFirstName, authorLastName));
    }
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    public String searchByISBN(String ISBN){
        return bookRepository.searchByISBN(ISBN);
    }
    public String searchByTitle(String title){
        return bookRepository.searchByTitle(title);
    }
    public String searchByAuthor(String author){
        return bookRepository.searchByAuthor(author);
    }

    public LendABook lendABook(String isbn, String inss){
        LendABook len = new LendABook(inss, isbn);
        lendedBooks.add(len);
        return len;
    }

}
