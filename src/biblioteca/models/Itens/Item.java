package biblioteca.models.Itens;

import biblioteca.models.Membros.People;

public abstract class Item {
    private String title;
    private String author;
    private String publisher;
    private int publishmentYear;
    private String genre;
    private String synopsis;
    private String language;
    private String cover;
    protected int numberCopies;
    protected int avaliableCopies;
    private People reserved;
    private String detalhes;

    //Constructor
    public Item(String title, String author, String publisher, int publishmentYear, String genre, 
                String synopsis, String language, String cover, String detalhes) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishmentYear = publishmentYear;
        this.genre = genre;
        this.synopsis = synopsis;
        this.language = language;
        this.cover = cover;
        this.reserved = null;
        this.detalhes = detalhes;
    }

    public Item(String title2, String author2, String publisher2, int publishmentYear2, String genre2, String synopsis2,
            String language2, String cover2) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishmentYear() {
        return publishmentYear;
    }

    public void setPublishmentYear(int publishmentYear) {
        this.publishmentYear = publishmentYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getNumberCopies() {
        return numberCopies;
    }

    public void setNumberCopies(int numberCopies) {
        this.numberCopies = numberCopies;
    }

    public int getAvaliableCopies() {
        return avaliableCopies;
    }

    public void setAvaliableCopies(int avaliableCopies) {
        this.avaliableCopies = avaliableCopies;
    }

    public People getReserved() {
        return reserved;
    }

    public void setReserved(People reserved) {
        this.reserved = reserved;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
