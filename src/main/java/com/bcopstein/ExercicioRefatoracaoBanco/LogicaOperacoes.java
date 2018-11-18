package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogicaOperacoes {
	private static LogicaOperacoes uniqueInstance;
	
	private LogicaOperacoes() {
		
	}
	
	public static LogicaOperacoes getInstance() {
        if (uniqueInstance == null) {
        	System.out.println("Instancia de LogicaOperacoes criada...");
        	uniqueInstance = new LogicaOperacoes();
        }
        return uniqueInstance;
    }
	
	public Conta contaAtual(int num){
		Conta conta = Contas.getInstance().getContas().get(num);
		if (conta == null) {
			throw new NumberFormatException("Conta invalida");
		}
		else {
			return conta;
		}
	}
	
	public void deposito(double valor) { //conta.java

	}

	public void retirada(double valor) {//conta.java
	}
	
	public ObservableList<Operacao> extrato(int numConta) { 
		return FXCollections.observableArrayList(
				Operacoes.getInstance().getOperacoes()
				.stream()
				.filter(op -> op.getNumeroConta() == numConta)
				.collect(Collectors.toList())
				);
	}
	
	public double saldo() { //telaEstatistica.java
		return 0;
	}
	
	public double saldoMedio() {//telaEstatistica.java
		return 0;
	}
	
	public int qtdDebitos() {//telaEstatistica.java
		return 0;
	}
	
	public int qtdCredidtos() {//telaEstatistica.java
		return 0;
	}
}
