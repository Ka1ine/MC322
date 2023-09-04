import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import member.Employee;
import member.People;
import member.Undergraduate;
import multimedia.Book;

public class Main {
    public static void main(String[] arg){
        Undergraduate pessoa = new Undergraduate(
            "João", 
            12345, 
            "Rua Exemplo, 123", 
            "joao@example.com", 
            LocalDate.of(
                2023, 
                9, 
                3
            ),
            "Engenharia"
        );

        Employee funcionario = new Employee(
            "Maria", 
            54321, 
            "Rua Exemplo, 456", 
            "maria@example.com",
            LocalDate.of(
                2023, 
                9, 
                3
            ), 
            "Gerente de Projetos"
        );

        Book livro = new Book(
            "O Grande Gatsby", 
            "F. Scott Fitzgerald", 
            "Scribner", 
            1925, 
            "Ficção",
            "Um romance sobre o Sonho Americano", 
            "Inglês", 
            "Capa dura", 
            "978-3-16-148410-0", 
            "Primeira Edição",
            100, 
            50, 
            "Estante da Biblioteca 3A", 
            "Bom estado"
        );

        Borrow emprestimo = new Borrow(
            pessoa, 
            livro, 
            funcionario, 
            LocalDate.of(2023, 8, 2)
        );
        System.out.println(emprestimo.getStatus());

    }
}
