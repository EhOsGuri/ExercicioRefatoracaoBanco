package Negocios;

import java.util.List;
import java.util.stream.Collectors;

import Persistencia.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogicaOperacoes {

    private static LogicaOperacoes uniqueInstance;
    private List<Operacao> operacoes;

    private LogicaOperacoes() {
        operacoes = Operacoes.getInstance().getOperacoes();
    }
 
    //*@ ensures uniqueInstance!=null
    public static LogicaOperacoes getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Instancia de LogicaOperacoes criada...");
            uniqueInstance = new LogicaOperacoes();
        }
        return uniqueInstance;
    }
    //*@ requires num>=0;
    //*@ ensures \result!=null
    public Conta contaAtual() {
    	return Contas.getInstance().getContaAtual();
    }
    
    public void setContaAtual(int num){
        Contas.getInstance().contaAtual(num);
    }
    
    public ObservableList<Operacao> extrato(int numConta) {
        return Contas.getInstance().extrato(numConta);
    }
    public double saldo(int num) { 
        return Contas.getInstance().saldo();
    }
    
    //*@ requires conta! = null 
    //*@ requires mes!=null && mes.length>0
    //*@ requires ano!=null && ano.length>0
    public double saldoMedio(Conta conta, String mes, String ano) {
        return Operacoes.getInstance().saldoMedio(conta, mes, ano);
    }
    
    //*@ requires conta! = null 
    //*@ requires mes!=null && mes.length>0
    //*@ requires ano!=null && ano.length>0
    public int qtdDebitos(Conta conta, String mes, String ano) {
       return Operacoes.getInstance().qtdDebitos(conta, mes, ano);
    }
    
    //*@ requires conta! = null 
    //*@ requires mes!=null && mes.length>0
    //*@ requires ano!=null && ano.length>0
    public double ttDebitos(Conta conta, String mes, String ano) {
        return Operacoes.getInstance().ttDebitos(conta, mes, ano);
    }
    
    //*@ requires conta! = null 
    //*@ requires mes!=null && mes.length>0
    //*@ requires ano!=null && ano.length>0
    public int qtdCreditos(Conta conta, String mes, String ano) {
        return Operacoes.getInstance().qtdCreditos(conta, mes, ano);
    }
    
    //*@ requires conta! = null 
    //*@ requires mes!=null && mes.length>0
    //*@ requires ano!=null && ano.length>0
    public double ttCreditos(Conta conta, String mes, String ano) {
        return Operacoes.getInstance().ttCreditos(conta, mes, ano);
    }
    
    public Conta maiorSaldoMedio() {
    	return Persistencia.getInstance().getContaMaiorSaldoMedio();
    }
    public double getSaldoMedio(){
        return Operacoes.getInstance().saldoMedio(this.maiorSaldoMedio());
    }
}
