package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogicaOperacoes {

    private static LogicaOperacoes uniqueInstance;
    private List<Operacao> operacoes;

    private LogicaOperacoes() {
        operacoes = Operacoes.getInstance().getOperacoes();
    }

    public static LogicaOperacoes getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Instancia de LogicaOperacoes criada...");
            uniqueInstance = new LogicaOperacoes();
        }
        return uniqueInstance;
    }

    public Conta contaAtual(int num) {
    	return Contas.getInstance().contaAtual(num);
    }

    public void deposito(double valor) { //conta.java
    	Contas.getInstance().deposito(valor);
    }
    public void retirada(double valor) {
    	Contas.getInstance().retirada(valor);
    }
    public ObservableList<Operacao> extrato(int numConta) {
        return Contas.getInstance().extrato(numConta);
    }
    public double saldo(int num) { 
        return Contas.getInstance().saldo(num);
    }
    public double saldoMedio(Conta conta, String mes, String ano) {
        return Operacoes.getInstance().saldoMedio(conta, mes, ano);
    }

    public int qtdDebitos(Conta conta, String mes, String ano) {
       return Operacoes.getInstance().qtdDebitos(conta, mes, ano);
    }
    public double ttDebitos(Conta conta, String mes, String ano) {
        return Operacoes.getInstance().ttDebitos(conta, mes, ano);
    }

    public int qtdCreditos(Conta conta, String mes, String ano) {
        return Operacoes.getInstance().qtdCreditos(conta, mes, ano);
    }
    public double ttCreditos(Conta conta, String mes, String ano) {
        return Operacoes.getInstance().ttCreditos(conta, mes, ano);
    }
}
