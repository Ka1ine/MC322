import java.time.LocalDate;
import member.Student;
import multimedia.Item;

public class Borrow {
    public int isbn;
    private LocalDate borrowDate;
    private LocalDate takeBackDate;
    private String status;
    private Student[] student;
    private Item[] book;

    // Constructor
    public Borrow(int isbn, int borrowDay, int borrowMonth, int borrowYear){
        this.isbn = isbn;
        this.borrowDate = LocalDate.of(borrowYear, borrowMonth, borrowDay);
        this.takeBackDate = null;
        this.status = "available";
        student = new Student[1];
        book = new Item[10];
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
}
