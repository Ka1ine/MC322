package biblioteca.models.Itens;

import java.time.LocalDate;

public class Ebook extends Item implements IItemMultimediaFactory {
    private String format;
    private int numberLicences;
    private String url;
    private String requirements;
    private LocalDate avaliableDate;
    private double fileSize;

    // Constructor
    public Ebook(String title, String author, int codigo, String publisher, int publishmentYear, String genre, String synopsis,
            String language, String cover, String detalhes, String format, int numberLicences, String url, String requirements,
            LocalDate avaliableDate, double fileSize, int numberCopies, int avaliableCopies) {
        super(title, author, codigo, publisher, publishmentYear, genre, synopsis, language, cover, detalhes);
        this.format = format;
        this.numberLicences = numberLicences;
        this.url = url;
        this.requirements = requirements;
        this.avaliableDate = avaliableDate;
        this.fileSize = fileSize;
        this.numberCopies = numberCopies;
        this.avaliableCopies = avaliableCopies;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getNumberLicences() {
        return numberLicences;
    }

    public void setNumberLicences(int numberLicences) {
        this.numberLicences = numberLicences;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public LocalDate getAvaliableDate() {
        return avaliableDate;
    }

    public void setAvaliableDate(int day, int month, int year) {
        this.avaliableDate = LocalDate.of(year, month, day);
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public Item createItem() {
        return new Ebook(getTitle(), getAuthor(), getCodigo(), getPublisher(), getPublishmentYear(), getGenre(),
                getSynopsis(), getLanguage(), getCover(), getDetalhes(), getFormat(), getNumberLicences(),
                getUrl(), getRequirements(), getAvaliableDate(), getFileSize(), getNumberCopies(),
                getAvaliableCopies());
    }
}
