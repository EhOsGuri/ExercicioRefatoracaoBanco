package com.bcopstein.ExercicioRefatoracaoBanco;

public interface IStateConta {
	void Saque(Double valor);
    void Deposito(Double valor);
}
//Cria a interface StateConta Altera a classe conta para explorar o padrão
//StatePattern. Explora classes aninhadas.
