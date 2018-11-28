package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.Observable;
import java.util.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaObserver implements Observer {
	private Stage mainStage;
    private Scene cenaObserver;
    private TextField nomeCorrentistaTextField;
    private TextField maiorSaldoMedioTextField;//saldo médio com o maior saldo médio da agência   
    private Observable observados;
    private Conta contaMaiorSaldoMedio;
    
    public TelaObserver(Stage mainStage) {
    	this.mainStage=mainStage;
    	this.observados=Persistencia.getInstance();
    	observados.addObserver(this);
    	
    }
    public Scene getTelaObserver() {
    	GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        String titulo = "Correntista com o maior saldo medio da agencia:  ";
        Text scenetitle = new Text(titulo);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        String nome = "Nome do correntista: ";
        String saldoMedio = "Saldo medio: R$";
        
        Label labelNome = new Label(nome);
        grid.add(labelNome, 0, 3);
        
        Label labelSaldo = new Label(saldoMedio);
        grid.add(labelSaldo, 0, 4);
        
        Conta c = LogicaOperacoes.getInstance().maiorSaldoMedio();
        this.nomeCorrentistaTextField.setText(c.getCorrentista());
       // this.maiorSaldoMedioTextField.setText(c.);
        
    	cenaObserver = new Scene(grid);
        return cenaObserver;
    }

	@Override
	public void update(Observable p, Object arg1) {
		// TODO Auto-generated method stub
		if(p instanceof Persistencia) {
			Persistencia pers = (Persistencia) p;
			contaMaiorSaldoMedio=pers.getContaMaiorSaldoMedio();
			System.out.println("Atualização de saldo médio.");
		}
	}
}
