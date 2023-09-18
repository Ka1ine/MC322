package biblioteca.models.Itens;

public class OtherMedia extends Item {
    private String type;
    private String format;
    private String location;
    private String conservation;
    
    //Constructor
    public OtherMedia(String title, String author, String publisher, int publishmentYear, String genre, String synopsis,
            String language, String cover, String type, String format, String location, String conservation,
            int numberCopies, int avaliableCopies) {
        super(title, author, publisher, publishmentYear, genre, synopsis, language, cover);
        this.type = type;
        this.format = format;
        this.location = location;
        this.conservation = conservation;
        this.numberCopies = numberCopies;
        this.avaliableCopies = avaliableCopies;
    }
    
    //Getters and Setters
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
}
