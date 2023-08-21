import java.time.LocalDate;

public class Borrow {
    public String name;
    private int rg;
    public int isbn;
    private LocalDate borrowDate;
    private LocalDate takeBackDate;
    private String status;

    // Constructor
    public Borrow(String name, int rg, int isbn, int borrowDay, int borrowMonth, int borrowYear){
        this.name = name;
        this.rg = rg;
        this.isbn = isbn;
        this.borrowDate = LocalDate.of(borrowYear, borrowMonth, borrowDay);
        this.takeBackDate = null;
        this.status = "available";
    }

    // Methods
    public void updateState(){
        if(takeBackDate != null){
            setStatus("available");
        }else{
            LocalDate shouldTakeBackDate = borrowDate.plusDays(15);
            if(shouldTakeBackDate.isAfter(LocalDate.now())){
                setStatus("Unavailable: Late");
            }else{
                setStatus("Unavailable");
            }
        }
    }

    // Setters and getters
    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getStatus() {
        updateState();
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(int day, int month, int year) {
        this.borrowDate = LocalDate.of(year, month, day);
    }

    public LocalDate getTakeBackDate() {
        return takeBackDate;
    }

    public void setTakeBackDate(int day, int month, int year) {
        this.takeBackDate = LocalDate.of(year, month, day);
    }
}
