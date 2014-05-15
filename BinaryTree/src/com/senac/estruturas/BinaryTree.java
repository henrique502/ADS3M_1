package com.senac.estruturas;

public class BinaryTree<T extends Comparable<T>>{
	private Nodo<T> raiz;
		
	
	public void insere(Nodo<T> novo){
		if(raiz == null){
			raiz=novo;
		}else{
			raiz.insere(novo);
		}
	}
	
	public void imprime(){
		raiz.imprime();
	}
	
}
