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
    BookService bookService = new BookService();
    BookRepository bookRepos = new BookRepository();
    MemberRepository memberRepos = new MemberRepository();

    Book b1 = new Book("886-53-798-6928-1", "Een boek", "iemand", "voornaamiemand");
    Book b2 = new Book("978-90-274-3964-2", "Een ander boek", "van iemand anders", "voornaamEenAnder");
    Book b3 = new Book("491-87-192-6758-3", "Nog een boek", "nog iemand anders", "voornaamEenAnder");
    Book b4 = new Book("886-53-798-7125-3", "Een boektest", "van een auteur", "voornaamEenAnder");
    Book b5 = new Book("769-42-815-7432-4", "BoekjesBoekjes", "iemandiemand", "voornaamiemand");

    Member member1 = new Member("556", "Elize", "Lodewycks", "eenStraat", 12, 9999, "verWeg");
    Member member2 = new Member("459", "Jens", "Devriendt", "eenAndereStraat", 56, 1569, "ergens");
    Member member3 = new Member("59", "Kevin", "familienaam", "eenDerdeStraat", 45, 789, "ergensAnders");

    @Before
    public void AddBooksToRepos(){
        bookRepos.addBook(b1);
        bookRepos.addBook(b2);
        bookRepos.addBook(b3);
    }

    @Test
    public void listAllBookTest() {
        List<Book> testList = new ArrayList<Book>();
        testList.add(b1);
        testList.add(b2);
        testList.add(b3);
        Assertions.assertThat(testList).isEqualTo(bookRepos.getAllBooks());

    }

    @Test
    public void testSearchISBN() {
        Assertions.assertThat(bookRepos.searchByISBN("886-53-798-6928-1")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\nbook lended: true\r\n");
    }

    @Test
    public void testWithWildCard() {
        bookRepos.addBook(b4);
        Assertions.assertThat(bookRepos.searchByISBN("886-53-798")).isEqualTo("bookDetails\r\n" +
                "isbn: 886-53-798-6928-1\r\n" +
                "title: Een boek\r\n" +
                "author first name: voornaamiemand\r\n" +
                "author last name: iemand\r\nbook lended: true\r\nbookDetails\r\nisbn: 886-53-798-7125-3\r\ntitle: Een boektest\r\nauthor first name: voornaamEenAnder\r\nauthor last name: van een auteur\r\nbook lended: true\r\n");
    }

    @Test
    public void testNoBookFound() {
        Assertions.assertThat(bookRepos.searchByISBN("456-53-798")).isEqualTo("");
    }

    @Test
    public void testSearchTitle() {

        Assertions.assertThat(bookRepos.searchByTitle("Een boek")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\nbook lended: true\r\n");
    }

    @Test
    public void testWithWildCardTitle() {

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
        Assertions.assertThat(bookRepos.searchByTitle("blablabla")).isEqualTo("");
    }

    @Test
    public void testSearchAuthor() {
        Assertions.assertThat(bookRepos.searchByAuthor("voornaamiemand iemand")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\nbook lended: true\r\n");
    }

    @Test
    public void testWithWildCardAuthor() {
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
        Assertions.assertThat(bookRepos.searchByAuthor("blablabla")).isEqualTo("");
    }

    @Test
    public void testOnlyLastName() {
        Assertions.assertThat(bookRepos.searchByAuthor("iemand")).isEqualTo("bookDetails\r\nisbn: 886-53-798-6928-1\r\ntitle: Een boek\r\nauthor first name: voornaamiemand\r\nauthor last name: iemand\r\nbook lended: true\r\n");

    }

    @Test
    public void testEnhancedBook() {
        bookRepos.enhancedBook("886-53-798-7125-3", "Een boektest", "van een auteur", "voornaamEenAnder");
        List<Book> testList = new ArrayList<>();
        testList.add(b1);
        testList.add(b2);
        testList.add(b3);
        testList.add(new Book("886-53-798-6928-1", "Een boek", "iemand", "voornaamiemand"));
        Assertions.assertThat(bookRepos.getAllBooks()).isEqualTo(testList);
    }
}