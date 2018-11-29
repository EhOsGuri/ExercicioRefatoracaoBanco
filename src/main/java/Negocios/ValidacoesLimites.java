package Negocios;

public class ValidacoesLimites {
	private static ValidacoesLimites uniqueInstance;
	
	private ValidacoesLimites() {
		
	}
	
	public static ValidacoesLimites getInstance() {
        if (uniqueInstance == null)
        	System.out.println("Instancia de ValidacoesLimites criada...");
            uniqueInstance = new ValidacoesLimites();
 
        return uniqueInstance;
    }
	
    //	VALIDACOES: criar uma classe (singleton) para validacoes dos limites diários de saques.
}
