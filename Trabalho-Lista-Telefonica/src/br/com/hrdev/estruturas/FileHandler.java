package br.com.hrdev.estruturas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.hrdev.models.Telefone;

public class FileHandler {

	
	private String location = null;
	private String location_bk = null;
	private ListaOrdenada<Telefone> cache = null;
	
	public FileHandler(String location) throws Exception {
		this.location = location;
		this.location_bk = location + ".updating";
		this.cache = this.readFile();
	}
	
	private ListaOrdenada<Telefone> readFile() throws Exception {
		ListaOrdenada<Telefone> lista = new ListaOrdenada<Telefone>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(this.location)));
			String line = null;
	
			int linhaNum = 1;
			
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				if(parts.length == 2){
					lista.insert(new Nodo<Telefone>(new Telefone(parts[0],parts[1])));
				} else {
					exceptionFileFormat(linhaNum);
				}
				linhaNum++;			
			}
		} finally {
			if (reader != null) {
	            reader.close();
	        }
		}
		
		return lista;
	}
	
	public void insertTelefone(Telefone telefone) throws IOException{
		PrintWriter out = null;
		try {
		    out = new PrintWriter(new BufferedWriter(new FileWriter(this.location, true)));
		    out.println(telefone.getNome() + ";" + telefone.getTelefone());
		    this.cache.insert(new Nodo<Telefone>(telefone));
		} finally {
			if (out != null) {
				out.close();
	        }
		}
	}
	
	public void removeTelefone(Telefone telefone) throws Exception {
		BufferedReader reader = null;
		PrintWriter out = null;
		File file = new File(this.location);
		File bk = new File(this.location_bk);
		
		try {
			reader = new BufferedReader(new FileReader(file));
			out = new PrintWriter(new BufferedWriter(new FileWriter(bk, true)));
			String line = null;
			int linhaNum = 1;
			
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				if(parts.length == 2){
					if(!telefone.equals(parts[0], parts[1])){
						out.println(line);
					}
				} else {
					exceptionFileFormat(linhaNum);
				}
				linhaNum++;
			}
			
		} finally {
			if (reader != null) {
	            reader.close();
	        }
			
			if (out != null) {
				out.close();
	        }
		}
		file.delete();
		bk.renameTo(file);
		bk.delete();
		
		this.cache = this.readFile();
	}
	
	public ListaOrdenada<Telefone> getData(){
		return this.cache;
	}

	private void exceptionFileFormat(int linhaNum) throws Exception {
		throw new Exception("Lina: " + linhaNum + " - formato inválido");
	}
}
