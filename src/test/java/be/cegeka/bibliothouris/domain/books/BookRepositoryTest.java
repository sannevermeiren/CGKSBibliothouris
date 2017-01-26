package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
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
    Book b4 = new Book("886-53-798-7895-6", "een test boek", "van een auteur");


    @Test
    public void testSearchISBN() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByISBN("886-53-798-6928-1")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor: iemand\r\n");
    }

    @Test
    public void testWithWildCard() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        bookRepos.addBook(b4);
        Assertions.assertThat(bookRepos.searchByISBN("886-53-798")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor: iemand\r\nbookDetails\r\nisbn: 886-53-798-7895-6\r\ntitle: een test boek\r\nauthor: van een auteur\r\n");
    }

    @Test
    public void testNoBookFound() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByISBN("456-53-798")).isEqualTo("");
    }
}