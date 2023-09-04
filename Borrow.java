import java.time.LocalDate;
import member.People;
import multimedia.Item;

public class Borrow {
    private int isbn;
    private LocalDate borrowDate;
    private LocalDate takeBackDate;
    private String status;

    // Constructor
    public Borrow(int isbn, int borrowDay, int borrowMonth, int borrowYear){
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
