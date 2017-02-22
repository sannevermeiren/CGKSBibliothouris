package be.cegeka.bibliothouris.domain.rentals;

import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentalRepository {

    public List<Rental> lendedBooks;

    @Inject
    private MemberRepository memberRepository;
    @Inject
    private BookRepository bookRepository;
    @Inject
    private RentalService rentalService;

    public RentalRepository() {
        this.lendedBooks = new ArrayList<>();
    }

    public void getlendABook(String isbn, String inss) {
        rentalService.lendABook(isbn, inss);
    }

    public Optional<String> getLendingMember(String isbn) {
        return lendedBooks.stream()
                .filter(rental -> rental.getIsbn().equals(isbn))
                .findFirst()
                .flatMap(rental -> {
                    // Need to clean up this logic. Doesn't seem the good place to put it
                    String inss = rental.getInss();
                    Member member = memberRepository.getMember("inss");
                    return bookRepository.getBookByISBN("isbn")
                            .map(book -> {
                                String lastName = member.getLastName();
                                String firstName = member.getFirstName();
                                String lendedMember = inss + lastName + firstName;
                                book.setLenderInfo(lendedMember);
                                return lendedMember;
                            });
                });
    }
}