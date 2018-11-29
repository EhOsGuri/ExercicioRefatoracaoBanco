package Negocios;

public class Conta {

    public final int SILVER = 0;
    public final int GOLD = 1;
    public final int PLATINUM = 2;

    public final int LIM_SILVER_GOLD = 50000;
    public final int LIM_GOLD_PLATINUM = 200000;
    public final int LIM_PLATINUM_GOLD = 100000;
    public final int LIM_GOLD_SILVER = 25000;

    public IStateConta Categoria;

    private int numero;
    private String correntista;
    private double saldo;
    public IStateConta conta;

    public Conta(int umNumero, String umNome) {
        numero = umNumero;
        correntista = umNome;
        saldo = 0.0;
        conta = FactoryConta.getInstance().novaConta(0);
    }

    public Conta(int umNumero, String umNome, double umSaldo, int state) {
        numero = umNumero;
        correntista = umNome;
        saldo = umSaldo;
        conta = FactoryConta.getInstance().novaConta(state);
    }

    /*@ pure @*/
    public double getSaldo() {
        return saldo;
    }

    /*@ pure @*/
    public Integer getNumero() {
        return numero;
    }

    /*@ pure @*/
    public String getCorrentista() {
        return correntista;
    }

    /*@ pure @*/
    public int getStatus() {
        return conta.getStatus();
    }
    
    /*@ pure @*/
    public String getStrStatus() {
        return conta.getStrStatus();
    }
    
     /*@ pure @*/
    public double getLimRetiradaDiaria() {
        return conta.getLimRetiradaDiaria();
    }

    //*@ requires valor>0;
    //*@ ensures \result=(\old(getSaldo())+valor==getSaldo());
    public void deposito(double valor) {
        switch (conta.getStatus()) {
            case SILVER:
                saldo += conta.deposito(valor);
                ;
                if (saldo >= LIM_SILVER_GOLD) {
                    conta = FactoryConta.getInstance().novaConta(GOLD);
                }
                break;
            case GOLD:
                saldo += conta.deposito(valor);
                if (saldo >= LIM_GOLD_PLATINUM) {
                    conta = FactoryConta.getInstance().novaConta(PLATINUM);
                }
                break;
            case PLATINUM:
                saldo += conta.deposito(valor);
                break;
            default:
                break;
        }
    }

    //*@ requires valor>0
    //*@ ensures \result=(\old(getSaldo())-valor==getSaldo());
    public void retirada(double valor) {
        if (saldo - valor < 0.0) {
            return;
        } else {
            saldo = saldo - valor;
            if (conta.getStatus() == PLATINUM) {
                if (saldo < LIM_PLATINUM_GOLD) {
                    conta = FactoryConta.getInstance().novaConta(GOLD);
                }
            } else if (conta.getStatus() == GOLD) {
                if (saldo < LIM_GOLD_SILVER) {
                    conta = FactoryConta.getInstance().novaConta(SILVER);;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Conta [numero=" + numero + ", correntista=" + correntista + ", saldo=" + saldo + ", status=" + conta.getStrStatus()
                + "]";
    }


}
