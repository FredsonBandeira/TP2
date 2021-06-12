package app;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public abstract class PasseStandard extends Epass implements TituloTransporte{
    private Titular titular;
    private int pontos;
    private int numeroViagens;
    private String chavesValida;
    private int viagensFeitas;

    public int getNumeroViagens() {
        return numeroViagens;
    }




    public void setNumeroViagens(int numeroViagens) {
        this.numeroViagens = numeroViagens;
    }

    public int getViagensFeitas() {
        return viagensFeitas;
    }

    public PasseStandard(double saldo, double precoViagem, LocalDate dataCarrega, LocalDate dataValidade) {
        super(saldo, precoViagem,dataCarrega,dataValidade);
        this.chavesValida = getTitular().getNome().substring(0,5);
        this.pontos=0;
        this.numeroViagens=0;

    }

    public PasseStandard(double saldo, double precoViagem, LocalDate dataCarrega,LocalDate dataValida ,DocumentoID docID, LocalDate ddn , String  nome ,String email) { super(saldo, precoViagem, dataCarrega,dataValida);
            this.pontos=0;
            this.numeroViagens=0;

    }

    public PasseStandard(double saldo, double precoViagem, LocalDate dataCarrega,LocalDate dataValida , DocumentoID docID, LocalDate ddn , String nome ,String email, String CodigoDoc, TipoDocumento tipoDoc, String Morada, int Telefone) {

        super(saldo, precoViagem, dataCarrega,dataValida);
        this.pontos=0;
        this.numeroViagens = 0;
        this.titular = new Titular(docID,nome, ddn,Morada, email,Telefone);
    }


    public Titular getTitular() {
        return titular;
    }

    public int getPontos() {
        return pontos;
    }

    public String getChavesValida() {
        return chavesValida;
    }

    public void setChavesValida(String chavesValida) {
        this.chavesValida = gerarchave(titular.getNome());
    }

    protected abstract String gerarchave(String nome);

    public void gerarchave(String nome, int codigo){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String chavee="";
        String inverter = new StringBuffer(nome).reverse().toString();
        inverter = inverter.toUpperCase();//  maiúsculas
        inverter = inverter.replaceAll("","");// eliminar os espacos
        Date hoje = new Date();
        String dataFormatada = sdf.format(hoje);
        chavee+=dataFormatada+"666";
        System.out.print(inverter);
        System.out.print(chavee);

    }

    @Override
    public void pagarViagem(double valor) {

    }

    @Override
    public boolean checkValidade() {
        if(pontos>=100) {
            pontos-=40;
            return true;
        }
        else if (super.checkValidade()) {
            viagensFeitas+=1;
            if(viagensFeitas>=10) {
                viagensFeitas=0;
                pontos+=1;
            }
            return true;

        }
        else {}
        return false;
    }

    @Override
    public boolean passarSaldo(PasseStandard valor1, double valor) {
        if (this.getSaldo(valor1.getSaldo() + valor)>= valor) {
            valor1.getSaldo(valor1.getSaldo(valor1.getSaldo() + valor)+valor);
            this.setSaldo(this.getSaldo(valor1.getSaldo() + valor) - valor);
            return true;
        }
        return false;
    }

    @Override
    public void carregar(double valor) {

    }
}
