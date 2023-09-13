import java.time.LocalDate;
import java.time.LocalTime;

public class EventosBiblioteca {
    enum TipoDeEvento {
        PALESTRA,
        WORKSHOP,
        EXPOSICAO
    }
    
    private TipoDeEvento tipoDeEvento;
    private String local;
    private LocalDate data;
    
    public EventosBiblioteca(EventosBiblioteca.TipoDeEvento tipoDeEvento, String local, LocalDate data) {
        this.tipoDeEvento = tipoDeEvento;
        this.local = local;
        this.data = data;
    }

    public class Palestra {
        private String palestrante;
        private String topico;
        private LocalTime horario;

        public Palestra(String palestrante, String topico, LocalTime horario) {
            this.palestrante = palestrante;
            this.topico = topico;
            this.horario = horario;
        }
        
        public String getPalestrante() {
            return palestrante;
        }
        public void setPalestrante(String palestrante) {
            this.palestrante = palestrante;
        }
        public String getTopico() {
            return topico;
        }
        public void setTopico(String topico) {
            this.topico = topico;
        }
        public LocalTime getHorario() {
            return horario;
        }
        public void setHorario(LocalTime horario) {
            this.horario = horario;
        }
    }

    public class Workshop {
        private LocalTime horario;
        private String instrutor;
        private String topico;
        private String materiaisNecessários;
        
        public Workshop(LocalTime horario, String instrutor, String topico, String materiaisNecessários) {
            this.horario = horario;
            this.instrutor = instrutor;
            this.topico = topico;
            this.materiaisNecessários = materiaisNecessários;
        }
        
        public LocalTime getHorario() {
            return horario;
        }
        public void setHorario(LocalTime horario) {
            this.horario = horario;
        }
        public String getInstrutor() {
            return instrutor;
        }
        public void setInstrutor(String instrutor) {
            this.instrutor = instrutor;
        }
        public String getTopico() {
            return topico;
        }
        public void setTopico(String topico) {
            this.topico = topico;
        }
        public String getMateriaisNecessários() {
            return materiaisNecessários;
        }
        public void setMateriaisNecessários(String materiaisNecessários) {
            this.materiaisNecessários = materiaisNecessários;
        }
    }

    public class Exposicao {
        private String tema;
        private String expositores;
        private String duracao;

        public Exposicao(String tema, String expositores, String duracao) {
            this.tema = tema;
            this.expositores = expositores;
            this.duracao = duracao;
        }
        
        public String getTema() {
            return tema;
        }
        public void setTema(String tema) {
            this.tema = tema;
        }
        public String getExpositores() {
            return expositores;
        }
        public void setExpositores(String expositores) {
            this.expositores = expositores;
        }
        public String getDuracao() {
            return duracao;
        }
        public void setDuracao(String duracao) {
            this.duracao = duracao;
        }
    }

    public TipoDeEvento getTipoDeEvento() {
        return tipoDeEvento;
    }
    public void setTipoDeEvento(TipoDeEvento tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
}
