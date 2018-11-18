package com.bcopstein.ExercicioRefatoracaoBanco;

public class ValidacoesLimites {
	private static ValidacoesLimites uniqueInstance;
	
	private ValidacoesLimites() {
		
	}
	public static ValidacoesLimites getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new ValidacoesLimites();
 
        return uniqueInstance;
    }
}
