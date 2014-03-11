package br.com.hrdev;

import static java.lang.System.out;

import java.io.IOException;

import br.com.hrdev.estruturas.FileHandler;
import br.com.hrdev.estruturas.ListaEncadeada;
import br.com.hrdev.estruturas.ListaOrdenada;
import br.com.hrdev.estruturas.Nodo;
import br.com.hrdev.models.Telefone;
import br.com.hrdev.util.Console;

public class Main {
	
	private ListaOrdenada<Telefone> listaTelefonica = null;
	private ListaEncadeada<Telefone> listaPorLetra = null;
	private FileHandler file = null;
	
	private Main(){}
	
	private void view(){
		String comando = null;
		do {
			out.println();
			out.println("Comandos: listar, buscar, adicionar ou sair");
			comando = Console.getStringLower();
			
			if(comando.equals("listar"))
				viewListar();
			else if(comando.equals("buscar"))
				viewBuscar();
			else if(comando.equals("adicionar"))
				viewAdicionar();
			else if(comando.equals("sair"))
				break;
			else out.println("comando inválido");
			
		} while(true);
	}
	
	private void viewBuscar() {
		out.println("Digite a primeria letra do contato");
		char letra = Console.getFirstCharLower();
		updateListaPorLetra(letra);
			
		if(listaPorLetra.getHead() != null){
			walkList();
		} else {
			out.println("Nenhum contado encontrado");
		}
		listaPorLetra = null;
	}
	
	private void walkList() {
		//TODO: Refazer, nao esta funcionando, rever classe de listas
		Nodo<Telefone> nodo = listaPorLetra.getHead();
		Nodo<Telefone> prev = null;
		do {
			Telefone tel = nodo.getData();
			out.println();
			
			out.println(tel);
			
			out.println();
			String options = "Comandos: remover, sair";
			if(prev != null)
				options += ", voltar";
			
			if(nodo.getNext() != null)
				options += ", avancar";
			
			out.println(options);
			
			String comando = Console.getStringLower();
			
			if(comando.equals("sair"))
				return;
			
			else if(comando.equals("remover")){
				//file.removeTelefone(tel);
				listaPorLetra.remove(nodo);
				
				listaPorLetra.print();
			} else if(comando.equals("voltar"))
				
				out.println("voltar");
			else if(comando.equals("avancar"))
				out.println("avancar");
			
			
			
		} while (nodo != null);
	}


	private void updateListaPorLetra(char letra){
		Nodo<Telefone> nodo = listaTelefonica.getHead();
		listaPorLetra = new ListaEncadeada<Telefone>();
		boolean inLoop = true;
		
		do {
			Telefone tel = nodo.getData();
			char[] chars = tel.getNome().toLowerCase().toCharArray();
			if(letra == chars[0]){
				listaPorLetra.insert(new Nodo<Telefone>(tel));
				inLoop = false;
			} else {
				if(!inLoop)
					break;
			}
			nodo = nodo.getNext();
		} while (nodo != null);
	}

	private void viewAdicionar(){
		Telefone tel = new Telefone();
		out.println("Digite o nome do seu contato:");
		tel.setNome(Console.getString());
		out.println("Agora o telefone:");
		tel.setTelefone(Console.getString());
		
		try {
			file.insertTelefone(tel);
			listaTelefonica = file.getData();
			out.println("Telefone inserido com sucesso!");
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void viewListar() {
		out.println();
		
		Nodo<Telefone> nodo = listaTelefonica.getHead();
		do {
			out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null);
		
		out.println();
		
		try {
			out.println("Precione Enter para continuar");
			System.in.read();
		} catch (IOException e){}	
	}

	private void run(String location) {
		try {
			file = new FileHandler(location);
			listaTelefonica = file.getData();
			
			view();
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
	}
	
}
