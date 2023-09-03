package multimedia;

public class Ebook extends Item {
    public String format; 
    public String numberLicences; 
    public String url; 
    public String requirements; 
    public String avaliableDate;        //n sei oq é isso
    public double fileSize; 

    // Constructor
    public Ebook(String title, String author, String publisher, String publishmentYear, String genre, String synopsis,
            String language, String cover, String format, String numberLicences, String url, String requirements,
            String avaliableDate, double fileSize) {
        super(title, author, publisher, publishmentYear, genre, synopsis, language, cover);
        this.format = format;
        this.numberLicences = numberLicences;
        this.url = url;
        this.requirements = requirements;
        this.avaliableDate = avaliableDate;
        this.fileSize = fileSize;
    }
    

    //Methods
    public void download() {
        System.out.println("Downloading e-book");
    }
}
