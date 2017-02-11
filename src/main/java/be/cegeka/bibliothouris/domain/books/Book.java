package be.cegeka.bibliothouris.domain.books;

import static java.lang.System.lineSeparator;

public class Book {

    private final String isbn;
    private final String title;
    private String authorLastName;
    private String authorFirstName;
    private boolean lended;
    private String lenderInfo;

    public Book(String isbn, String title, String authorLastName, String authorFirstName) {
        this.isbn = isbn;
        this.title = title;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
        this.lended = false;
        this.lenderInfo = "";
    }

    public void setLenderInfo(String info) {
        lenderInfo = info;
    }

    public void setLended(boolean lended) {
        this.lended = lended;
    }

    public boolean isLended() {
        return lended;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder("bookDetails" + lineSeparator());
        sb.append("isbn: " + isbn + lineSeparator());
        sb.append("title: " + title + lineSeparator());
        sb.append("author first name: " + authorFirstName + lineSeparator());
        sb.append("author last name: " + authorLastName + lineSeparator());
        sb.append(getLendedMessage());
        return sb.toString();
    }

    private String getLendedMessage() {
        return lended ? getBookIsLendedMessage() : getBookIsNotLendedMessage();
    }

    private String getBookIsNotLendedMessage() {
        return "book is not lended: " + lended;
    }

    private String getBookIsLendedMessage() {
        return "book lended: " + lended + lenderInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (lended != book.lended) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (authorLastName != null ? !authorLastName.equals(book.authorLastName) : book.authorLastName != null)
            return false;
        return authorFirstName != null ? authorFirstName.equals(book.authorFirstName) : book.authorFirstName == null;
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (authorLastName != null ? authorLastName.hashCode() : 0);
        result = 31 * result + (authorFirstName != null ? authorFirstName.hashCode() : 0);
        result = 31 * result + (lended ? 1 : 0);
        return result;
    }
}