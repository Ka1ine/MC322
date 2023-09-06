import member.AuthorizationLevel;
import member.Employee;
import member.People;
import multimedia.Item;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Borrow {
    private People person;
    private Item item;
    private Employee employee;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate shouldReturn;
    private String status;
    private boolean renewed;
    private double fee; 

    // Constructor
    public Borrow(People person, Item item, Employee employee, LocalDate dataEmprestimo) {
        if (AccessControl.canBorrowItem(employee)) {
            if(person.getBorrowedNumber() < person.getBorrowLimit()){
                if(item.getAvaliableCopies() > 0){
                    this.person = person;
                    this.item = item;
                    this.employee = employee;
                    this.dataEmprestimo = dataEmprestimo;
                    this.dataDevolucao = null;
                    this.shouldReturn = dataEmprestimo.plusDays(person.getReturnPeriod());
                    this.status = "Regular";
                    this.renewed = false;
                    this.fee = 0;
                }else{
                    System.out.println("Impossible to borrow this item, it is not avaliable");
                }
            }else{
                System.out.println("Impossible to borrow this item, person achieved the borrow limit");
            }
        } else {
            System.out.println("Permission denied. The employee cannot borrow items.");
        }
    }

    //methods
    public double calcularMulta(){
        double multaPorDia = person.getFeeValue();
        double diasAtraso = calcularAtraso();
        this.fee = multaPorDia * diasAtraso;
        return this.fee;
    }

    public double calcularAtraso() {
        double atraso = 0L;
        if (dataDevolucao == null) {
            atraso = ChronoUnit.DAYS.between(LocalDate.now(), shouldReturn);
            atraso = atraso * -1;
        }
        return atraso;
    }

    public String getStatus(){
        if(dataDevolucao == null){
            double atraso = calcularAtraso();
            if(atraso > 0) {
                calcularMulta();
                status = "atrasado " + atraso + " dias";
            }
        }
        return status; 
    }
    
    public void returnItem(LocalDate date){
        getStatus();
        this.dataDevolucao = date;
        this.status = "Returned";
        person.setTotalFee(person.getTotalFee() + calcularMulta());
    }

    public void renew(){
        if(!this.renewed){
            this.shouldReturn = this.shouldReturn.plusDays(person.getReturnPeriod());
            this.renewed = true;
        }
    }

    //Getters and Setters
    public People getPerson() {
        return person;
    }

    public void setPerson(People person) {
        this.person = person;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
        // return dataEmprestimo.toString();
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getShouldReturn() {
        return shouldReturn;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }
    
    public static class AccessControl {
        public static boolean canBorrowItem(Employee employee) {
            return employee.getAuthorizationLevel() == AuthorizationLevel.ADMINISTRATOR ||
                employee.getAuthorizationLevel() == AuthorizationLevel.ATTENDANT;
        }
    }

}
