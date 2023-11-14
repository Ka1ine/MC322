package biblioteca.models.Itens;

public class Book extends Item implements IItemMultimediaFactory {
    private String isbn;
    private String edition;
    private String location;
    private String conservation;

    // Constructor
    public Book(String title, String author, int codigo, String publisher, int publishmentYear, String genre, String synopsis,
            String language, String cover, String detalhes, String isbn, String edition, int numberCopies, int avaliableCopies,
            String location, String conservation) {
        super(title, author, codigo, publisher, publishmentYear, genre, synopsis, language, cover, detalhes);
        this.isbn = isbn;
        this.edition = edition;
        this.location = location;
        this.conservation = conservation;
        this.numberCopies = numberCopies;
        this.avaliableCopies = avaliableCopies;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getConservation() {
        return conservation;
    }

    public void setConservation(String conservation) {
        this.conservation = conservation;
    }

    @Override
    public Item createItem() {
        return new Book(getTitle(), getAuthor(), getCodigo(), getPublisher(), getPublishmentYear(), getGenre(),
                getSynopsis(), getLanguage(), getCover(), getDetalhes(), getIsbn(), getEdition(), getNumberCopies(),
                getAvaliableCopies(), getLocation(), getConservation());
    }
}
