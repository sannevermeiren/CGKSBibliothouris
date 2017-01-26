package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jensde on 25/01/2017.
 */
@Named
<<<<<<< HEAD
public class BookService implements Validation {
    private MemberRepository memberRepository;
=======
public class BookService  {
>>>>>>> 9090def22b9eb3741b76d9b8bbb2fe693278345b
    public List<LendABook> lendedBooks;

    public BookService() {
        this.lendedBooks = new ArrayList<>();
    }


    @Inject
    private BookRepository bookRepository;

    //   private final AtomicLong counter = new AtomicLong();

    public void addBook(String isbn, String title, String authorFirstName, String authorLastName) {
        bookRepository.addBook(new Book(isbn, title, authorFirstName, authorLastName));
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
    public Book getBookByISBN(String ISBN){
        return bookRepository.getBookByISBN(ISBN);
    }

    public String searchByISBN(String ISBN) {
        return bookRepository.searchByISBN(ISBN);
    }
    public List<String> getIsbnNumbers(){
        return bookRepository.getIsbnNumbers();
    }

    public String searchByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }

    public String searchByAuthor(String author) {
        return bookRepository.searchByAuthor(author);
    }

    public void enhancedBook(String isbn, String title, String lastName, String firstName) {
        bookRepository.enhancedBook(isbn, title, lastName, firstName);
    }

    public void lendABook(String isbn, String inss) {

    }



<<<<<<< HEAD
    @Override
    public boolean validateINSSExists(String INSS) {
        return false;
    }
    public String getLendingMember (String isbn){
        String lendedMember ="";
        Book book1=null;
        for (LendABook lendedBook : lendedBooks) {
            if(lendedBook.getIsbn().equals(isbn)){
                String inss = lendedBook.getInss();
                Member member = memberRepository.getMember("inss");
                 book1 = bookRepository.getBookOnIsbn("isbn");

                String lastName = member.getLastName();
                String firstName = member.getFirstName();
                lendedMember = inss + lastName + firstName;
            }

        }
        book1.setLenderInfo(lendedMember);
        return lendedMember;
    }


=======
>>>>>>> 9090def22b9eb3741b76d9b8bbb2fe693278345b
}