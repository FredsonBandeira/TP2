package app;

import java.time.LocalDate;
import java.util.Random;

public class EpassStudent extends Epass implements TituloTransporte {
    private int ano;
    private String escola;
    private Zona[] zonas;


    public int getAno() {

        return ano;
    }

    public String getEscola() {

        return escola;
    }

    public Zona[] getZonas() {

        return zonas;
    }

    //getter

    public void setAno(int ano) {

        this.ano = ano;
    }

    public void setEscola(String escola) {

        this.escola = escola;
    }

    public void addZona(String nome){

    }
    public void addZ(Zona zonaViagem){

    }

    public EpassStudent(double saldo, double precoViagem, LocalDate dataCarrega, LocalDate dataValida, int ano, String escola) {
        super(saldo, precoViagem, dataCarrega, dataValida);
        this.ano = ano;
        this.escola = escola;
    }

    public EpassStudent(double saldo, double precoViagem, LocalDate dataCarrega, LocalDate dataValida,EpassStudent outro) {
        super(saldo, precoViagem, dataCarrega, dataValida);

    }

    @Override
    public void pagarViagem(double valor) {

    }

    @Override
    public boolean checkValidade() {

        if(LocalDate.now().isAfter(getDataValida())){
            System.out.println("O saldo expirou");
            return false;
        }
        return true;

    }

    @Override
    public boolean passarSaldo(PasseStandard valor1, double valor) {
        return false;
    }

    @Override
    public void carregar(double saldo) {
        System.out.println("Saldo  "+getSaldo(valor1.getSaldo() + valor));
        if (saldo < 0) {
            System.out.println("inválido");
        }else{
            this.setSaldo(getSaldo(valor1.getSaldo() + valor)+saldo);
            this.setDataCarrega(LocalDate.now());
            this.setDataValida(getDataCarrega().plusDays(30));
            System.out.println(getSaldo(valor1.getSaldo() + valor));
        }
    }
    private String escolherZona() {
        // TODO Auto-generated method stub
        Random rand_int=new Random();
        int num=rand_int.nextInt(zonas.length);
        return this.zonas[num];


    }

}
