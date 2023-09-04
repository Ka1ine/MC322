package multimedia;

public class DVD extends Item{
    private String cast;
    private int duration;
    private String audio[];
    private String subtatles[];
    private String director;
    private int releaseYear;
    private String conservation; 

    // Constructor
    public DVD(String title, String author, String publisher, int publishmentYear, String genre, String synopsis,
            String language, String cover, String cast, int duration, String[] audio, String[] subtatles,
            String director, int releaseYear, String conservation) {
        super(title, author, publisher, publishmentYear, genre, synopsis, language, cover);
        this.cast = cast;
        this.duration = duration;
        this.audio = audio;
        this.subtatles = subtatles;
        this.director = director;
        this.releaseYear = releaseYear;
        this.conservation = conservation;
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

    public String[] getAudio() {
        return audio;
    }

    public void setAudio(String[] audio) {
        this.audio = audio;
    }

    public String[] getSubtatles() {
        return subtatles;
    }

    public void setSubtatles(String[] subtatles) {
        this.subtatles = subtatles;
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
