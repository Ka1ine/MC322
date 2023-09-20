package biblioteca.models.Itens;

public class CD extends Item{
    private String songs;
    private int totalDuration;

    //Constructor
    public CD(String title, String author, String publisher, int publishmentYear, String genre, String synopsis,
            String language, String cover, String songs, int totalDuration, int numberCopies, int avaliableCopies) {
        super(title, author, publisher, publishmentYear, genre, synopsis, language, cover);
        this.songs = songs;
        this.totalDuration = totalDuration;
        this.numberCopies = numberCopies;
        this.avaliableCopies = avaliableCopies;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }
}
