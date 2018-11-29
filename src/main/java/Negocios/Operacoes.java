
package Negocios;
import java.util.List;

import Persistencia.Persistencia;

public class Operacoes {
	
    private static Operacoes uniqueInstance;
    private List<Operacao> operacoes;
    
	private Operacoes() {
    	operacoes=Persistencia.getInstance().loadOperacoes();
    }
	
    public static Operacoes getInstance() {
    	if(uniqueInstance==null) {
    		uniqueInstance=new Operacoes();    		
    	}
    	return uniqueInstance;
    }
    
    public List<Operacao> getOperacoes() {
		return operacoes;
	}
   
    public void saveOperacoes() {
    	Persistencia.getInstance().saveOperacoes(operacoes);
    } 
    public double saldoMedio(Conta conta, String mes, String ano) {
		double saldo = 0;
	    boolean b = true;
	    for (Operacao o : operacoes) {
	        if (o.getNumeroConta() == conta.getNumero()) {
	            if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
	                b = false;
	            }
	            if (b) {
	                if (o.getTipoOperacao() == 0) {
	                    saldo += o.getValorOperacao();
	                } else {
	                    saldo -= o.getValorOperacao();
	                }
	            }
	        }
	    }
	    double valorMes = ttCreditos(conta, mes, ano);
	    double valorDebMes = ttDebitos(conta, mes, ano);
	    int qntMes = qtdCreditos(conta, mes, ano);
	    int qntDebMes = qtdDebitos(conta, mes, ano);
	    return (saldo + valorMes - valorDebMes) / (qntMes + qntDebMes);
	}
    public int qtdDebitos(Conta conta, String mes, String ano) {//telaEstatistica.java
        int qntDebMes = 0;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    if (o.getTipoOperacao() == 1) {
                        qntDebMes++;
                    }
                }
            }
        }
        return qntDebMes;
    }

    /**
     *
     * @param conta conta do usuario
     * @param mes o mes que o usuario deseja consultar
     * @param ano o ano que o usuario deseja consultar
     * @return total de debitos
     */
    public double ttDebitos(Conta conta, String mes, String ano) {//telaEstatistica.java
        double valorDebMes = 0;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    if (o.getTipoOperacao() == 1) {
                        valorDebMes += o.getValorOperacao();
                    }
                }
            }
        }
        return valorDebMes;
    }

    public int qtdCreditos(Conta conta, String mes, String ano) {//telaEstatistica.java
        int qtdMes = 0;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    if (o.getTipoOperacao() == 0) {
                        qtdMes++;
                    }
                }
            }
        }
        return qtdMes;
    }

    /**
     *
     * @param conta conta do usuario
     * @param mes o mes que o usuario deseja consultar
     * @param ano o ano que o usuario deseja consultar
     * @return total de creditos
     */
    public double ttCreditos(Conta conta, String mes, String ano) {//telaEstatistica.java
        double valorMes = 0;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    if (o.getTipoOperacao() == 0) {
                        valorMes += o.getValorOperacao();
                    }
                }
            }
        }
        return valorMes;
    }
}
