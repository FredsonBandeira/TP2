package app;

import java.time.LocalDate;

public class EpassFuncionario extends PasseStandard{
    public EpassFuncionario(double saldo, double precoViagem, LocalDate dataCarrega, LocalDate dataValida, DocumentoID docID, LocalDate ddn, String nome, String email) {
        super(saldo, precoViagem, dataCarrega, dataValida, docID, ddn, nome, email);
    }
}
