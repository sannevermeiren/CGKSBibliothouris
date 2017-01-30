package be.cegeka.bibliothouris.domain.rentals;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.members.MemberRepository;

import javax.inject.Inject;

public class RentalService {

    @Inject
    private RentalRepository rentalRepository;
    @Inject
    private MemberRepository memberRepository;
    @Inject
    private BookRepository bookRepository;

    public String getLendingMember(String isbn) {
        return rentalRepository.getLendingMember(isbn);
    }

    public void lendABook(String isbn, String inss) {
        if (bookRepository.validateISBNExists(isbn)) {
            Rental len = new Rental(isbn, inss);
            rentalRepository.lendedBooks.add(len);
            Book book = bookRepository.getBookByISBN(isbn);
            book.setLended(true);
        } else {
            System.out.println("This book does not exists.");
        }
    }
}