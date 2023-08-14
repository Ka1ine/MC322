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

        String title = myBook.getTitle();
        String author = myBook.getAuthor();

        System.out.println("O livro " + title + " escrito por " + author + " foi o primeiro livro que chegou na bliblioteca.");
        
        
        //Instanciando a primeira cliente da biblioteca
        Client myClient = new Client("Maria", 1234);

        String name = myClient.getName();
        System.out.println(name + " primeira cliente da biblioteca.");

        //Instanciando o primeiro emprestimo
        Borrow fisrtBorrow = new Borrow(
                                    name, 
                                    myClient.getRg(), 
                                    myBook.getIsbn(), 
                                    "05/07/2023", 
                                    "17/07/2023", 
                                    "within time");

        String status = fisrtBorrow.getStatus();
        System.out.println("Status do livro " + title + ": " + status);

    }
}
