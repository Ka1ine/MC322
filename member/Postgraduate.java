package member;

public class Postgraduate extends Student {
    public String researchTopic;
    private int id;

    // Constructor
    public Postgraduate(String name, int rg, int birthDay, int birthMonth, int birthYear, String researchTopic, int id) {
        super(name, rg, birthDay, birthMonth, birthYear);
        this.researchTopic = researchTopic;
        this.id = id;
    }

    //Methods
    public int getRa() {
        return id;
    }
    public void setRa(int id) {
        this.id = id;
    }
}
