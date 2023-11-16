package biblioteca.models.Membros;

public class Employee extends People {
    private AuthorizationLevel authorizationLevel;

    // Constructor
    public Employee(String name, int universityIdentificationNumber, String address, String contact,
            AuthorizationLevel authorizationLevel) {
        super(name, universityIdentificationNumber, address, contact);
        this.authorizationLevel = authorizationLevel;
        this.borrowLimit = 4;
        this.returnPeriod = 20;
        this.feeValue = 0.75;
    }

    //Getters and Setters
    public AuthorizationLevel getAuthorizationLevel() {
        return authorizationLevel;
    }
    public void setAuthorizationLevel(AuthorizationLevel authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }
}
