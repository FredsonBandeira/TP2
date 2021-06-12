package app;

public interface TituloTransporte {
    void carregar(double valor);
    void pagarViagem(double valor);
    boolean checkValidade();
    boolean passarSaldo(PasseStandard  valor1, double valor);
}
