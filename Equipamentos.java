public class Equipamentos {
    enum CategoriaEquipamento {
        INFORMATICA,
        AUDIOVISUAL,
        IMPRESSÃO
    }

    public class Informatica {
        private String computadores;
        private String tablets;
        private String projetores;
        private String monitores;
        private String mesasDigitalizadoras;

        public Informatica(String computadores, String tablets, String projetores, String monitores,
                String mesasDigitalizadoras) {
            this.computadores = computadores;
            this.tablets = tablets;
            this.projetores = projetores;
            this.monitores = monitores;
            this.mesasDigitalizadoras = mesasDigitalizadoras;
        }
        
        public String getComputadores() {
            return computadores;
        }
        public void setComputadores(String computadores) {
            this.computadores = computadores;
        }
        public String getTablets() {
            return tablets;
        }
        public void setTablets(String tablets) {
            this.tablets = tablets;
        }
        public String getProjetores() {
            return projetores;
        }
        public void setProjetores(String projetores) {
            this.projetores = projetores;
        }
        public String getMonitores() {
            return monitores;
        }
        public void setMonitores(String monitores) {
            this.monitores = monitores;
        }
        public String getMesasDigitalizadoras() {
            return mesasDigitalizadoras;
        }
        public void setMesasDigitalizadoras(String mesasDigitalizadoras) {
            this.mesasDigitalizadoras = mesasDigitalizadoras;
        }
    }

    public class Audiovisual {
        private String cameras;
        private String microfones;
        private String caixasDeSom;
        private String kindles;
        
        public Audiovisual(String cameras, String microfones, String caixasDeSom, String kindles) {
            this.cameras = cameras;
            this.microfones = microfones;
            this.caixasDeSom = caixasDeSom;
            this.kindles = kindles;
        }
        
        public String getCameras() {
            return cameras;
        }
        public void setCameras(String cameras) {
            this.cameras = cameras;
        }
        public String getMicrofones() {
            return microfones;
        }
        public void setMicrofones(String microfones) {
            this.microfones = microfones;
        }
        public String getCaixasDeSom() {
            return caixasDeSom;
        }
        public void setCaixasDeSom(String caixasDeSom) {
            this.caixasDeSom = caixasDeSom;
        }
        public String getKindles() {
            return kindles;
        }
        public void setKindles(String kindles) {
            this.kindles = kindles;
        }
        
    }

    public class impressao {
        private String impressora;
        private String scanner;
        private String copiadora;
        private String impressora3D;
        private String gravadoraLaser;
        
        public impressao(String impressora, String scanner, String copiadora, String impressora3d,
                String gravadoraLaser) {
            this.impressora = impressora;
            this.scanner = scanner;
            this.copiadora = copiadora;
            impressora3D = impressora3d;
            this.gravadoraLaser = gravadoraLaser;
        }
        
        public String getImpressora() {
            return impressora;
        }
        public void setImpressora(String impressora) {
            this.impressora = impressora;
        }
        public String getScanner() {
            return scanner;
        }
        public void setScanner(String scanner) {
            this.scanner = scanner;
        }
        public String getCopiadora() {
            return copiadora;
        }
        public void setCopiadora(String copiadora) {
            this.copiadora = copiadora;
        }
        public String getImpressora3D() {
            return impressora3D;
        }
        public void setImpressora3D(String impressora3d) {
            impressora3D = impressora3d;
        }
        public String getGravadoraLaser() {
            return gravadoraLaser;
        }
        public void setGravadoraLaser(String gravadoraLaser) {
            this.gravadoraLaser = gravadoraLaser;
        }
        
    }
}
