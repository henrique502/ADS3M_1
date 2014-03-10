package br.com.hrdev;

import java.util.Scanner;

import br.com.hrdev.estruturas.FileHandler;
import br.com.hrdev.estruturas.ListaOrdenada;
import br.com.hrdev.models.Telefone;

public class Main {
	
	private ListaOrdenada<Telefone> listaTelefonica = null;
	private ListaOrdenada<Telefone> listaPorLetra = null;
	private FileHandler file = null;
	private Scanner sc = new Scanner(System.in);
	
	public Main(){}
	
	private void run(String location) {
		try {
			file = new FileHandler(location);
			listaTelefonica = file.getData();
			
			
			
			//file.insertTelefone(new Telefone("Teste 123","000000"));
			//file.removeTelefone(new Telefone("Teste 123","000000"));
			
			listaTelefonica = file.getData();
			
			listaTelefonica.print();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Parametro do local do arquivo de telefones nao encontrado! Exemplo: /ADS3M_1/Trabalho-Lista-Telefonica/telefones-database.csv");
			return;
		}
		
		Main main = new Main();
		main.run(args[0]);
		main.sc.close();
	}

}
