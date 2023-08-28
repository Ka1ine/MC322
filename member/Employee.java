package member;
import java.time.LocalDate;

public class Employee {
    public String name;
    private int id;
    public String position;
    private LocalDate bithdayDate;


    // constructor
    public Employee(String name, int id, String position, int birthDay, int birthMonth, int birthYear) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.bithdayDate = LocalDate.of(birthYear, birthMonth, birthDay);
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBithdayDate() {
        return bithdayDate;
    }
    public void setBithdayDate(int birthDay, int birthMonth, int birthYear) {
        this.bithdayDate = LocalDate.of(birthYear, birthMonth, birthDay);
    }
}
