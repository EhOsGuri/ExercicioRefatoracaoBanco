/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcopstein.ExercicioRefatoracaoBanco;
import javafx.scene.control.TextField;

import java.awt.TextArea;

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
    private TextField campoMes;
    private TextField campoAno;

    public TelaEstatistica(Stage mainStage, Scene cenaoperacoes,Conta c) {
	this.mainStage = mainStage;
	this.cenaOperacoes=cenaoperacoes;
	this.conta=c;
	this.campoMes = new TextField();
	this.campoAno = new TextField();
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
        
        String mes = "MÊS: ";
        String ano = "ANO: ";
        String saldoMedio = "Saldo médio do mês: ";
        String totalCreditos = "Total de créditos do mês: R$";	//total de R$  depositado
        String qtdCreditos = "Qtd de créditos do mês: ";		//qtd de epositos
        String totalDebitos = "Total de débitos do mês: R$"; 	//total de R$ retirado
        String qtdDebitos = "Qtd de débitos do mês: ";			//qtd de retiradas
        
        Label labelMes = new Label(mes);
        grid.add(labelMes, 0, 1);
        grid.add(this.campoMes, 1, 1);
           
        Label labelAno = new Label(ano); 
        grid.add(labelAno, 2, 1);
        grid.add(this.campoAno, 3, 1);
        
        Label saldoM = new Label(saldoMedio);
        grid.add(new Label(saldoMedio), 0, 3);
        
        Label tCreditos = new Label(totalCreditos);
        grid.add(tCreditos, 0, 4);
        
        Label qCreditos = new Label(qtdCreditos);
        grid.add(qCreditos, 0, 5);
        
        Label tDebitos = new Label(totalDebitos);
        grid.add(tDebitos, 0, 6);
        
        Label qDebitos = new Label(qtdDebitos);
        grid.add(qDebitos, 0, 7);
        
        //Botoes -----------------------------------------------
        Button btnVoltar = new Button("Voltar");
        HBox hbBtn = new HBox(20);
        hbBtn.getChildren().add(btnVoltar);
        grid.add(hbBtn, 10, 10);
        
        Button btnOk = new Button("Ok");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.getChildren().add(btnOk);
        grid.add(hbBtn2, 4, 1);
        
        btnVoltar.setOnAction(e->{
        	mainStage.setScene(cenaOperacoes);
        });
        
        cenaEstatistica = new Scene(grid);
        return cenaEstatistica;
    }

}
