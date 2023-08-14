public class Book {
    private String title;
    private String description;
    private String edition;
    private String language;
    private String author;
    private String company;
    private int isbn;
    private int pages;
    private int age;

    //Constructor
    public Book(String title, String description, String edition, String language, String author, String company, int isbn, int pages, int age) {
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.language = language;
        this.author = author;
        this.company = company;
        this.isbn = isbn;
        this.pages = pages;
        this.age = age;
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

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
