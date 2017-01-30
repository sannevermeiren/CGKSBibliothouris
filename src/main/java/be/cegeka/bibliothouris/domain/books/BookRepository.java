package be.cegeka.bibliothouris.domain.books;

import org.apache.commons.lang3.StringUtils;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Created by jensde on 25/01/2017.
 */
@Named
public class BookRepository implements Search, Validation {
    private List<Book> books = new ArrayList<>();
    private List<String> isbnNumbers = new ArrayList<>();


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


    @Override
    public String searchByISBN(String ISBN) {
        String output = "";
        List<Book> booklist = getBookListISBN(ISBN);
        for (Book book : booklist) {
            String det = book.getDetails();
            output += det + System.lineSeparator();
        }
        return output;
    }

    @Override
    public String searchByTitle(String title) {
        String output = "";
        List<Book> booklist = getbookListTitle(title);
        for (Book book : booklist) {
            String det = book.getDetails();
            output += det + System.lineSeparator();
        }
        return output;
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

    @Override
    public String searchByAuthor(String author) {
        String output = "";
        List<Book> booklist = getbookListAuthor(author);
        for (Book book : booklist) {
            output += book.getDetails() + System.lineSeparator();
        }

        return output;
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

    public void enhancedBook(String isbn, String title, String lastName, String firstName) {
        if ((isbn != null) && (title != null) && (lastName != null)) {
            books.add(new Book(isbn, title, lastName, firstName));

        } else {
            System.out.println("Invalid entry");
        }
    }

    public Book getBookByISBN(String ISBN ){
        for (Book book : books) {
            String isbn = book.getIsbn();
            if (isbn.equals(ISBN)){
                return book;
            }
        }
        System.out.println("This book does not exists.");
        return null;
    }

    @Override
    public boolean validateISBNExists(String ISBN) {
        if (getIsbnNumbers().contains(ISBN)){
            return true;
        }
        return false;
    }

    @Override
    public boolean validateINSSExists(String INSS) {
        return false;
    }


}
