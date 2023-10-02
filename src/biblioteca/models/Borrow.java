package biblioteca.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import biblioteca.models.Itens.Item;
import biblioteca.models.Membros.AuthorizationLevel;
import biblioteca.models.Membros.Employee;
import biblioteca.models.Membros.People;

public class Borrow {
    private People person;
    private Item item;
    private People employee;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate shouldReturn;
    private String status;
    private boolean renewed;
    private double fee; 

    // Exceção para quando o limite de empréstimos de uma pessoa é excedido
    public class ExcecaoLimiteEmprestimoExcedido extends Exception {
        public ExcecaoLimiteEmprestimoExcedido(String message) {
            super(message);
        }
    }

    // Exceção para quando o item não está disponível para empréstimo
    public class ExcecaoItemNaoDisponivel extends Exception {
        public ExcecaoItemNaoDisponivel(String message) {
            super(message);
        }
    }

    // Exceção para quando o funcionário não tem permissão para fazer empréstimos
    public class ExcecaoPermissaoNegada extends Exception {
        public ExcecaoPermissaoNegada(String message) {
            super(message);
        }
    }

    // Constructor
    public Borrow(People person, Item item, People employee) {
        try {
            if (AccessControl.canBorrowItem(employee)) {
                if (person.getBorrowedNumber() < person.getBorrowLimit()) {
                    if (item.getAvaliableCopies() > 0) {
                        this.person = person;
                        this.item = item;
                        this.employee = employee;
                        this.dataEmprestimo = LocalDate.now();
                        this.dataDevolucao = null;
                        this.shouldReturn = dataEmprestimo.plusDays(person.getReturnPeriod());
                        this.status = "Regular";
                        this.renewed = false;
                        this.fee = 0;
                        item.setAvaliableCopies(item.getAvaliableCopies() - 1);
                    } else {
                        throw new ExcecaoItemNaoDisponivel("Impossível de emprestar esse item, ele não está disponível");
                    }
                } else {
                    throw new ExcecaoLimiteEmprestimoExcedido("Impossível de emprestar esse item, essa pessoa atingiu seu limite de empréstimos");
                }
            } else {
                throw new ExcecaoPermissaoNegada("Permissão negada. O funcionário não pode fazer empréstimos.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        item.setAvaliableCopies(item.getAvaliableCopies() + 1);
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

    public People getEmployee() {
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
        public static boolean canBorrowItem(People person) {
            if(person instanceof Employee){
                Employee employee = (Employee) person;
                return employee.getAuthorizationLevel() == AuthorizationLevel.ADMINISTRATOR ||
                    employee.getAuthorizationLevel() == AuthorizationLevel.ATTENDANT;
            }else return false;
        }
    }

}
