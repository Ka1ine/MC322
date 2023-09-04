package member;
import java.time.LocalDate;

public class Teacher extends People {
    private String area;

    // Constructor
    public Teacher(String name, int universityIdentificationNumber, String address, String contact,
            LocalDate registrationDate, String area) {
        super(name, universityIdentificationNumber, address, contact, registrationDate);
        this.area = area;
    }

    //Getters and Setters
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
}
