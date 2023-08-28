package multimedia;

public class Ebook extends Book {
    public String format; 
    public double fileSize; 

    // Constructor
    public Ebook(String title, String description, String edition, String language, String author, String company, int isbn, int pages, int age, String format, double fileSize) {
        super(title, description, edition, language, author, company, isbn, pages, age);
        this.format = format;
        this.fileSize = fileSize;
    }

    //Methods
    public void download() {
        System.out.println("Downloading e-book");
    }
}
