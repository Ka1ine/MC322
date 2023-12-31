package biblioteca.models;

import biblioteca.models.Itens.Item;

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
    public int getNumeroReservas(Item objeto) {
        return objeto.getNumberReserved();
    }

    @Override
    public String getSinopse(Item objeto) {
        return objeto.getSynopsis();
    }

    @Override
    public String getTitulo(Item objeto) {
        return objeto.getTitle();
    }

	@Override
	public int getCodigo(Item objeto) {
        return objeto.getCodigo();
	}

}
