import member.Employee;
import member.People;
import multimedia.Item;

public class Borrow {
    private People person;
    private Item item;
    private Employee employee;
    private String dataEmprestimo;
    private String dataDevolucao;

    // Constructor
    public Borrow(People person, Item item, Employee employee, String dataEmprestimo, String dataDevolucao) {
        this.person = person;
        this.item = item;
        this.employee = employee;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

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

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    //Getters and Setters
    
    
}
