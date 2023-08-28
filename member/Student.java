package member;
import java.time.LocalDate;

public class Student {
    public String name;
    private int rg;
    private LocalDate bithdayDate;

    //Constructor
    public Student(String name, int rg, int birthDay, int birthMonth, int birthYear) {
        this.name = name;
        this.rg = rg;
        this.bithdayDate = LocalDate.of(birthYear, birthMonth, birthDay);
    }

    //Methods
    public void StatusBarrow(){
        System.out.println("Status para verificar empréstimos ativos");
    }

    // Get and Set
    public int getRg() {
        return rg;
    }
    public void setRg(int rg) {
        this.rg = rg;
    }

    public LocalDate getBithdayDate() {
        return bithdayDate;
    }
    public void setBithdayDate(int birthDay, int birthMonth, int birthYear) {
        this.bithdayDate = LocalDate.of(birthYear, birthMonth, birthDay);
    }
}
