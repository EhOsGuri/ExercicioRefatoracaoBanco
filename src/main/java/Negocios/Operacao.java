package Negocios;
public class Operacao {
	public final int CREDITO = 0;
	public final int DEBITO = 1;
    
	private int dia;
    private int mes;
    private int ano;
    private int hora;
    private int minuto;
    private int segundo;
    private int numeroConta;
    private int statusConta;
    private double valorOperacao;
    private int tipoOperacao;
    
    //*@requires dia>0 && dia<32
    //*@requires mes>0 && mes<13
    //*@requires hora>0 && hora<25
    //*@requires segundo>0 && dia<=60
    //*@requires numConta>0
	public Operacao(int dia, int mes, int ano, int hora, int minuto, int segundo, int numeroConta, int statusConta,
			double valorOperacao, int tipoOperacao) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.numeroConta = numeroConta;
		this.statusConta = statusConta;
		this.valorOperacao = valorOperacao;
		this.tipoOperacao = tipoOperacao;
	}
	/*@ pure @*/
	public int getDia() {
		return dia;
	}
	/*@ pure @*/
	public int getMes() {
		return mes;
	}
	/*@ pure @*/
	public int getAno() {
		return ano;
	}
	/*@ pure @*/
	public int getHora() {
		return hora;
	}
	/*@ pure @*/
	public int getMinuto() {
		return minuto;
	}
	/*@ pure @*/
	public int getSegundo() {
		return segundo;
	}
	/*@ pure @*/
	public int getNumeroConta() {
		return numeroConta;
	}
	/*@ pure @*/
	public int getStatusConta() {
		return statusConta;
	}
	/*@ pure @*/
	public double getValorOperacao() {
		return valorOperacao;
	}
	/*@ pure @*/
	public int getTipoOperacao() {
		return tipoOperacao;
	}
    
	@Override
	public String toString() {
		String tipo = "<C>";
		if (tipoOperacao == 1) {
			tipo = "<D>"; 
		}
		String line = dia+"/"+mes+"/"+ano+" "+
	                  hora+":"+minuto+":"+segundo+" "+
				      numeroConta+" "+
	                  statusConta +" "+
				      tipo+" "+
	                  valorOperacao;
		return(line);
	}
}
