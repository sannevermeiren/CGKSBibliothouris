package be.cegeka.bibliothouris.domain.books;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

/**
 * Created by elisel on 26/01/2017.
 */
public class LendABook {
    LocalDate dueDate;
    String inss;
    String isbn;

    public LendABook(String isbn, String inss) {
        this.inss = inss;
        this.isbn = isbn;
        this.dueDate = LocalDate.now().plusWeeks(3);
    }

    public LendABook(LocalDate dueDate, String inss, String isbn) {
        this.dueDate = dueDate;
        this.inss = inss;
        this.isbn = isbn;
    }
}
