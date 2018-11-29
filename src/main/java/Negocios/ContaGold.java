package Negocios;

public class ContaGold implements IStateConta {

    public final int GOLD = 1;
    private String categoria;

    public ContaGold() {
        this.categoria = "Gold";
    }

    @Override
    public double deposito(Double valor) {
        return valor * 1.01;
    }

    @Override
    public String getStrStatus() {
        return categoria;
    }

    @Override
    public double getLimRetiradaDiaria() {
        return 100000.0;
    }

    @Override
    public int getStatus() {
        return GOLD;
    }
}
