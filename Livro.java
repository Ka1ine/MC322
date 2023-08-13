public class Livro {
    private String titulo;
    private String descricao;
    private String edicao;
    private String idioma;
    private String autor;
    private String isbn;

    public Livro(String titulo, String descricao, String edicao, String idioma, String autor, String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.edicao = edicao;
        this.idioma = idioma;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

     public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

     public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    

}
