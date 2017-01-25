package be.cegeka.bibliothouris.domain.books;

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

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> searchByISBN(String ISBN) {
        List<Book> outputList = new ArrayList<>();

        for (Book book : books) {
            String isbnBook = book.getIsbn();
            if (isbnBook.startsWith(ISBN)) {
                System.out.println(book.getTitle());
                outputList.add(book);
            }
        }

        if (outputList.isEmpty()){
            System.out.println("There is no book found.");
        }
        return outputList;
    }
}
