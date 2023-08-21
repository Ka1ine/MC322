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
        Client myClient = new Client("Maria", 1234, 15, 06, 2001);

        String name = myClient.getName();
        System.out.println(name + " primeira cliente da biblioteca.");

        //Instanciando o primeiro emprestimo
        Borrow fisrtBorrow = new Borrow(
                                    name, 
                                    myClient.getRg(), 
                                    myBook.isbn, 
                                    "05/07/2023", 
                                    "17/07/2023", 
                                    "within time");

        String status = fisrtBorrow.getStatus();
        System.out.println("Status do livro " + myBook.title + ": " + status);

        //Instanciando um funcionario
        Employee myEmployee = new Employee(
                                    "Rogerio", 
                                    4545, 
                                    "recepcionista", 
                                    27, 8, 1999);

        System.out.println(myEmployee.name + " é o novo funcionario e seu cargo e " + myEmployee.position);
    }
}
