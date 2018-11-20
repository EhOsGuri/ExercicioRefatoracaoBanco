package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContaPlatinum implements IStateConta{
	private Conta conta;
	private String categoria="Platinum";
	
	public ContaPlatinum(Conta c) {
		this.conta=c;
	}
	
	@Override
	public void Saque(Double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deposito(Double valor) {
		// TODO Auto-generated method stub
		
	}

}
