package biblioteca.models;

import java.util.ArrayList;
import java.util.List;
import biblioteca.models.Itens.Item;

public class ItemBiblioteca<T> {
    private List<Item> itensReservados;
    private List<Item> itensEmprestados;
    private int numItensReservados;
    private int numItensEmprestados;

    public ItemBiblioteca(List<Item> itensReservados, List<Item> itensEmprestados, int numItensReservados,
            int numItensEmprestados) {
        this.itensReservados = new ArrayList<>();
        this.itensEmprestados = new ArrayList<>();
    }

    public List<Item> getItensReservados() {
        return itensReservados;
    }

    public void setItensReservados(List<Item> itensReservados) {
        this.itensReservados = itensReservados;
    }

    public List<Item> getItensEmprestados() {
        return itensEmprestados;
    }

    public void setItensEmprestados(List<Item> itensEmprestados) {
        this.itensEmprestados = itensEmprestados;
    }

    public int getNumItensReservados() {
        return numItensReservados;
    }

    public void setNumItensReservados(int numItensReservados) {
        this.numItensReservados = numItensReservados;
    }

    public int getNumItensEmprestados() {
        return numItensEmprestados;
    }

    public void setNumItensEmprestados(int numItensEmprestados) {
        this.numItensEmprestados = numItensEmprestados;
    }

    
}