/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.List;

public class Operacoes {
	
    private static Operacoes uniqueInstance;
    private List<Operacao> operacoes;
    // -----------------------------------
	private Operacoes() {
    	operacoes=Persistencia.getInstance().loadOperacoes();
    }
	// -----------------------------------
    public static Operacoes getInstance() {
    	if(uniqueInstance==null) {
    		uniqueInstance=new Operacoes();    		
    	}
    	return uniqueInstance;
    }
    // -----------------------------------
    public List<Operacao> getOperacoes() {
		return operacoes;
	}
    // -----------------------------------
    public void saveOperacoes() {
    	Persistencia.getInstance().saveOperacoes(operacoes);
    } 
}
