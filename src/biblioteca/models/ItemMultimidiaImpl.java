package biblioteca.models;

import biblioteca.models.Itens.Item;
import biblioteca.models.Membros.People;

public class ItemMultimidiaImpl implements ItemMultimidia{

    @Override
    public int getAnoPublicacao(Item objeto) {
        return objeto.getPublishmentYear();
    }

    @Override
    public String getAutor(Item objeto) {
        return objeto.getAuthor();
    }

    @Override
    public String getCapa(Item objeto) {
        return objeto.getCover();
    }

    @Override
    public int getCopiasDisponiveis(Item objeto) {
        return objeto.getAvaliableCopies();
    }

    @Override
    public int getCopiasNumero(Item objeto) {
        return objeto.getNumberCopies();
    }

    @Override
    public String getDetalhes(Item objeto) {
        return objeto.getDetalhes();
    }

    @Override
    public String getEditora(Item objeto) {
        return objeto.getPublisher();
    }

    @Override
    public String getGenero(Item objeto) {
        return objeto.getGenre();
    }

    @Override
    public String getLingua(Item objeto) {
        return objeto.getLanguage();
    }

    @Override
    public People getReserva(Item objeto) {
        return objeto.getReserved();
    }

    @Override
    public String getSinopse(Item objeto) {
        return objeto.getSynopsis();
    }

    @Override
    public String getTitulo(Item objeto) {
        return objeto.getTitle();
    }

}
