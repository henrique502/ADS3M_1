package br.com.hrdev.estruturas;

public class ListaEncadeada<T extends Comparable<T>> {
	
	private Nodo<T> head; // will be a Nodo
	private Nodo<T> tail; // will be a Nodo
	
	public Nodo<T> getHead()
	{
		return head;
	}
	
	public void print()
	{
		Nodo<?> nodo = head;
		do {
			System.out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null);
	}
	
	public void insert(Nodo<T> novo)
	{
		novo.setNext(head);
		head = novo;
		
		if (tail == null)
			tail = head;
	}

	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		if (anterior == tail) {
			tail.setNext((Nodo<T>)novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	public void append(Nodo<T> novo)
	{
		tail.setNext(novo);
		tail = novo;
	}
	
	public void remove(Nodo<T> atual){
		Nodo<T> nodo = head;
		Nodo<T> prev = null;
		
		if(nodo != null){
			do {
				if(nodo == atual){
					if(prev != null){
						prev.setNext(atual.getNext());
					} else {
						head = atual.getNext();
					}
					if(tail == atual)
						tail = prev;
				} else {
					prev = nodo;
					nodo = nodo.getNext();
				}
			} while (nodo != null);
		}		
	}

}
