package be.cegeka.bibliothouris.domain.rentals;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

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

    public String getLendingMember(String isbn) {
        String lendedMember = "";
        Book book1 = null;
        for (Rental lendedBook : lendedBooks) {
            if (lendedBook.getIsbn().equals(isbn)) {
                String inss = lendedBook.getInss();
                Member member = memberRepository.getMember("inss");
                book1 = bookRepository.getBookByISBN("isbn");

                String lastName = member.getLastName();
                String firstName = member.getFirstName();
                lendedMember = inss + lastName + firstName;
            }
        }
        book1.setLenderInfo(lendedMember);
        return lendedMember;
    }
}