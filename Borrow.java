import member.AuthorizationLevel;
import member.Employee;
import member.People;
import member.Postgraduate;
import member.Teacher;
import member.Undergraduate;
import multimedia.Item;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Borrow {
    private People person;
    private Item item;
    private Employee employee;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String status;

    // Constructor
    public Borrow(People person, Item item, Employee employee, LocalDate dataEmprestimo) {
        if (AccessControl.canBorrowItem(employee)) {
            if(person.getBorrowedNumber() < person.getBorrowLimit()){
                this.person = person;
                this.item = item;
                this.employee = employee;
                this.dataEmprestimo = dataEmprestimo;
                this.dataDevolucao = null;
                this.status = "em dia";
            }else{
                System.out.println("Impossible to borrow this item, person achieved the borrow limit");
            }
        } else {
            System.out.println("Permission denied. The employee cannot borrow items.");
        }
    }

    //methods
    public String getStatus(){
        if(dataDevolucao == null){
            LocalDate data = dataEmprestimo.plusDays(person.getReturnPeriod());
            if(LocalDate.now().compareTo(data) > 0) {
                long atraso = ChronoUnit.DAYS.between(LocalDate.now(), data);
                status = "atrasado " + -1 * atraso + " dias";
            }
        }else{
            status = "devoldido";
        }
        return status; 
    }

    public double calcularMulta(){
        double multaPorDia = person.getFeeValue();
        Long diasAtraso = calcularAtraso();
        double diasAtrasoDouble = diasAtraso.doubleValue(); 
        double multaTotal = multaPorDia * diasAtrasoDouble;
    
        return multaTotal;
    }

    public Long calcularAtraso() {
        Long atraso = 0L;
        if (dataDevolucao == null) {
            LocalDate data = dataEmprestimo.plusDays(person.getReturnPeriod());
            if (LocalDate.now().compareTo(data) > 0) {
                atraso = ChronoUnit.DAYS.between(LocalDate.now(), data);
                atraso = atraso * -1;
            }
        }
        return atraso;
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
    
    public class AccessControl {
        public static boolean canBorrowItem(Employee employee) {
            return employee.getAuthorizationLevel() == AuthorizationLevel.ADMINISTRATOR ||
                employee.getAuthorizationLevel() == AuthorizationLevel.ATTENDANT;
        }
    }

}
