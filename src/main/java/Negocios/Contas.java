
package Negocios;
import java.util.Map;
import java.util.stream.Collectors;

import Persistencia.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contas {

    private static Contas uniqueInstance;
    private  Map<Integer,Conta> contas;
    private Conta contaAtual;
    
    private Contas() {
        contas = Persistencia.getInstance().loadContas();
    }
    
    public static Contas getInstance() {
        if (uniqueInstance == null) {
        	System.out.println("Instancia de Contas criada...");
            uniqueInstance = new Contas();
        } 
        return uniqueInstance;
    }
    
    public void saveContas(){
        Persistencia.getInstance().saveContas(contas.values());
    }
    
    public Map<Integer,Conta> getContas() {
        return contas;
    }  
    
    /*
        @requires num >= 0
    */
    public void contaAtual(int num) {
        contaAtual = Contas.getInstance().getContas().get(num);
        if (contaAtual == null) {
            throw new NumberFormatException("Conta invalida");
        }
    }
    
    /*@pure @*/
    public Conta getContaAtual(){
        return contaAtual;
    }
    
    /*
    @requires numConta >= 0
    */
    public ObservableList<Operacao> extrato(int numConta) {
		return FXCollections.observableArrayList(
                Operacoes.getInstance().getOperacoes()
                        .stream()
                        .filter(op -> op.getNumeroConta() == numConta)
                        .collect(Collectors.toList())
        );
    
    }
    
    /*
    @ensures \result = contaAtual.getSaldo();
    @ pure @
    */
    public double saldo() {
	return getContaAtual().getSaldo();
    }
}
