public class Book {
    public String title;
    public String description;
    public String edition;
    public String language;
    public String author;
    public String company;
    public int isbn;
    public int pages;
    public int age;

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

    //Methods
    public void borrow(){
        System.out.println("Pegando livro");
    }
    public void giveBack(){
        System.out.println("Devolvendo livro");
    }
}
