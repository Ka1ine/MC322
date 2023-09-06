import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import member.AuthorizationLevel;
import member.Employee;
import member.People;
import member.Postgraduate;
import member.Teacher;
import member.Undergraduate;
import multimedia.Book;
import multimedia.Item;

public class Main {

        public static void main(String[] arg){

        Library Biblioteca = new Library();

        List<People> persons = new ArrayList<>(); 
        List<Item> items = new ArrayList<>();    
        List<Borrow> borrows = new ArrayList<>();

        // Create people and items
        Undergraduate aluno_graduacao = new Undergraduate("João", 12345, "Rua Exemplo, 123", "joao@example.com", LocalDate.of(2023, 9, 3), "Engenharia");
        Postgraduate aluno_posgraduacao = new Postgraduate("Pedro", 12345, "Rua Exemplo, 123", "joao@example.com", LocalDate.of(2023, 9, 3), "Engenharia");
        Teacher professor = new Teacher("Maria", 12345, "Rua Exemplo, 123", "joao@example.com", LocalDate.of(2023, 9, 3), "Física");
        
        Employee adminFuncionario = new Employee("Admin", 123456, "Address", "Contact", LocalDate.now(), AuthorizationLevel.ADMINISTRATOR);
        Employee attendantFuncionario = new Employee("Attendant", 789012, "Address", "Contact", LocalDate.now(), AuthorizationLevel.ATTENDANT);
        Employee managerFuncionario = new Employee("Manager", 345678, "Address", "Contact", LocalDate.now(), AuthorizationLevel.MANAGER);

        Book livro01 = new Book("O Pequeno Príncipe", "F. Scott Fitzgerald", "Scribner", 1925, "Ficção", "Um romance sobre o Sonho Americano", "Inglês", "Capa dura", "978-3-16-148410-0", "Primeira Edição", 100, 50, "Estante da Biblioteca 3A", "Bom estado");
        Book livro02 = new Book("A garota dinamarquesa", "F. Scott Fitzgerald", "Scribner", 1925, "Ficção", "Um romance sobre o Sonho Americano", "Inglês", "Capa dura", "978-3-16-148410-0", "Primeira Edição", 100, 50, "Estante da Biblioteca 3A", "Bom estado");
        Book livro03 = new Book("Equipe Phoenix", "F. Scott Fitzgerald", "Scribner", 1925, "Ficção", "Um romance sobre o Sonho Americano", "Inglês", "Capa dura", "978-3-16-148410-0", "Primeira Edição", 100, 50, "Estante da Biblioteca 3A", "Bom estado");

        Borrow emprestimo01 = new Borrow(aluno_graduacao, livro01, adminFuncionario, LocalDate.of(2023, 9, 3));
        Borrow emprestimo02 = new Borrow(aluno_graduacao, livro02, adminFuncionario, LocalDate.of(2023, 9, 4));
        Borrow emprestimo03 = new Borrow(aluno_graduacao, livro03, adminFuncionario, LocalDate.of(2023, 9, 4));
        
        persons.add(aluno_posgraduacao);
        persons.add(professor);
        persons.add(adminFuncionario);
        persons.add(attendantFuncionario);
        persons.add(managerFuncionario);
        
        items.add(livro01);
        items.add(livro02);
        Biblioteca.printItemsList(items);
        
        borrows.add(emprestimo01);
        borrows.add(emprestimo02);
        borrows.add(emprestimo03);
        Biblioteca.printBorrownsList(borrows);

        livro01.setReserved(aluno_posgraduacao);
        livro02.setReserved(aluno_graduacao);
        livro03.setReserved(professor);

        LocalDate startDate = LocalDate.of(2023, 9, 1);
        LocalDate endDate = LocalDate.of(2023, 9, 5);
        Biblioteca.generateMemberActivityReport(aluno_graduacao, startDate, endDate, borrows);
        Biblioteca.itemsReport(borrows);
    }
}
