package Negocios;

public class ContaGold implements IStateConta {
	private Conta conta;
	private String categoria="Gold";
	
	public ContaGold(Conta c) {
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
