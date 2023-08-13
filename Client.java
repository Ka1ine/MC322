public class Client {
    private String name;
    private int rg;

    public Client(String name, int rg) {
        this.name = name;
        this.rg = rg;
    }

    // Get and Set
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRg() {
        return rg;
    }
    public void setRg(int rg) {
        this.rg = rg;
    }
}
