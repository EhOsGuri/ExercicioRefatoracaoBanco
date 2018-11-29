/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

public class FactoryConta {

    private static FactoryConta uniqueInstance;

    private FactoryConta() {

    }

    public static FactoryConta getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new FactoryConta();
        }
        return uniqueInstance;
    }

    public IStateConta novaConta(int tipo) {
        switch (tipo) {
            case 0:
                return new ContaSilver();
            case 1:
                return new ContaGold();
            case 2:
                return new ContaPlatinum();
            default:
                return null;
        }
    }
}
