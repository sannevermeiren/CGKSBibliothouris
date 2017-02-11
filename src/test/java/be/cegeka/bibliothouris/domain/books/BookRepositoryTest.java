package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elisel on 25/01/2017.
 */
public class BookRepositoryTest {


    private BookRepository bookRepos;
    private Book b1;
    private Book b2;
    private Book b3;
    private Book b4;
    private Book b5;

    @Before
    public void setup() {
        bookRepos = new BookRepository();

        b1 = new Book("886-53-798-6928-1", "Een boek", "iemand", "voornaamiemand");
        b2 = new Book("978-90-274-3964-2", "Een ander boek", "van iemand anders", "voornaamEenAnder");
        b3 = new Book("491-87-192-6758-3", "Nog een boek", "nog iemand anders", "voornaamEenAnder");
        b4 = new Book("886-53-798-7125-3", "Een boektest", "van een auteur", "voornaamEenAnder");
        b5 = new Book("769-42-815-7432-4", "BoekjesBoekjes", "iemandiemand", "voornaamiemand");
    }

    @Test
    public void listAllBookTest() {
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
        Assertions.assertThat(bookRepos.searchByISBN("886-53-798-6928-1")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\nbook lended: true\r\n");
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
                "author last name: iemand\r\nbook lended: true\r\nbookDetails\r\nisbn: 886-53-798-7125-3\r\ntitle: Een boektest\r\nauthor first name: voornaamEenAnder\r\nauthor last name: van een auteur\r\nbook lended: true\r\n");
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
        Assertions.assertThat(bookRepos.searchByTitle("Een boek")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\nbook lended: true\r\n");
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
                "author last name: iemand\r\n" +
                "book lended: true\r\n" +
                "bookDetails\r\nisbn: 886-53-798-7125-3\r\ntitle: Een boektest\r\nauthor first name: voornaamEenAnder\r\nauthor last name: van een auteur\r\nbook lended: true\r\n");
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
        Assertions.assertThat(bookRepos.searchByAuthor("voornaamiemand iemand")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\nbook lended: true\r\n");
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
                "author last name: iemand\r\nbook lended: true\r\n" +
                "bookDetails\r\nisbn: 769-42-815-7432-4\r\ntitle: BoekjesBoekjes\r\nauthor first name: voornaamiemand\r\nauthor last name: iemandiemand\r\nbook lended: true\r\n");
    }

    @Test
    public void testNoBookFoundAuthor() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByAuthor("blablabla")).isEqualTo("");
    }

    @Test
    public void testOnlyLastName() {
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
        Assertions.assertThat(bookRepos.searchByAuthor("iemand")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\nbook lended: true\r\n");

    }

    @Test
    public void testEnhancedBook() {
        bookRepos.enhancedBook("886-53-798-6928-1", "Een boek", "iemand", "voornaamiemand");
        List<Book> testList = new ArrayList<>();
        testList.add(new Book("886-53-798-6928-1", "Een boek", "iemand", "voornaamiemand"));
        Assertions.assertThat(bookRepos.getAllBooks()).isEqualTo(testList);
    }
}