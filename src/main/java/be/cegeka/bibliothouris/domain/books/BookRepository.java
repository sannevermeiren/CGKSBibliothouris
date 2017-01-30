package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;
import be.cegeka.bibliothouris.domain.rentals.Rental;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private List<String> isbnNumbers = new ArrayList<>();

    @Inject
    private MemberRepository memberRepository;
    @Inject
    private Book book;

    public List<Book> getAllBooks() {
        return books;
    }

    public List<String> getIsbnNumbers() {
        return isbnNumbers;
    }

    public void addBook(Book book) {
        books.add(book);
        isbnNumbers.add(book.getIsbn());
    }

    public void enhancedBook(String isbn, String title, String lastName, String firstName) {
        if ((isbn != null) && (title != null) && (lastName != null)) {
            books.add(new Book(isbn, title, lastName, firstName));

        } else {
            System.out.println("Invalid entry");
        }
    }

    public List<Book> getBookListISBN(String ISBN) {
        List<Book> outputList = new ArrayList<>();

        for (Book book : books) {
            String isbnBook = book.getIsbn();
            if (isbnBook.startsWith(ISBN)) {
                outputList.add(book);
            }
        }
        if (outputList.isEmpty()) {
            System.out.println("There is no book found.");
        }
        return outputList;
    }

    private List<Book> getbookListTitle(String title) {
        List<Book> outputList = new ArrayList<>();

        for (Book book : books) {
            String titleBook = book.getTitle();

            if (titleBook.startsWith(title)) {
                outputList.add(book);
            }
        }

        if (outputList.isEmpty()) {
            System.out.println("There is no book found.");
        }
        return outputList;
    }

    public List<Book> getbookListAuthor(String author) {
        List<Book> booklist = new ArrayList<>();
        for (Book book : books) {
            String fullName = book.getAuthorFirstName() + " " + book.getAuthorLastName();
            String lastName = book.getAuthorLastName();
            if (fullName.startsWith(author) || lastName.startsWith(author)) {
                booklist.add(book);
            }
            System.out.println("There is no book found.");
        }
        return booklist;
    }

    public String searchByISBN(String ISBN) {
        String output = "";
        List<Book> booklist = getBookListISBN(ISBN);
        for (Book book : booklist) {
            String det = book.getDetails();
            output += det + System.lineSeparator();
        }
        return output;
    }

    public Book getBookByISBN(String ISBN) {
        Book book = null;

        for (Book book1 : books) {
            String isbn = book.getIsbn();
            if (isbn.equals(ISBN)) {
                book = book1;
            }
        }
        return book;
    }

    public String searchByTitle(String title) {
        String output = "";
        List<Book> booklist = getbookListTitle(title);
        for (Book book : booklist) {
            String det = book.getDetails();
            output += det + System.lineSeparator();
        }
        return output;
    }

    public String searchByAuthor(String author) {
        String output = "";
        List<Book> booklist = getbookListAuthor(author);
        for (Book book : booklist) {
            output += book.getDetails() + System.lineSeparator();
        }
        return output;
    }

    public boolean validateISBNExists(String ISBN) {
        if (getIsbnNumbers().contains(ISBN)) {
            return true;
        }
        return false;
    }

    public String getEnhancedDetails(){
        return book.getDetails();
    }
}