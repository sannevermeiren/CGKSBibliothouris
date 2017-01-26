package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.members.Member;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;



    @Test
    public void addMember_ShouldCallUserRepository() throws Exception {
        bookService.addBook("123", "harry", "JK", "Rowling");

        verify(bookRepository).addBook(new Book("123", "harry", "JK", "Rowling"));
    }

    @Test
    public void getAllUsers() throws Exception {
        Book book1 = new Book("456", "lord of the rings", "jrr", "tolkien");
        Book book2 = new Book("159", "ilias", "homeros", "unknown");
        Book book3 = new Book("45", "titel", "auteursnaam", "auteursvoornaam");

        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        assertThat(bookService.getAllBooks()).containsOnly(book1, book2);
    }

}