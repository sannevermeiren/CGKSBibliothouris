package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;
import be.cegeka.bibliothouris.domain.books.Book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jensde on 25/01/2017.
 */
@Named
public class BookService {
    private MemberRepository memberRepository;






    @Inject
    private BookRepository bookRepository;
    private Book book;
    //   private final AtomicLong counter = new AtomicLong();

    public void addBook(String isbn, String title, String authorFirstName, String authorLastName) {
        bookRepository.addBook(new Book(isbn, title, authorFirstName, authorLastName));
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookByISBN(String ISBN) {
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

    public String searchByAuthor(String author) {
        return bookRepository.searchByAuthor(author);
    }

    public String getDetails(String title, String authorFirstName, String authorLastName,Boolean lended){return book.getDetails();}

    public void enhancedBook(String isbn, String title, String lastName, String firstName) {
        bookRepository.enhancedBook(isbn, title, lastName, firstName);
    }

   public void getlendABook (String isbn, String inss) {
       bookRepository.lendABook(isbn, inss);

   }
   public String getLendingMember (String isbn){return bookRepository.getLendingMember(isbn);
    }
}
