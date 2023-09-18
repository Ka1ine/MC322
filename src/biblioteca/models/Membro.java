package biblioteca.models;

import java.time.LocalDate;
import biblioteca.models.Membros.People;

public interface Membro {
    String getNome(People pessoa);
    int getIdentificacao(People pessoa);
    String getEndereco(People pessoa);
    String getContato(People pessoa);
    LocalDate getDataRegistro(People pessoa);
    int getLimiteEmprestimo(People pessoa);
    int getPrazoEmprestimo(People pessoa);
    double getMultaAtraso(People pessoa);
    double getMultaTotal(People pessoa);
    int getNumeroEmprestimo(People pessoa);
}