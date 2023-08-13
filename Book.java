public class Book {
    private String title;
    private String description;
    private String edition;
    private String language;
    private String author;
    private String isbn;

    public Book(String title, String description, String edition, String language, String author, String isbn) {
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.language = language;
        this.author = author;
        this.isbn = isbn;
    }

    // Get and Set
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getEdition() {
        return edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

     public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    

}
