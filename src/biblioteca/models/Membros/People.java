package biblioteca.models.Membros;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class People {
    private String name;
    private int universityId;
    private String address;
    private String contact;
    private LocalDate registrationDate;
    private List<String> notification;
    protected int borrowLimit;
    protected int returnPeriod;
    protected double feeValue;
    protected double totalFee;
    protected int borrowedNumber;

    //Constructor
    public People(String name, int universityId, String address, String contact) {
        this.name = name;
        this.universityId = universityId;
        this.address = address;
        this.contact = contact;
        this.registrationDate = LocalDate.now();
        this.borrowedNumber = 0;
        this.notification = new ArrayList<>();
    }

    //Methods
    public void payFee(int paidValue){
        setTotalFee(getTotalFee() - paidValue);
    }

    public void addNotification(String message){
        notification.add(message);
    }

    public void printNotifications(){
        int counter = 1;
        System.out.println("╔═══════════════  Notificacoes  ══════════════════╗");
        for (String elemento : notification) {
            System.out.println("║ " + counter + ": " + elemento);
            counter =+ 1;
        }
        System.out.println("╚═════════════════════════════════════════════════╝");
    }

    public void removeNotification(int index){
        notification.remove(index - 1);
        System.out.println("Notificação removida com sucesso.");
    }

    //Getters and Setters
    public void setNotification(List<String> notification) {
        this.notification = notification;
    }

    public List<String> getNotification() {
        return notification;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getUniversityId() {
        return universityId;
    }
    public void setUniversityId(int universityId) {
        this.universityId = universityId;
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
