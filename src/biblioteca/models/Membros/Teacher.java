package biblioteca.models.Membros;

public class Teacher extends People {
    private String area;

    // Constructor
    public Teacher(String name, int universityIdentificationNumber, String address, String contact,
            String area) {
        super(name, universityIdentificationNumber, address, contact);
        this.area = area;
        this.borrowLimit = 7;
        this.returnPeriod = 30;
        this.feeValue = 0.5;
    }

    //Getters and Setters
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
}
