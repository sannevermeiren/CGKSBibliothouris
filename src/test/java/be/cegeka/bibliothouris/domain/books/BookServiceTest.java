package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;
import be.cegeka.bibliothouris.domain.rentals.RentalService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;
    @InjectMocks
    private RentalService rentalService;

    @Mock
    private BookRepository bookRepository;
    @Mock
    private MemberRepository memberRepository;

    Book book1 = new Book("886-53-798-6928-1", "lord of the rings", "jrr", "tolkien");
    Book book2 = new Book("978-90-274-3964-2", "ilias", "homeros", "unknown");
    Book book3 = new Book("491-87-192-6758-3", "titel", "auteursnaam", "auteursvoornaam");

    Member member1 = new Member("556", "Elize", "Lodewycks", "eenStraat", 12, 9999, "verWeg");
    Member member2 = new Member("459", "Jens", "Devriendt", "eenAndereStraat", 56, 1569, "ergens");
    Member member3 = new Member("59", "Kevin", "familienaam", "eenDerdeStraat", 45, 789, "ergensAnders");

    @Test
    public void bookAddTest() throws Exception {
        bookService.addBook("123", "harry", "JK", "Rowling");
        verify(bookRepository).addBook(new Book("123", "harry", "JK", "Rowling"));
    }

    @Test
    public void getAllUsers() throws Exception {
        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
        assertThat(bookService.getAllBooks()).containsOnly(book1, book2);
    }

    @Test
    public void lendABookTest() {

        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        bookRepository.addBook(book3);
        memberRepository.addMember(member1);
        memberRepository.addMember(member2);
        memberRepository.addMember(member3);

        rentalService.lendABook("886-53-798-6928-1", "556");
    }

    @Test
    public void lendABookWhenBookNotExists() {

        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        bookRepository.addBook(book3);
        memberRepository.addMember(member1);
        memberRepository.addMember(member2);
        memberRepository.addMember(member3);

    }
}