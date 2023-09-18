package biblioteca.models.Membros;
import java.time.LocalDate;

public abstract class People {
    private String name;
    private int universityIdentificationNumber;
    private String address;
    private String contact;
    private LocalDate registrationDate;
    protected int borrowLimit;
    protected int returnPeriod;
    protected double feeValue;
    protected double totalFee;
    protected int borrowedNumber;

    //Constructor
    public People(String name, int universityIdentificationNumber, String address, String contact,
            LocalDate registrationDate) {
        this.name = name;
        this.universityIdentificationNumber = universityIdentificationNumber;
        this.address = address;
        this.contact = contact;
        this.registrationDate = registrationDate;
        this.borrowedNumber = 0;
    }

    //Methods
    public void payFee(int paidValue){
        setTotalFee(getTotalFee() - paidValue);
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

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public int getReturnPeriod() {
        return returnPeriod;
    }

    public double getFeeValue() {
        return feeValue;
    }

    public int getBorrowedNumber() {
        return borrowedNumber;
    }

    public void setBorrowedNumber(int value) {
        borrowedNumber = value;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    
}
