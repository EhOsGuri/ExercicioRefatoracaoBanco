package Negocios;

public interface IStateConta {

    int getStatus();

    String getStrStatus();

    double getLimRetiradaDiaria();

    double deposito(Double valor);
}
