package be.cegeka.bibliothouris.domain.books;

/**
 * Created by jensde on 25/01/2017.
 */
public class Book {

    private final String isbn;
    private final String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String getDetails(){
        StringBuilder sb = new StringBuilder("bookDetails\r\n");
        sb.append("isbn: " + isbn + "\r\n");
        sb.append("title: " + title + "\r\n");
        sb.append("author: " + author);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!isbn.equals(book.isbn)) return false;
        if (!title.equals(book.title)) return false;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = isbn.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
