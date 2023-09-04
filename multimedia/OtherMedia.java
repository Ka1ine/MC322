package multimedia;

public class OtherMedia extends Item {
    private String type;
    private String format;
    private String copiesNumber;
    private String avaliableCopies;
    private String location;
    private String conservation;
    
    //Constructor
    public OtherMedia(String title, String author, String publisher, int publishmentYear, String genre, String synopsis,
            String language, String cover, String type, String format, String copiesNumber, String avaliableCopies,
            String location, String conservation) {
        super(title, author, publisher, publishmentYear, genre, synopsis, language, cover);
        this.type = type;
        this.format = format;
        this.copiesNumber = copiesNumber;
        this.avaliableCopies = avaliableCopies;
        this.location = location;
        this.conservation = conservation;
    }

    //Getters and Setters
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String getCopiesNumber() {
        return copiesNumber;
    }
    public void setCopiesNumber(String copiesNumber) {
        this.copiesNumber = copiesNumber;
    }
    public String getAvaliableCopies() {
        return avaliableCopies;
    }
    public void setAvaliableCopies(String avaliableCopies) {
        this.avaliableCopies = avaliableCopies;
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
