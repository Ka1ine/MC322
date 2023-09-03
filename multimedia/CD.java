package multimedia;

public class CD extends Item{
    public String songs;
    public int totalDurationSeconds;
    // public String album;
    // public boolean additionalTracks;
    // public int launch;
    public String gender;

    //Constructor
    public CD(String title, String author, String publisher, String publishmentYear, String genre, String synopsis,
            String language, String cover, String songs, int totalDurationSeconds, String gender) {
        super(title, author, publisher, publishmentYear, genre, synopsis, language, cover);
        this.songs = songs;
        this.totalDurationSeconds = totalDurationSeconds;
        this.gender = gender;
    }

    //Methods
    public void borrow(){
        System.out.println("Pegando CD");
    }
    public void giveBack(){
        System.out.println("Devolvendo CD");
    }
}
