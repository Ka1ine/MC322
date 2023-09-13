import java.time.LocalDate;
import java.time.LocalTime;
import member.People;

public class ReservaSala{ //constructor
    enum StatusReserva{
        PENDENTE,
        CONFIRMADA,
        CANCELADA
    }

    private LocalDate dataReserva;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private People pessoa;
    private StatusReserva status;
    private int numeroSala;

    public ReservaSala(LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim, People pessoa,
            ReservaSala.StatusReserva status, int numeroSala) {
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.pessoa = pessoa;
        this.status = status;
        this.numeroSala = numeroSala;
    }

    public class SalaIndividual{
        private boolean possuiComputador;
        
        public SalaIndividual(boolean possuiComputador) {
            this.possuiComputador = possuiComputador;
        }
        public boolean getPossuiComputador() {
            return possuiComputador;
        }
        public void setPossuiComputador(boolean possuiComputador) {
            this.possuiComputador = possuiComputador;
        }
    }
    
    public class SalaGrupo{
        private int capacidadeMaxima;
        private boolean equipamentoApresentacao;

        public int getCapacidadeMaxima() {
            return capacidadeMaxima;
        }
        public void setCapacidadeMaxima(int capacidadeMaxima) {
            this.capacidadeMaxima = capacidadeMaxima;
        }
        public boolean getEquipamentoApresentacao() {
            return equipamentoApresentacao;
        }
        public void setEquipamentoApresentacao(boolean equipamentoApresentacao) {
            this.equipamentoApresentacao = equipamentoApresentacao;
        }
    }
    
    public class SalaSilenciosa{
        private int numeroAssentos;
        private boolean possuiCabines;

        public SalaSilenciosa(int numeroAssentos, boolean possuiCabines) {
            this.numeroAssentos = numeroAssentos;
            this.possuiCabines = possuiCabines;
        }

        public int getNumeroAssentos() {
            return numeroAssentos;
        }
        public void setNumeroAssentos(int numeroAssentos) {
            this.numeroAssentos = numeroAssentos;
        }
        public boolean isPossuiCabines() {
            return possuiCabines;
        }
        public void setPossuiCabines(boolean possuiCabines) {
            this.possuiCabines = possuiCabines;
        }
    }
    
    public class SalaMultimidia{
        private String equipamentosDisponiveis;

        public SalaMultimidia(String equipamentosDisponiveis) {
            this.equipamentosDisponiveis = equipamentosDisponiveis;
        }

        public String getEquipamentosDisponiveis() {
            return equipamentosDisponiveis;
        }
        public void setEquipamentosDisponiveis(String equipamentosDisponiveis) {
            this.equipamentosDisponiveis = equipamentosDisponiveis;
        }
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }
    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    public LocalTime getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
    public People getPessoa() {
        return pessoa;
    }
    public void setPessoa(People pessoa) {
        this.pessoa = pessoa;
    }
    public StatusReserva getStatus() {
        return status;
    }
    public void setStatus(StatusReserva status) {
        this.status = status;
    }
    public int getNumeroSala() {
        return numeroSala;
    }
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
}