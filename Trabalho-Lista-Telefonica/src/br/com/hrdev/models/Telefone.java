package br.com.hrdev.models;


public class Telefone implements Comparable<Telefone> {

	private String telefone, nome;
	
	public Telefone(){
		this(null,null);
	}
	
	public Telefone(String nome, String telefone) {
		this.telefone = telefone;
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString(){
		return this.nome + " - " + this.telefone;
	}

	@Override
	public int compareTo(Telefone tel) {
		if(this == tel)
			return 0;
		
		return this.nome.compareToIgnoreCase(tel.nome);
	}
	
	public boolean equals(Telefone tel) {
		if(this == tel)
			return true;
		
		if(this.nome == tel.nome && this.telefone == tel.telefone)
			return true;
		
		return false;
	}
	
	public boolean equals(String nome, String telefone) {
		return (this.nome.equals(nome) && this.telefone.equals(telefone));
	}
}
