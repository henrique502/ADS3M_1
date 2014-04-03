package hr.com.hrdev.models;

import hr.com.hrdev.models.navios.Navio;

public class Player {
	
	private String nome;
	private int life;
	private Navio[] navios;
	private Battlefield battlefield;
	
	public Player(String nome){
		this.nome = nome;
		this.life = 15; // 15
		this.navios = Navio.genrate();
		this.battlefield = new Battlefield(this);
	}
	
	public Battlefield getBattlefield(){
		return this.battlefield;
	}
	
	public Navio getNavio(int index){
		if(index >= 0 && index < this.navios.length)
			return this.navios[index];
		
		return null;
	}
	
	public Navio[] getNavios(){
		return this.navios;
	}
	
	public void shotMissing(){
		if(this.life > 0)
			this.life--;
	}
	
	public void shotHit(){
		this.life += 2;
	}
	
	public void shotDestroy(){
		this.life += 4;
	}
	
	public boolean isDead(){
		return (this.life == 0);
	}
	
	public int getPoints(){
		return this.life;
	}
	
	public void kill(){
		this.life = 0;
	}
	
	public boolean hasLivingShips(){
		for (Navio navio : navios){
			if(!navio.isDead())
				return true;
		}
		return false;
	}
	
	public String toString(){
		return this.nome;
	}
	
	
}
