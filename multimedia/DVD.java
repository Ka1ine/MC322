package multimedia;

public class DVD {
    public String cast;
    public int duration;
    public String audio[];
    public String subtatles[];
    public String director;
    public int releaseYear;
    public String conservation; 

    // Constructor


    //Methods
    public void borrow(){
        System.out.println("Pegando DVD");
    }
    public void giveBack(){
        System.out.println("Devolvendo DVD");
    }
}
