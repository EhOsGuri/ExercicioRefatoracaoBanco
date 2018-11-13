/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 17111238
 */
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
