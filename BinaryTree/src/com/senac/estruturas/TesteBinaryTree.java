package com.senac.estruturas;

public class TesteBinaryTree {
	
	public static void main(String[] args) {
		BinaryTree<String> bt = new BinaryTree<String>();
		
		bt.insere(new Nodo<String>("rafael"));
		bt.insere(new Nodo<String>("abel"));
		bt.insere(new Nodo<String>("gabriel"));
		bt.insere(new Nodo<String>("ismael"));
		bt.insere(new Nodo<String>("manoel"));
		bt.insere(new Nodo<String>("zeus"));
		
		bt.imprime();
	}
}
