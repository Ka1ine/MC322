public class Borrow {
    private String name;
    private int rg;
    int isbn;
    String borrowDate;
    String takeBackDate;
    String status;

    //constructor
    public Borrow(String name, int rg, int isbn, String borrowDate, String takeBackDate, String status){
        this.name = name;
        this.rg = rg;
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.takeBackDate = takeBackDate;
        this.status = status;
    }

    //setters and getters
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getTakeBackDate() {
        return takeBackDate;
    }

    public void setTakeBackDate(String takeBackDate) {
        this.takeBackDate = takeBackDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}