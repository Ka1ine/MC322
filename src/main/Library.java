package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import biblioteca.models.Borrow;
import biblioteca.models.Membro;
import biblioteca.models.Itens.Book;
import biblioteca.models.Itens.CD;
import biblioteca.models.Itens.DVD;
import biblioteca.models.Itens.Ebook;
import biblioteca.models.Itens.Item;
import biblioteca.models.Itens.OtherMedia;
import biblioteca.models.Membros.Employee;
import biblioteca.models.Membros.People;
import biblioteca.models.Membros.Postgraduate;
import biblioteca.models.Membros.Teacher;
import biblioteca.models.Membros.Undergraduate;


public class Library {
    private List<People> people;
    private List<Item> items;
    private List<Borrow> borrows;

    public Library() {
        this.people = new ArrayList<>();
        this.items = new ArrayList<>();
        this.borrows = new ArrayList<>();
    }

    // Getters and Setters
    public List<People> getPersons() {
        return people;
    }
    public void setPersons(List<People> people) {
        this.people = people;
    }

    public List<Item> getItems() {
        return items;
    }
    public Item getItemByCodigo(int codigo){
        Item obj = null; 
        for(Item i : items){
            if(i.getCodigo() == codigo){
                obj = i;
            }
        }
        return obj;
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
        people.add(person);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addBorrow(Borrow borrow) {
        borrows.add(borrow);
        System.out.println(borrow.getPerson().getName() + " pegou o item " + borrow.getItem().getTitle());
    }

    //methods
    public void printItemsList(List<Item> items) {
        System.out.println("Lista de Livros:");
        for (Item item : items) {
            System.out.println("Nome: " + item.getTitle());
        }
    }
    public void printItemsPeople(List<People> peoples) {
        System.out.println("Lista de Membros:");
        for (People people : peoples) {
            System.out.println("Nome: " + people.getName());
        }
    }

    public void printBorrownsList(List<Borrow> borrows) {
        System.out.println("Lista de Emprestimos:");
        for (Borrow borrow : borrows) {
            System.out.println("Status emprestimos: " + borrow.getStatus());
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

    public void itemsReport(List<Borrow> borrows){
        int borrowedCD = 0;
        int borrowedDVD = 0;
        int borrowedEbook = 0;
        int borrowedBook = 0;
        int borrowedOtherMedia = 0;
        int reservedBook = 0;
        int reservedEbook = 0;
        int reservedCD = 0;
        int reservedDVD = 0;
        int reservedOtherMedia = 0;

        for (Borrow borrow : borrows) {
            if(borrow.getItem() instanceof Book){
                borrowedBook++;
                reservedBook += borrow.getItem().getNumberReserved();
            }else if(borrow.getItem() instanceof Ebook){
                borrowedEbook++;
                reservedEbook += borrow.getItem().getNumberReserved();
            }else if(borrow.getItem() instanceof CD){
                borrowedCD++;
                reservedCD += borrow.getItem().getNumberReserved();
            }else if(borrow.getItem() instanceof DVD){
                borrowedDVD++;
                reservedDVD += borrow.getItem().getNumberReserved();
            }else if(borrow.getItem() instanceof OtherMedia){
                borrowedOtherMedia++;
                reservedOtherMedia += borrow.getItem().getNumberReserved();
            }
        }
        System.out.println("------------------------------------");
        System.out.println("Borrowed books: " + borrowedBook);
        System.out.println("Borrowed ebooks: " + borrowedEbook);
        System.out.println("Borrowed cds: " + borrowedCD);
        System.out.println("Borrowed dvds: " + borrowedDVD);
        System.out.println("Borrowed other medias: " + borrowedOtherMedia);
        System.out.println("------------------------------------");
        System.out.println("Reserved books: " + reservedBook);
        System.out.println("Reserved ebooks: " + reservedEbook);
        System.out.println("Reserved cds: " + reservedCD);
        System.out.println("Reserved dvds: " + reservedDVD);
        System.out.println("Reserved other medias: " + reservedOtherMedia);
    }

    public void usagePerfil(List<Borrow> borrows){
        int employee = 0;
        int postgraduate = 0;
        int undergraduate = 0;
        int teacher = 0;
        
        for (Borrow borrow : borrows) {
            if(borrow.getPerson() instanceof Employee){
                employee++;
            }else if(borrow.getPerson() instanceof Postgraduate){
                postgraduate++;
            }else if(borrow.getPerson() instanceof Undergraduate){
                undergraduate++;
            }else if(borrow.getPerson() instanceof Teacher){
                teacher++;
            }
        }
        System.out.println("------------------------------------");
        System.out.println("Employees borrowed : " + employee + " items");
        System.out.println("Postgraduates borrowed : " + postgraduate + " items");
        System.out.println("Undergraduates borrowed : " + undergraduate + " items");
        System.out.println("Teachers borrowed : " + teacher + " items");
        System.out.println("------------------------------------");
    }
}
