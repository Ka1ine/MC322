package multimedia;

public class Book extends Item{
    private String isbn;
    private String edition;
    private int numberCopies;
    private int avaliableCopies;
    private String location;
    private String conservation;
    
    public Book (String title, String author, String publisher, String publishmentYear, String genre, String synopsis,
                 String language, String cover, String type, String isbn, String edition, int numberCopies,
                 int avaliableCopies, String location, String conservation) {
        super(title, author, publisher, publishmentYear, genre, synopsis, language, cover);
        this.isbn = isbn;
        this.edition = edition;
        this.numberCopies = numberCopies;
        this.avaliableCopies = avaliableCopies;
        this.location = location;
        this.conservation = conservation;
    }

}
