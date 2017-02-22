package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.members.MemberRepository;
import be.cegeka.bibliothouris.domain.rentals.Rental;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//@Named
public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private List<String> isbnNumbers = new ArrayList<>();


    public List<Rental> lendedBooks;

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
        if (!(validateISBNExists(book.getIsbn()))) {
            books.add(book);
            isbnNumbers.add(book.getIsbn());
        } else {
            System.out.println("Book already exists");
        }
    }

    public void enhancedBook(String isbn, String title, String lastName, String firstName) {
        if ((isbn != null) && (title != null) && (lastName != null)) {
            addBook(new Book(isbn, title, lastName, firstName));

        } else {
            System.out.println("Invalid entry");
        }
    }


    public List<Book> getBookListISBN(String ISBN) {
        List<Book> result = new ArrayList<>();
        Stream<Book> bookStream = result.stream();
        Pattern input = Pattern.compile("");
        result = bookStream.filter(book -> input.matcher(book.getIsbn()).matches()).collect(toList());
        return result;
    }

    private List<Book> getbookListTitle(String title) {
        // Use Stream api for more readable code
        return books.stream()
                .filter(book -> book.getTitle().startsWith(title))
                .collect(toList());
    }

    public List<Book> getbookListAuthor(String author) {
        // Use Stream api for more readable code
        // Put logic with Object it belongs: logic for creating the full name of the author doesn't belong here.
        // I moved it in a method on Book, but you probably want to create an Author Object.
        return books.stream()
                .filter(book -> book.getAuthorFullName().startsWith(author) ||
                        book.getAuthorLastName().startsWith(author))
                .collect(toList());
    }

 /*   public String searchByISBN(String ISBN) {
        String output = "";
        List<Book> booklist = getBookListISBN(ISBN);
        for (Book book : booklist) {
            String det = book.getDetails();
            output += det + System.lineSeparator();
        }
        return output;
    }*/

    public String searchByISBN(String ISBN){
        // Use stream API
        return lookForBooksWithThisISBN(ISBN).stream()
                .map(book -> book.getDetails())
                .collect(joining("\r\n"));
    }

    private List<Book> lookForBooksWithThisISBN(String ISBN) {
        List<Book> returnList = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().matches(".*" + ISBN + ".*")){
                returnList.add(book);
            }
        }
        return returnList;
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

    public String getDetails() {
        return book.getDetails();
    }


}

