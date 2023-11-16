package biblioteca.models.Membros;

public class Postgraduate extends People {
    private String postGraduationCourse;

    // Constructor
    public Postgraduate(String name, int universityIdentificationNumber, String address, String contact,
            String postGraduationCourse) {
        super(name, universityIdentificationNumber, address, contact);
        this.postGraduationCourse = postGraduationCourse;
        this.borrowLimit = 5;
        this.returnPeriod = 20;
        this.feeValue = 1;
    }

    //Getters and Setters
    public String getPostGraduationCourse() {
        return postGraduationCourse;
    }

    public void setPostGraduationCourse(String postGraduationCourse) {
        this.postGraduationCourse = postGraduationCourse;
    }
}
