public class Multimidia {
    enum FormatoMidia {
        AUDIO,
        VIDEO,
        SOFTWARE
    }

    private FormatoMidia formato;
    
    public Multimidia(Multimidia.FormatoMidia formato) {
        this.formato = formato;
    }

    public class Audio {
        private String cds;
        private String podcasts;
        private String gravacaoPalestras;
        private String audiobooks;
        
        public Audio(String cds, String podcasts, String gravacaoPalestras, String audiobooks) {
            this.cds = cds;
            this.podcasts = podcasts;
            this.gravacaoPalestras = gravacaoPalestras;
            this.audiobooks = audiobooks;
        }

        public String getCds() {
            return cds;
        }
        public void setCds(String cds) {
            this.cds = cds;
        }
        public String getPodcasts() {
            return podcasts;
        }
        public void setPodcasts(String podcasts) {
            this.podcasts = podcasts;
        }
        public String getGravacaoPalestras() {
            return gravacaoPalestras;
        }
        public void setGravacaoPalestras(String gravacaoPalestras) {
            this.gravacaoPalestras = gravacaoPalestras;
        }
        public String getAudiobooks() {
            return audiobooks;
        }
        public void setAudiobooks(String audiobooks) {
            this.audiobooks = audiobooks;
        }
    }
    
    public class Video {
        private String dvds;
        private String gravacoesAulas;
        private String documentarios;
        private String cursos;
        
        public Video(String dvds, String gravacoesAulas, String documentarios, String cursos) {
            this.dvds = dvds;
            this.gravacoesAulas = gravacoesAulas;
            this.documentarios = documentarios;
            this.cursos = cursos;
        }

        public String getDvds() {
            return dvds;
        }
        public void setDvds(String dvds) {
            this.dvds = dvds;
        }
        public String getGravacoesAulas() {
            return gravacoesAulas;
        }
        public void setGravacoesAulas(String gravacoesAulas) {
            this.gravacoesAulas = gravacoesAulas;
        }
        public String getDocumentarios() {
            return documentarios;
        }
        public void setDocumentarios(String documentarios) {
            this.documentarios = documentarios;
        }
        public String getCursos() {
            return cursos;
        }
        public void setCursos(String cursos) {
            this.cursos = cursos;
        }
        
    }
    
    public class Software {
        private String programasEducacionais;
        private String programasSimulacao;
        
        public Software(String programasEducacionais, String programasSimulacao) {
            this.programasEducacionais = programasEducacionais;
            this.programasSimulacao = programasSimulacao;
        }
        
        public String getProgramasEducacionais() {
            return programasEducacionais;
        }
        public void setProgramasEducacionais(String programasEducacionais) {
            this.programasEducacionais = programasEducacionais;
        }
        public String getProgramasSimulacao() {
            return programasSimulacao;
        }
        public void setProgramasSimulacao(String programasSimulacao) {
            this.programasSimulacao = programasSimulacao;
        }
    }

    public FormatoMidia getFormato() {
        return formato;
    }

    public void setFormato(FormatoMidia formato) {
        this.formato = formato;
    }
}
