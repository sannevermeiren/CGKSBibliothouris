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
public class BookRepository implements Search {
    private List<Book> books = new ArrayList<>();

<<<<<<< HEAD
    public List<Book> getAllBooks(){
        return books;
    }

    public void addBook(Book book){
=======
    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
>>>>>>> 87b886bd0e129a470ad1347ba37f71e8e827a270
        books.add(book);
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
            output+= det + System.lineSeparator();
        }
            System.out.println(output);
        return output;
    }
}
