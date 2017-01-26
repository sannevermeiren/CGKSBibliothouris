package be.cegeka.bibliothouris.domain.books;

/**
 * Created by jensde on 25/01/2017.
 */
public class Book {

    private final String isbn;
    private final String title;
    private String authorLastName;
    private String authorFirstName;

    public Book(String isbn, String title, String authorLastName, String authorFirstName) {
        this.isbn = isbn;
        this.title = title;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
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

    public String getAuthorLastName() { return authorLastName; }

    public String getDetails(){
        StringBuilder sb = new StringBuilder("bookDetails\r\n");

        sb.append("isbn: " + isbn+System.lineSeparator());
        sb.append("title: " + title+System.lineSeparator());
        sb.append("author first name: " + authorFirstName+"\r\n");
        sb.append("author last name: " + authorLastName);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!isbn.equals(book.isbn)) return false;
        if (!title.equals(book.title)) return false;
        if (!authorLastName.equals(book.authorLastName)) return false;
        return authorFirstName.equals(book.authorFirstName);
    }

    @Override
    public int hashCode() {
        int result = isbn.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + authorLastName.hashCode();
        result = 31 * result + authorFirstName.hashCode();
        return result;
    }
}
