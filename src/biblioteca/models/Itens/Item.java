package biblioteca.models.Itens;

import java.util.ArrayList;
import java.util.List;

import biblioteca.models.Membros.AuthorizationLevel;
import biblioteca.models.Membros.Employee;
import biblioteca.models.Membros.People;

public abstract class Item {
    private String title;
    private String author;
    private int codigo;
    private String publisher;
    private int publishmentYear;
    private String genre;
    private String synopsis;
    private String language;
    private String cover;
    private String detalhes;
    protected int numberCopies;
    protected int avaliableCopies;
    private int numberReserved;
    private List<People> reservedList;

    // Constructor
    public Item(String title, String author, int codigo, String publisher, int publishmentYear, String genre,
                String synopsis, String language, String cover, String detalhes) {
        this.reservedList = new ArrayList<>();
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.codigo = codigo;
        this.publishmentYear = publishmentYear;
        this.genre = genre;
        this.synopsis = synopsis;
        this.language = language;
        this.cover = cover;
        this.numberReserved = 0;
        this.detalhes = detalhes;
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishmentYear() {
        return publishmentYear;
    }

    public void setPublishmentYear(int publishmentYear) {
        this.publishmentYear = publishmentYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getNumberCopies() {
        return numberCopies;
    }

    public void setNumberCopies(int numberCopies) {
        this.numberCopies = numberCopies;
    }

    public int getAvaliableCopies() {
        return avaliableCopies;
    }

    public void setAvaliableCopies(int avaliableCopies) {
        this.avaliableCopies = avaliableCopies;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public int getNumberReserved() {
        return numberReserved;
    }

    public void setNumberReserved(int numberReserved) {
        this.numberReserved = numberReserved;
    }

    public List<People> getReservedList() {
        return reservedList;
    }

    public void setReservedList(List<People> reservedList) {
        this.reservedList = reservedList;
    }

    // Methods
    public void addToReservedList(People person, People employee) {
        if (AccessControl.canReserveItem(employee)) {
            this.reservedList.add(person);
            this.numberReserved += 1;
            System.out.println("Item reservado com sucesso!");
        } else {
            System.out.println("Reserva falhou! Acesso negado.");
        }
    }

    public void removeReservedList(People person, People employee) {
        if (this.numberReserved > 0) {
            if (AccessControl.canReserveItem(employee)) {
                this.reservedList.remove(person);
                this.numberReserved -= 1;
                System.out.println(person.getName() + " Removido da lista de reserva.");
            } else {
                System.out.println("Operação falhou! Acesso negado.");
            }
        } else {
            System.out.println("Não há nenhuma reserva desse item.");
        }
    }

    public static class AccessControl {
        public static boolean canReserveItem(People person) {
            if (person instanceof Employee) {
                Employee employee = (Employee) person;
                return employee.getAuthorizationLevel() == AuthorizationLevel.ADMINISTRATOR ||
                        employee.getAuthorizationLevel() == AuthorizationLevel.ATTENDANT;
            } else return false;
        }
    }
}

interface IItemMultimediaFactory {
    Item createItem();
}