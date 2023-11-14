package biblioteca.models.Itens;

public class CD extends Item implements IItemMultimediaFactory {
    private String songs;
    private int totalDuration;

    // Constructor
    public CD(String title, String author, int codigo, String publisher, int publishmentYear, String genre, String synopsis,
              String language, String cover, String detalhes, String songs, int totalDuration, int numberCopies, int avaliableCopies) {
        super(title, author, codigo, publisher, publishmentYear, genre, synopsis, language, cover, detalhes);
        this.songs = songs;
        this.totalDuration = totalDuration;
        this.numberCopies = numberCopies;
        this.avaliableCopies = avaliableCopies;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    @Override
    public Item createItem() {
        return new CD(getTitle(), getAuthor(), getCodigo(), getPublisher(), getPublishmentYear(), getGenre(),
                getSynopsis(), getLanguage(), getCover(), getDetalhes(), getSongs(), getTotalDuration(),
                getNumberCopies(), getAvaliableCopies());
    }
}
