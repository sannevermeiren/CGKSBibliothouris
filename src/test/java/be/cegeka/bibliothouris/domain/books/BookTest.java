package be.cegeka.bibliothouris.domain.books;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

/**
 * Created by paulienl on 25/01/2017.
 */
public class BookTest {

    Book book =  new Book("978-90-27-3964-2", "Harry Potter", "Rowling", "JK");

    @Test
    public void getIsbn() throws Exception {
        Assertions.assertThat(book.getIsbn()).isEqualTo("978-90-27-3964-2");
    }

    @Test
    public void getTitle() throws Exception {
        Assertions.assertThat(book.getTitle()).isEqualTo("Harry Potter");

    }

    @Test
    public void getAuthor() throws Exception {
        Assertions.assertThat(book.getAuthorFirstName()).isEqualTo("JK");
    }

    @Test
    public void getAuthorLastName() throws Exception {
        Assertions.assertThat(book.getAuthorLastName()).isEqualTo("Rowling");
    }

    @Test
    public void getDetailsTest() {
        Assertions.assertThat(book.getDetails()).isEqualTo("bookDetails" +"\r\n" + "isbn: " + book.getIsbn() + "\r\n" + "title: " + book.getTitle() + "\r\n" + "author first name: " + book.getAuthorFirstName() + "\r\n"+ "author last name: " +book.getAuthorLastName());
    }

}