package be.cegeka.bibliothouris.domain.books;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by elisel on 25/01/2017.
 */
public class BookRepositoryTest {
    BookRepository bookRepos = new BookRepository();
    Book b1 = new Book("886-53-798-6928-1", "Een boek", "iemand");
    Book b2 = new Book("978-90-274-3964-2", "Een ander boek", "van iemand anders");
    Book b3 = new Book("491-87-192-6758-3", "Nog een boek", "nog iemand anders");


    @Test
    public void testSearchISBN(){
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        bookRepos.searchByISBN("886-53-798-6928-1");
    }

    @Test
    public void testWithWildCard(){
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        bookRepos.searchByISBN("886-53-798");
    }

    @Test
    public void testNoBookFound(){
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        bookRepos.searchByISBN("456-53-798");
    }
}