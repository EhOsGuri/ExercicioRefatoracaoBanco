package Persistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;

import Negocios.Conta;
import Negocios.Operacao;

public class Persistencia extends Observable{
 
    private static Persistencia uniqueInstance;
    private final String NomeBDContas;
    private final String NomeBDOperacoes;
    private Conta contaMaiorSaldoMedio;    
 
    private Persistencia() {
    	NomeBDContas = "BDContasBNG.txt";
        NomeBDOperacoes = "BDOperBNG.txt";
    }
    
    //*@ ensures uniqueInstance!=null
    public static Persistencia getInstance() {
        if (uniqueInstance == null) {
        	System.out.println("Instancia de Persistencia criada...");
            uniqueInstance = new Persistencia();
        }
        return uniqueInstance;
    }
    
    public Map<Integer,Conta> loadContas(){
    	Map<Integer,Conta> contas = new HashMap<>();
    	
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+NomeBDContas;
        System.out.println(nameComplete);
        Path path2 = Paths.get(nameComplete); 
        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){ 
           sc.useDelimiter("[;\n]"); // separadores: ; e nova linha 
           int numero;
           String nomeCorr;
           double saldo;
           int status;
           while (sc.hasNext()){ 
               numero = Integer.parseInt(sc.next()); 
               nomeCorr = sc.next();
               saldo = Double.parseDouble(sc.next());
               status = Integer.parseInt(sc.next());
               Conta conta = new Conta(numero,nomeCorr,saldo,status);
               contas.put(numero, conta);
           }
        }catch (IOException x){ 
            System.err.format("Erro de E/S: %s%n", x);
            return null;
        } 
        return contas;
    }

    public void saveContas(Collection<Conta> contas) {
        Path path1 = Paths.get(NomeBDContas); 
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) 
        { 
            for(Conta c: contas) 
                writer.format(Locale.ENGLISH,
                		      "%d;%s;%f;%d;",
                		      c.getNumero(),c.getCorrentista(), 
                              c.getSaldo(),c.getStatus()); 
        } 
        catch (IOException x) 
        { 
            System.err.format("Erro de E/S: %s%n", x); 
        } 
    }

    public void saveOperacoes(Collection<Operacao> operacoes) {
        Path path1 = Paths.get(NomeBDOperacoes); 
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) 
        { 
            for(Operacao op:operacoes) 
                writer.format(Locale.ENGLISH,
                		      "%d;%d;%d;%d;%d;%d;%d;%d;%f;%d;",  
                              op.getDia(),op.getMes(),op.getAno(),
                              op.getHora(),op.getMinuto(),op.getSegundo(),
                              op.getNumeroConta(),op.getStatusConta(),
                              op.getValorOperacao(),op.getTipoOperacao()
                             ); 
        } 
        catch (IOException x) 
        { 
            System.err.format("Erro de E/S: %s%n", x); 
        } 
    }
    
    public List<Operacao> loadOperacoes(){
        List<Operacao> operacoes = new LinkedList<Operacao>();
        
    	String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+NomeBDOperacoes;
        System.out.println(nameComplete);
        Path path2 = Paths.get(nameComplete); 
        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){ 
           sc.useDelimiter("[;\n]"); // separadores: ; e nova linha 
           int dia,mes,ano;
           int hora,minuto,segundo;
           int numero,status,tipo;
           double valor;
       
           while (sc.hasNext()){ 
               dia = Integer.parseInt(sc.next()); 
               mes = Integer.parseInt(sc.next()); 
               ano = Integer.parseInt(sc.next()); 
               hora = Integer.parseInt(sc.next()); 
               minuto = Integer.parseInt(sc.next()); 
               segundo = Integer.parseInt(sc.next()); 
               numero = Integer.parseInt(sc.next()); 
               status = Integer.parseInt(sc.next()); 
               valor = Double.parseDouble(sc.next());
               tipo = Integer.parseInt(sc.next());
               
               Operacao op = new Operacao(
            		   dia, mes, ano,
            		   hora, minuto, segundo,
	                   numero, status,
	                   valor, tipo);
               
               operacoes.add(op);
           }
        }catch (IOException x){ 
            System.err.format("Erro de E/S: %s%n", x);
            return null;
        } 
        return operacoes; 
    }
        
    public void calcularMaiorSaldoMedio() {
    	Map<Integer,Conta> contas = loadContas();
    	double maior=0;
    	for(Map.Entry<Integer, Conta> entry : contas.entrySet()){
    		//if()
    	}
    	
    	//exemplo percorrer map
//    	for (Map.Entry<String, Estado> entry : atual.getDestinos().entrySet()){
//			//System.out.println("2...");
//			String chave = entry.getKey();
//			Estado valor = entry.getValue();
//			char chaveAux=chave.charAt(0);
//			if(chaveAux==c) {
//				atual=valor;
//				cont++;
//				break;
//			}
//		}
    }
    
    /*@ pure @*/
    public Conta getContaMaiorSaldoMedio() { 
    	return this.contaMaiorSaldoMedio;
    }
    public void setContaMaiorSaldoMedio(Conta c) {
    	this.contaMaiorSaldoMedio=c;
    	setChanged();
    	notifyObservers();
    }
}