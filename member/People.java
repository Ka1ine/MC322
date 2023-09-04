package member;
import java.time.LocalDate;

public class People {
    private String name;
    private int universityIdentificationNumber;
    private String address;
    private String contact;
    private LocalDate registrationDate;

    //Constructor
    public People(String name, int universityIdentificationNumber, String address, String contact,
            LocalDate registrationDate) {
        this.name = name;
        this.universityIdentificationNumber = universityIdentificationNumber;
        this.address = address;
        this.contact = contact;
        this.registrationDate = registrationDate;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getUniversityIdentificationNumber() {
        return universityIdentificationNumber;
    }
    public void setUniversityIdentificationNumber(int universityIdentificationNumber) {
        this.universityIdentificationNumber = universityIdentificationNumber;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    
}
