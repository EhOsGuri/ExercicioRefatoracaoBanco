/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcopstein.ExercicioRefatoracaoBanco;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaEstatistica {
private Stage mainStage; 
	
    private Scene cenaEstatistica;
    private Scene cenaOperacoes;
    private Conta conta; 

    public TelaEstatistica(Stage mainStage, Scene cenaoperacoes,Conta c) {
	this.mainStage = mainStage;
	this.cenaOperacoes=cenaoperacoes;
	this.conta=c;
    }
    
	public Scene getTelaEstatistica(){
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        String titulo = "Estatistica da conta " + conta.getNumero()+" : "+conta.getCorrentista();
        Text scenetitle = new Text(titulo);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        //Labels ------------------------------------------
        String saldoMedio = "Saldo médio do mês: ";
        String totalCreditos = "Total de créditos do mês: R$";	//total de R$  depositado
        String qtdCreditos = "Qtd de créditos do mês: ";		//qtd de epositos
        String totalDebitos = "Total de débitos do mês: R$"; 	//total de R$ retirado
        String qtdDebitos = "Qtd de débitos do mês: ";			//qtd de retiradas
        
        Label saldoM = new Label(saldoMedio);
        grid.add(new Label(saldoMedio), 0, 1);
        
        Label tCreditos = new Label(totalCreditos);
        grid.add(tCreditos, 0, 2);
        
        Label qCreditos = new Label(qtdCreditos);
        grid.add(qCreditos, 0, 3);
        
        Label tDebitos = new Label(totalDebitos);
        grid.add(tDebitos, 0, 4);
        
        Label qDebitos = new Label(qtdDebitos);
        grid.add(qDebitos, 0, 5);
        
        //Botao -----------------------------------------------
        Button btnVoltar = new Button("Voltar");
        HBox hbBtn = new HBox(20);
        hbBtn.getChildren().add(btnVoltar);
        grid.add(hbBtn, 10, 10);
        
        btnVoltar.setOnAction(e->{
        	mainStage.setScene(cenaOperacoes);
        });
        
        cenaEstatistica = new Scene(grid);
        return cenaEstatistica;
    }

}
