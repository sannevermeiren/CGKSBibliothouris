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
public class BookService {
    private MemberRepository memberRepository;

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
<<<<<<< HEAD
    public String searchByAuthor(String author){
=======

    public String searchByAuthor(String author) {
>>>>>>> 719f3bfca10e4702433418b68390a82d55c7d901
        return bookRepository.searchByAuthor(author);
    }

    public void enhancedBook(String isbn, String title, String lastName, String firstName) {
        bookRepository.enhancedBook(isbn, title, lastName, firstName);
    }

    public void lendABook(String isbn, String inss) {
        if (bookRepository.validateISBNExists(isbn)){
            LendABook len = new LendABook(isbn,inss);
            lendedBooks.add(len);
            Book book = getBookByISBN(isbn);
            book.setLended(true);
        } else{
            System.out.println("This book does not exists.");
        }}


    public String getLendingMember(String isbn) {
        String lendedMember = "";
        Book book1 = null;
        for (LendABook lendedBook : lendedBooks) {
            if (lendedBook.getIsbn().equals(isbn)) {
                String inss = lendedBook.getInss();
                Member member = memberRepository.getMember("inss");
                book1 = bookRepository.getBookByISBN("isbn");

                String lastName = member.getLastName();
                String firstName = member.getFirstName();
                lendedMember = inss + lastName + firstName;
            }

        }
        book1.setLenderInfo(lendedMember);
        return lendedMember;
    }
<<<<<<< HEAD
    public void enhancedBook (String isbn, String title , String lastName, String firstName){bookRepository.enhancedBook(isbn,title, lastName,firstName);}
=======

>>>>>>> 719f3bfca10e4702433418b68390a82d55c7d901

}
