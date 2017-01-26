package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by elisel on 25/01/2017.
 */
public class BookRepositoryTest {
    BookRepository bookRepos = new BookRepository();
    Book b1 = new Book("886-53-798-6928-1", "Een boek", "iemand", "voornaamiemand");
    Book b2 = new Book("978-90-274-3964-2", "Een ander boek", "van iemand anders", "voornaamEenAnder");
    Book b3 = new Book("491-87-192-6758-3", "Nog een boek", "nog iemand anders", "voornaamEenAnder");
    Book b4 = new Book("886-53-798-7895-6", "Een boektest", "van een auteur", "voornaamEenAnder");
    Book b5 = new Book("698-78-988-4568-7", "BoekjesBoekjes", "iemandiemand", "voornaamiemand");

    @Test
    public void listAllBookTest()
    {
        List<Book> testList = new ArrayList<Book>();
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        testList.add(b1);
        testList.add(b2);
        testList.add(b3);
        Assertions.assertThat(testList).isEqualTo(bookRepos.getAllBooks());

    }
    @Test
    public void testSearchISBN() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByISBN("886-53-798-6928-1")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\n");
    }

    @Test
    public void testWithWildCard() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        bookRepos.addBook(b4);
        Assertions.assertThat(bookRepos.searchByISBN("886-53-798")).isEqualTo("bookDetails\r\n" +
                "isbn: 886-53-798-6928-1\r\n" +
                "title: Een boek\r\n" +
                "author first name: voornaamiemand\r\n" +
                "author last name: iemand\r\nbookDetails\r\nisbn: 886-53-798-7895-6\r\ntitle: Een boektest\r\nauthor first name: voornaamEenAnder\r\nauthor last name: van een auteur\r\n");
    }

    @Test
    public void testNoBookFound() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByISBN("456-53-798")).isEqualTo("");
    }

    @Test
    public void testSearchTitle() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByTitle("Een boek")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\n");
    }

    @Test
    public void testWithWildCardTitle() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        bookRepos.addBook(b4);
        Assertions.assertThat(bookRepos.searchByTitle("Een b")).isEqualTo("bookDetails\r\n" +
                "isbn: 886-53-798-6928-1\r\n" +
                "title: Een boek\r\n" +
                "author first name: voornaamiemand\r\n" +
                "author last name: iemand\r\nbookDetails\r\nisbn: 886-53-798-7895-6\r\ntitle: Een boektest\r\nauthor first name: voornaamEenAnder\r\nauthor last name: van een auteur\r\n");
    }

    @Test
    public void testNoBookFoundTitle() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByTitle("blablabla")).isEqualTo("");
    }






    @Test
    public void testSearchAuthor() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByAuthor("voornaamiemand iemand")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\n");
    }

    @Test
    public void testWithWildCardAuthor() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        bookRepos.addBook(b5);
        Assertions.assertThat(bookRepos.searchByAuthor("voornaamiemand")).isEqualTo("bookDetails\r\n" +
                "isbn: 886-53-798-6928-1\r\n" +
                "title: Een boek\r\n" +
                "author first name: voornaamiemand\r\n" +
                "author last name: iemand\r\nbookDetails\r\nisbn: 698-78-988-4568-7\r\ntitle: BoekjesBoekjes\r\nauthor first name: voornaamiemand\r\nauthor last name: iemandiemand\r\n");
    }

    @Test
    public void testNoBookFoundAuthor() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByAuthor("blablabla")).isEqualTo("");
    }

    @Test
    public void testOnlyLastName(){
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByAuthor("iemand")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\n");

    }
}