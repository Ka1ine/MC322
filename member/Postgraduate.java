package member;
import java.time.LocalDate;

public class Postgraduate extends People {
    private String postGraduationCourse;

    // Constructor
    public Postgraduate(String name, int universityIdentificationNumber, String address, String contact,
            LocalDate registrationDate, String postGraduationCourse) {
        super(name, universityIdentificationNumber, address, contact, registrationDate);
        this.postGraduationCourse = postGraduationCourse;
    }

    //Getters and Setters
    public String getPostGraduationCourse() {
        return postGraduationCourse;
    }

    public void setPostGraduationCourse(String postGraduationCourse) {
        this.postGraduationCourse = postGraduationCourse;
    }
}
