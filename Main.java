import java.time.LocalDate;

import member.AuthorizationLevel;
import member.Employee;
import member.Teacher;
import member.Undergraduate;
import multimedia.Book;

public class Main {
    public static void main(String[] arg){
        Undergraduate aluno_graduacao = new Undergraduate(
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

        Teacher professor = new Teacher(
            "João", 
            12345, 
            "Rua Exemplo, 123", 
            "joao@example.com", 
            LocalDate.of(
                2023, 
                9, 
                3
            ),
            "Física"
        );

        Employee adminFuncionario = new Employee(
            "Admin", 
            123456, 
            "Address", 
            "Contact", 
            LocalDate.now(), 
            AuthorizationLevel.ADMINISTRATOR
        );

        Employee attendantFuncionario = new Employee(
            "Attendant", 
            789012, 
            "Address", 
            "Contact", 
            LocalDate.now(), 
            AuthorizationLevel.ATTENDANT
        );

        Employee managerFuncionario = new Employee(
            "Manager", 
            345678, 
            "Address", 
            "Contact", 
            LocalDate.now(), 
            AuthorizationLevel.MANAGER
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

        Borrow emprestimo_professor = new Borrow(
            professor, 
            livro, 
            attendantFuncionario, 
            LocalDate.of(2023, 8, 2)
        );


        System.out.println("Status: " + emprestimo_professor.getStatus());
        System.out.println("Atraso: " + emprestimo_professor.calcularAtraso());
        System.out.println("Multa: " + emprestimo_professor.calcularMulta());

        Borrow emprestimo_professor02 = new Borrow(
            professor, 
            livro, 
            managerFuncionario, 
            LocalDate.of(2023, 8, 2)
        );
    }
}
