package be.cegeka.bibliothouris.domain.books;

/**
 * Created by elisel on 26/01/2017.
 */
public interface Validation {
    boolean validateISBNExists(String ISBN);
    boolean validateINSSExists(String INSS);
}
