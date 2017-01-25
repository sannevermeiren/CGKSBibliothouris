package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Author;
import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;
/**
 * Created by jensde on 25/01/2017.
 */

@Controller
@RequestMapping("/book")
public class LibraryController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Book> getBooks(){
        return bookService.getAllBooks();
    }
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addBook(@RequestParam(value = "title", required = true) String title,
                 @RequestParam(value = "author", required = true) String author){
        bookService.addBook(title, author);
    }
}
