package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/book")
public class LibraryController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addBook(@RequestParam(value = "isbn", required = true) String isbn,
                 @RequestParam(value = "title", required = true) String title,
                 @RequestParam(value = "authorFirstName", required = true) String authorFirstName,
                 @RequestParam(value = "authorLastName", required = true) String authorLastName) {
        bookService.addBook(isbn, title, authorFirstName, authorLastName);
    }

    @RequestMapping(path = "/searchISBN", method = RequestMethod.GET)
    public
    @ResponseBody
    String searchByISBN(@RequestParam(value = "isbn", required = true) String isbn) {
        return bookService.searchByISBN(isbn);
    }

    @RequestMapping(path = "/enhancedEntry", method = RequestMethod.POST)
    @ResponseBody
    public void enhancedBook(@RequestParam(value = "isbn", required = true) String isbn,
                             @RequestParam(value = "title", required = true) String title,
                             @RequestParam(value = "lastName", required = true) String lastName,
                             @RequestParam(value = "firstName", required = false) String firstName) {
        bookService.enhancedBook(isbn, title, lastName, firstName);

    }

    @RequestMapping(path = "/searchTitle", method = RequestMethod.GET)
    @ResponseBody
    public String searchByTitle(@RequestParam(value = "title", required = true) String title) {
        return bookService.searchByTitle(title);
    }

    @RequestMapping(path = "/searchAuthor", method = RequestMethod.GET)
    @ResponseBody

    public String searchByAuthor(@RequestParam(value = "author", required = true) String author) {
        return bookService.searchByAuthor(author);
    }

    @RequestMapping(path = "/getDetails", method = RequestMethod.POST)
    @ResponseBody
    public String getDetails(@RequestParam(value = "title:", required = true) String title,
                             @RequestParam(value = "author first name:", required = true) String authorFirstName,
                             @RequestParam(value = "author last name: ", required = true) String authorLastName) {
        return bookService.getDetails(title, authorFirstName, authorLastName);
    }
}