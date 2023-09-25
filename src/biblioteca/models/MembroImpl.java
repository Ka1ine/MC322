package biblioteca.models;

import java.time.LocalDate;

import biblioteca.models.Membros.People;

public class MembroImpl implements Membro{

    @Override
    public String getContato(People pessoa) {
        return pessoa.getContact();
    }

    @Override
    public LocalDate getDataRegistro(People pessoa) {
        return pessoa.getRegistrationDate();
    }

    @Override
    public String getEndereco(People pessoa) {
        return pessoa.getAddress();
    }

    @Override
    public int getIdentificacao(People pessoa) {
        return pessoa.getUniversityIdentificationNumber();
    }

    @Override
    public int getLimiteEmprestimo(People pessoa) {
        return pessoa.getBorrowLimit();
    }

    @Override
    public double getMultaAtraso(People pessoa) {
        return pessoa.getFeeValue();
    }

    @Override
    public double getMultaTotal(People pessoa) {
        return pessoa.getTotalFee();
    }

    @Override
    public String getNome(People pessoa) {
        return pessoa.getName();
    }

    @Override
    public int getNumeroEmprestimo(People pessoa) {
        return pessoa.getBorrowedNumber();
    }

    @Override
    public int getPrazoEmprestimo(People pessoa) {
        return pessoa.getReturnPeriod();
    }
    
}