/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcopstein.ExercicioRefatoracaoBanco;


import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 17111233
 */
public class TelaEstatistica {
private Stage mainStage; 
	
    private Scene cenaOperacoes;
    private Conta conta; 

    public TelaEstatistica(Stage mainStage, Scene telaOperacoes,Conta conta) {
	this.mainStage = mainStage;
	this.cenaOperacoes = telaOperacoes;
	this.conta = conta;
    }
    
    public Scene getTelaEstatistica(){
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        cenaOperacoes = new Scene(grid);
        return cenaOperacoes;
    }

}
