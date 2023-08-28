package multimedia;

public class CD {
    public String artist;
    public String album;
    public boolean additionalTracks;
    public int launch;
    public String gender;

    //Constructor
    public CD(String artist, String album, boolean additionalTracks, int launch, String gender){
        this.album = album;
        this.additionalTracks = additionalTracks;
        this.launch = launch;
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
