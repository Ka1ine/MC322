package biblioteca.controllers;

import java.util.List;

import biblioteca.models.ItemMultimidia;
import biblioteca.models.Membro;

public interface BibliotecaController {
    List<ItemMultimidia> consultarItensDisponiveis();
    boolean emprestarItem(Membro membro, ItemMultimidia item);
    boolean devolverItem(Membro membro, ItemMultimidia item);
}