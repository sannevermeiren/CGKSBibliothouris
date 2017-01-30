package be.cegeka.bibliothouris.domain.rentals;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class RentalServiceTest {

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

        rentalService.lendABook("987", "556");
    }

    @Test
    public void lendABookWhenMemberDoesNotExists() {

        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        bookRepository.addBook(book3);

        memberRepository.addMember(member1);
        memberRepository.addMember(member2);
        memberRepository.addMember(member3);

        rentalService.lendABook("886-53-798-6928-1", "9887");
    }
}