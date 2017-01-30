package be.cegeka.bibliothouris.domain.books;

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
        StringBuilder sb = new StringBuilder("bookDetails\r\n");

        sb.append("isbn: " + isbn + System.lineSeparator());
        sb.append("title: " + title + System.lineSeparator());
        sb.append("author first name: " + authorFirstName + System.lineSeparator());
        sb.append("author last name: " + authorLastName + System.lineSeparator());
        if (lended = true) {
            sb.append("book lended: " + lended + lenderInfo);

            return sb.toString();
        } else {
            sb.append("book is not lended: " + lended);
            return sb.toString();
        }
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