package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.members.MemberRepository;
import be.cegeka.bibliothouris.domain.rentals.RentalRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class BookService {

    @Inject
    private MemberRepository memberRepository;
    //@Inject
    private BookRepository bookRepository;
    //@Inject
    private RentalRepository rentalRepository;
    //   private final AtomicLong counter = new AtomicLong();

    public void addBook(String isbn, String title, String authorFirstName, String authorLastName) {
         bookRepository.addBook(new Book(isbn, title, authorFirstName, authorLastName));
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Optional<Book> getBookByISBN(String ISBN) {
        return bookRepository.getBookByISBN(ISBN);
    }

    public String searchByISBN(String ISBN) {
        return bookRepository.searchByISBN(ISBN);
    }

    public List<String> getIsbnNumbers() {
        return bookRepository.getIsbnNumbers();
    }

    public String searchByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }

    public String searchByAuthor (String author) {
        return bookRepository.searchByAuthor(author);
    }

    public String getDetails(String title, String authorFirstName, String authorLastName){
        return bookRepository.getDetails();}

    public void enhancedBook(String isbn, String title, String lastName, String firstName) {
        bookRepository.enhancedBook(isbn, title, lastName, firstName);
    }
}