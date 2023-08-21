public class Main {
    public static void main(String[] arg){

        // Instanciando o primeiro livro da biblioteca.
        Book myBook = new Book(
                                "A garota do lago", 
                                "Summit Lake, uma pequena cidade entre montanhas", 
                                "Padrão", 
                                "Português", 
                                "Charlie Donlea",
                                "Faro Editorial",
                                123,
                                459,
                                16
                            );

        System.out.println("O livro " + myBook.title + " escrito por " + myBook.author + " foi o primeiro livro que chegou na bliblioteca.");
        
        
        //Instanciando a primeira cliente da biblioteca
        Client myClient = new Client("Maria", 1234);

        String name = myClient.getName();
        System.out.println(name + " primeira cliente da biblioteca.");

        //Instanciando o primeiro emprestimo
        Borrow firstBorrow = new Borrow(
                                    name, 
                                    myClient.getRg(), 
                                    myBook.isbn, 
                                    5, 7, 2023);

        String status = firstBorrow.getStatus();
        System.out.println("Status do livro " + myBook.title + ": " + status);

        firstBorrow.setTakeBackDate(15, 7, 2023);
        status = firstBorrow.getStatus();
        System.out.println("Status do livro " + myBook.title + ": " + status);

        //Instanciando um funcionario
        Employee myEmployee = new Employee(
                                    "Rogerio", 
                                    4545, 
                                    "recepcionista");

        String employeeName = myEmployee.getName();
        String employeePosition = myEmployee.getPosition();
        System.out.println(employeeName + " é o novo funcionario e seu cargo e " + employeePosition);
    }
}
