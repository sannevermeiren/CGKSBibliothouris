package be.cegeka.bibliothouris.domain.rentals;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.members.Member;

import java.util.ArrayList;

/**
 * Created by stevene on 30/01/2017.
 */
public class RentalRepository {



    public BookRepository() {
        this.lendedBooks = new ArrayList<>();
    }


    public String getLendingMember(String isbn) {
        String lendedMember = "";
        Book book1 = null;
        for (Rental lendedBook : lendedBooks) {
            if (lendedBook.getIsbn().equals(isbn)) {
                String inss = lendedBook.getInss();
                Member member = memberRepository.getMember("inss");
                book1 = getBookByISBN("isbn");

                String lastName = member.getLastName();
                String firstName = member.getFirstName();
                lendedMember = inss + lastName + firstName;
            }
        }
        book1.setLenderInfo(lendedMember);
        return lendedMember;
    }
}
