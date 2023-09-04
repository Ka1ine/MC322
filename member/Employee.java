package member;
import java.time.LocalDate;

public class Employee extends People {
    private String position;

    // Constructor
    public Employee(String name, int universityIdentificationNumber, String address, String contact,
            LocalDate registrationDate, String position) {
        super(name, universityIdentificationNumber, address, contact, registrationDate);
        this.position = position;
        this.borrowLimit = 4;
        this.returnPeriod = 20;
        this.feeValue = 0.75;
    }

    //Getters and Setters
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
