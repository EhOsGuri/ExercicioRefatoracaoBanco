package Negocios;

public class ContaSilver implements IStateConta {

    public final int SILVER = 0;
    private String categoria;

    public ContaSilver() {
        categoria = "Silver";
    }

    @Override
    public double deposito(Double valor) {
        return valor;
    }

    @Override
    public String getStrStatus() {
        return categoria;
    }

    @Override
    public double getLimRetiradaDiaria() {
        return 10000.0;
    }

    @Override
    public int getStatus() {
        return SILVER;
    }

}
