package biblioteca.models.Membros;

public class Undergraduate extends People {
    private String graduationCourse;

    // Constructor
    public Undergraduate(String name, int universityIdentificationNumber, String address, String contact,
            String graduationCourse) {
        super(name, universityIdentificationNumber, address, contact);
        this.graduationCourse = graduationCourse;
        this.borrowLimit = 0;
        this.returnPeriod = 15;
        this.feeValue = 1;
    }

    //Getters and Setters
    public String getGraduationCourse() {
        return graduationCourse;
    }

    public void setGraduationCourse(String graduationCourse) {
        this.graduationCourse = graduationCourse;
    }

}

