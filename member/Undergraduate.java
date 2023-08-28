package member;

public class Undergraduate extends Student {
    private int ra;

    // Constructor
    public Undergraduate(String name, int rg, int birthDay, int birthMonth, int birthYear, int ra) {
        super(name, rg, birthDay, birthMonth, birthYear);
        this.ra = ra;
    }

    //Methods
    public int getRa() {
        return ra;
    }
    public void setRa(int ra) {
        this.ra = ra;
    }
}

