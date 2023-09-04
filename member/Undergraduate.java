package member;
import java.time.LocalDate;

public class Undergraduate extends People {
    private String graduationCourse;

    // Constructor
    public Undergraduate(String name, int universityIdentificationNumber, String address, String contact,
            LocalDate registrationDate, String graduationCourse) {
        super(name, universityIdentificationNumber, address, contact, registrationDate);
        this.graduationCourse = graduationCourse;
    }

    //Getters and Setters
    public String getGraduationCourse() {
        return graduationCourse;
    }

    public void setGraduationCourse(String graduationCourse) {
        this.graduationCourse = graduationCourse;
    }

}

