package be.cegeka.bibliothouris.domain.rentals;

import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.members.MemberRepository;

import javax.inject.Inject;
import java.util.Optional;

public class RentalService {

    @Inject
    private RentalRepository rentalRepository;
    @Inject
    private MemberRepository memberRepository;
    @Inject
    private BookRepository bookRepository;

    public Optional<String> getLendingMember(String isbn) {
        return rentalRepository.getLendingMember(isbn);
    }

    public void lendABook(String isbn, String inss) {
        bookRepository.getBookByISBN(isbn)
                .ifPresent(book -> {
                    Rental len = new Rental(isbn, inss);
                    rentalRepository.lendedBooks.add(len);
                    book.setLended(true);
                });
    }
}