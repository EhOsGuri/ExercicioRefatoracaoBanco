
package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.Map;

public class Contas {

    private static Contas uniqueInstance;
    private  Map<Integer,Conta> contas;
    
    private Contas() {
        contas = Persistencia.getInstance().loadContas();
    }
    
    public static Contas getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Contas();
 
        return uniqueInstance;
    }
    
    public void saveContas(){
        Persistencia.getInstance().saveContas(contas.values());
    }
    
    public Map<Integer,Conta> getContas() {
        return contas;
    }  
}
