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
        Conta conta = Contas.getInstance().getContas().get(num);
        if (conta == null) {
            throw new NumberFormatException("Conta invalida");
        } else {
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

    public double saldo(int num) { //telaEstatistica.java
        return contaAtual(num).getSaldo();
    }

    public double saldoMedio(Conta conta, String mes, String ano) {//telaEstatistica.java
        double saldo = 0;
        boolean b = true;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    b = false;
                }
                if (b) {
                    if (o.getTipoOperacao() == 0) {
                        saldo += o.getValorOperacao();
                    } else {
                        saldo -= o.getValorOperacao();
                    }
                }
            }
        }
        double valorMes = ttCreditos(conta, mes, ano);
        double valorDebMes = ttDebitos(conta, mes, ano);
        int qntMes = qtdCreditos(conta, mes, ano);
        int qntDebMes = qtdDebitos(conta, mes, ano);
        return (saldo + valorMes - valorDebMes) / (qntMes + qntDebMes);
    }

    public int qtdDebitos(Conta conta, String mes, String ano) {//telaEstatistica.java
        int qntDebMes = 0;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    if (o.getTipoOperacao() == 1) {
                        qntDebMes++;
                    }
                }
            }
        }
        return qntDebMes;
    }

    /**
     *
     * @param conta conta do usuario
     * @param mes o mes que o usuario deseja consultar
     * @param ano o ano que o usuario deseja consultar
     * @return total de debitos
     */
    public double ttDebitos(Conta conta, String mes, String ano) {//telaEstatistica.java
        double valorDebMes = 0;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    if (o.getTipoOperacao() == 1) {
                        valorDebMes += o.getValorOperacao();
                    }
                }
            }
        }
        return valorDebMes;
    }

    public int qtdCreditos(Conta conta, String mes, String ano) {//telaEstatistica.java
        int qtdMes = 0;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    if (o.getTipoOperacao() == 0) {
                        qtdMes++;
                    }
                }
            }
        }
        return qtdMes;
    }

    /**
     *
     * @param conta conta do usuario
     * @param mes o mes que o usuario deseja consultar
     * @param ano o ano que o usuario deseja consultar
     * @return total de creditos
     */
    public double ttCreditos(Conta conta, String mes, String ano) {//telaEstatistica.java
        double valorMes = 0;
        for (Operacao o : operacoes) {
            if (o.getNumeroConta() == conta.getNumero()) {
                if (Integer.toString(o.getMes()).equals(mes) && Integer.toString(o.getAno()).equals(ano)) {
                    if (o.getTipoOperacao() == 0) {
                        valorMes += o.getValorOperacao();
                    }
                }
            }
        }
        return valorMes;
    }
}
