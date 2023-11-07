package biblioteca.models;

import biblioteca.models.Itens.Item;
import biblioteca.models.Membros.People;

public interface ItemMultimidia {
    String getTitulo(Item objeto);
    String getAutor(Item objeto);
    int getCodigo(Item objeto);
    String getEditora(Item objeto);
    int getAnoPublicacao(Item objeto);
    String getGenero(Item objeto);
    String getSinopse(Item objeto);
    String getLingua(Item objeto);
    String getCapa(Item objeto);
    String getDetalhes(Item objeto);
    int getCopiasNumero(Item objeto);
    int getCopiasDisponiveis(Item objeto);
    int getNumeroReservas(Item objeto);
}