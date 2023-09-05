import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.People;
import multimedia.Item;

public class Library {
    private List<People> persons;
    private List<Item> items;
    private List<Borrow> borrows;

    // Getters and Setters
    public List<People> getPersons() {
        return persons;
    }
    public void setPersons(List<People> persons) {
        this.persons = persons;
    }

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }
    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public void addPerson(People person) {
        persons.add(person);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addBorrow(Borrow borrow) {
        borrows.add(borrow);
    }

    public void printItemsList(List<Item> items) {
        System.out.println("Lista de Livros:");
        for (Item item : items) {
            System.out.println("Nome: " + item.getTitle());
            System.out.println("----------------------------------");
        }
    }

    public void printBorrownsList(List<Borrow> borrows) {
        System.out.println("Lista de Emprestimos:");
        for (Borrow borrow : borrows) {
            System.out.println("Status emprestimos: " + borrow.getStatus());
            System.out.println("----------------------------------");
        }
    }

    public void generateMemberActivityReport(People person, LocalDate startDate, LocalDate endDate, List<Borrow> borrows) {
        System.out.println("Relatório de Atividades de Membros para " + person.getName() + ":");

        int borrowedItems = 0;
        int returnedItems = 0;
        double totalFines = 0.0;

        for (Borrow borrow : borrows) {
            if (borrow.getPerson().equals(person) &&
                borrow.getDataEmprestimo().isAfter(startDate) &&
                borrow.getDataEmprestimo().isBefore(endDate)) {
                borrowedItems++;

                if (borrow.getDataDevolucao() != null &&
                    borrow.getDataDevolucao().isAfter(startDate) &&
                    borrow.getDataDevolucao().isBefore(endDate)) {
                    returnedItems++;
                    totalFines += borrow.calcularMulta();
                }
            }
        }

        System.out.println("Itens emprestados: " + borrowedItems);
        System.out.println("Itens devolvidos: " + returnedItems);
        System.out.println("Total de multas aplicadas: " + totalFines);
    }
}
