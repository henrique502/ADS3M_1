package com.senac.estruturas;

public class Nodo<T extends Comparable<T>>{
	private Nodo<T> pai;
	private Nodo<T> esq;
	private Nodo<T> dir;
	private T valor;

	public void insere(Nodo<T> novo){
		int cmp = novo.getValor().compareTo(valor);

		if(cmp < 0){

			if(esq ==null){

				esq = novo;
				novo.setPai(this);
			}

			else{

				esq.insere(novo);

			}
		}
		if(cmp > 0){

			if(dir ==null){

				dir = novo;
				novo.setPai(novo);
			}

			else{

				dir.insere(novo);

			}
		}

		return;
	}



	private void setPai(Nodo<T> nodo) {

		this.pai = nodo;	

	}

	public Nodo(T valor){

		pai=null;
		esq=null;
		dir=null;
		this.valor = valor;

	}

	public T getValor(){

		return this.valor;

	}
	public void setValor(T valor){

		this.valor = valor;

	}

	public void imprime(){

		System.out.print("(" + valor);

		if(esq != null){

			esq.imprime();

		}else{

			System.out.print("()");
		}
		if(dir != null){

			dir.imprime();

		}else{

			System.out.print("()");
		}
		System.out.print(")");

	}

}
