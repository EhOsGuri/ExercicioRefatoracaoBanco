
package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.List;

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
}
