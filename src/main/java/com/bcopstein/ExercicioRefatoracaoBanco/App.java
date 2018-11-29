package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.List;
import java.util.Map;

import Interfaces.TelaEntrada;
import Interfaces.TelaObserver;
import Negocios.Conta;
import Negocios.Operacao;
import Persistencia.Persistencia;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class App extends Application {
	private Persistencia persistencia;
	private Map<Integer,Conta> contas;
	private List<Operacao> operacoes;
	private TelaEntrada telaEntrada;
	private TelaObserver telaObserver;
	
	@Override
    public void start(Stage primaryStage) {
    	this.persistencia = Persistencia.getInstance();
    	this.contas = persistencia.loadContas();    	
    	this.operacoes = persistencia.loadOperacoes();
    	
    	primaryStage.setTitle("$$ Banco NOSSA GRANA $$");

    	telaEntrada = new TelaEntrada(primaryStage);

        primaryStage.setScene(telaEntrada.getTelaEntrada());
        primaryStage.show();
        
        //-------------
        
        Stage tObserver = new Stage();
        tObserver.setTitle("Maior saldo medio");
        telaObserver = new TelaObserver(tObserver);
        tObserver.setScene(telaObserver.getTelaObserver());
        tObserver.show();
    }
    
    @Override
    public void stop() {
        persistencia.saveContas(contas.values());
        persistencia.saveOperacoes(operacoes);
    }
    
    public static void main(String[] args) {
        launch(args);
    }


}

