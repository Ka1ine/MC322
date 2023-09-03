package multimedia;

public abstract class Item {
    public String title;
    public String author;
    public String publisher;
    public String publishmentYear;
    public String genre;
    public String synopsis;
    public String language;
    public String cover;        //change type

    //Constructor
    public Item(String title, String author, String publisher, String publishmentYear, String genre, 
                String synopsis, String language, String cover) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishmentYear = publishmentYear;
        this.genre = genre;
        this.synopsis = synopsis;
        this.language = language;
        this.cover = cover;
    }

    //Methods
    // public void borrow(){
    //     System.out.println("Pegando livro");
    // }
    // public void giveBack(){
    //     System.out.println("Devolvendo livro");
    // }
}
