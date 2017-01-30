package be.cegeka.bibliothouris.domain.rentals;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class Rental {
    LocalDate dueDate;
    String inss;
    String isbn;

    public Rental(String isbn, String inss) {
        this.inss = inss;
        this.isbn = isbn;
        this.dueDate = LocalDate.now().plusWeeks(3);
    }

    public Rental(LocalDate dueDate, String inss, String isbn) {
        this.dueDate = dueDate;
        this.inss = inss;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getInss() {
        return inss;
    }
}