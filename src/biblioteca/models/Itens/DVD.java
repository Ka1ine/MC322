package biblioteca.models.Itens;

public class DVD extends Item{
    private String cast;
    private int duration;
    private String audio;
    private String subtitles;
    private String director;
    private int releaseYear;
    private String conservation; 

    // Constructor
    public DVD(String title, String author, int codigo, String publisher, int publishmentYear, String genre, String synopsis,
            String language, String cover, String detalhes, String cast, int duration, String audio, String subtitles,
            String director, int releaseYear, String conservation, int numberCopies, int avaliableCopies) {
        super(title, author, codigo, publisher, publishmentYear, genre, synopsis, language, cover, detalhes);
        this.cast = cast;
        this.duration = duration;
        this.audio = audio;
        this.subtitles = subtitles;
        this.director = director;
        this.releaseYear = releaseYear;
        this.conservation = conservation;
        this.numberCopies = numberCopies;
        this.avaliableCopies = avaliableCopies;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getSubtatles() {
        return subtitles;
    }

    public void setSubtatles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getConservation() {
        return conservation;
    }

    public void setConservation(String conservation) {
        this.conservation = conservation;
    }

}
