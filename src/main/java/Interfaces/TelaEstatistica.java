package Interfaces;

import javafx.scene.control.TextField;
import java.util.List;

import Negocios.Conta;
import Negocios.LogicaOperacoes;
import Negocios.Operacao;
import Negocios.Operacoes;
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
    private List<Operacao> operacoes;
    private TextField campoMes;
    private TextField campoAno;

    public TelaEstatistica(Stage mainStage, Scene cenaoperacoes, Conta c) {
        this.mainStage = mainStage;
        this.cenaOperacoes = cenaoperacoes;
        this.conta = c;
        this.operacoes = Operacoes.getInstance().getOperacoes();
        this.campoMes = new TextField();
        this.campoAno = new TextField();
    }

    public Scene getTelaEstatistica() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        String titulo = "Estatistica da conta " + conta.getNumero() + " : " + conta.getCorrentista();
        Text scenetitle = new Text(titulo);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Labels ------------------------------------------
        String mes = "MÊS: ";
        String ano = "ANO: ";
        String saldoMedio = "Saldo médio do mês: R$ ";
        String totalCreditos = "Total de créditos do mês: R$";	//total de R$  depositado
        String qtdCreditos = "Qtd de créditos do mês: ";		//qtd de epositos
        String totalDebitos = "Total de débitos do mês: R$"; 	//total de R$ retirado
        String qtdDebitos = "Qtd de débitos do mês: ";			//qtd de retiradas

        //-------Entrada
        Label labelMes = new Label(mes);
        Label labelAno = new Label(ano);

        HBox hbBtn3 = new HBox(20);
        hbBtn3.getChildren().add(labelMes);
        hbBtn3.getChildren().add(this.campoMes);
        hbBtn3.getChildren().add(labelAno);
        hbBtn3.getChildren().add(this.campoAno);

        Button btnOk = new Button("Ok");
        hbBtn3.getChildren().add(btnOk);

        grid.add(hbBtn3, 0, 1);

        //------
        Label saldoM = new Label(saldoMedio);
        grid.add(saldoM, 0, 3);

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
        grid.add(hbBtn, 1, 10);

        btnOk.setOnAction(e -> { //passar para LogicaOperacoes

            saldoM.setText("Saldo médio do mês: R$ " + LogicaOperacoes.getInstance().saldoMedio(conta, campoMes.getText(), campoAno.getText()));
            tCreditos.setText("Total de créditos do mês: R$ " + LogicaOperacoes.getInstance().ttCreditos(conta, campoMes.getText(), campoAno.getText()));	//total de R$  depositado
            qCreditos.setText("Qtd de créditos do mês: " + LogicaOperacoes.getInstance().qtdCreditos(conta, campoMes.getText(), campoAno.getText()));		//qtd de epositos
            tDebitos.setText("Total de débitos do mês: R$ " + LogicaOperacoes.getInstance().ttDebitos(conta, campoMes.getText(), campoAno.getText())); 	//total de R$ retirado
            qDebitos.setText("Qtd de débitos do mês: " + LogicaOperacoes.getInstance().qtdDebitos(conta, campoMes.getText(), campoAno.getText()));			//qtd de retiradas

        });

        btnVoltar.setOnAction(e -> {
            mainStage.setScene(cenaOperacoes);
        });

        cenaEstatistica = new Scene(grid);
        return cenaEstatistica;
    }
}
