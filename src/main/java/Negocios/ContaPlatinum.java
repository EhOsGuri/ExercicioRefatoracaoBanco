package Negocios;

public class ContaPlatinum implements IStateConta {

    public final int PLATINUM = 2;
    private String categoria;

    public ContaPlatinum() {
        categoria = "Platinum";
    }

    @Override
    public double deposito(Double valor) {
        return valor * 1.025;
    }

    @Override
    public String getStrStatus() {
        return categoria;
    }

    @Override
    public double getLimRetiradaDiaria() {
        return 500000.0;
    }

    @Override
    public int getStatus() {
        return PLATINUM;
    }
}
