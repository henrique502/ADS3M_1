package hr.com.hrdev.models;

import hr.com.hrdev.models.navios.Navio;

import java.util.Random;

public class Battlefield {
	
	private Navio[][] map;
	private int[][] field;
	private int size = 10;
	private Random random;
	
	public Battlefield(Player player){
		this.map = new Navio[size][size];
		this.field = new int[size][size];
		this.random = new Random();
		allocateShips(player);
		this.random = null;
	}
	
	public Navio[][] getMap(){
		return this.map;
	}
	
	public int[][] getField(){
		return this.field;
	}

	private void allocateShips(Player player) {
		Navio[] navios = player.getNavios();
		for (int i = 0; i < navios.length; i++){
			allocate(navios[i]);
		}
	}

	private void allocate(Navio navio) {
		int size = navio.getSize();
		int[][] points = new int[size][2];
		
		if(random.nextBoolean()){ /* x */ 
			int x = getRandomPos(size);
			int y = getRandomPos(0);
			
			for (int i = 0; i < size; i++) {
				points[i][0] = x++;
				points[i][1] = y;
			}
		} else { /* y */
			int x = getRandomPos(0);
			int y = getRandomPos(size);
			
			for (int i = 0; i < size; i++) {
				points[i][0] = x;
				points[i][1] = y++;
			}
		}
		
		if(!tryAllocate(navio,points))
			allocate(navio);
	}
	
	private boolean tryAllocate(Navio navio, int[][] points) {
		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];

			if(map[x][y] != null)
				return false;
		}
		
		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];

			map[x][y] = navio;
			navio.setPoints(points);
		}
		
		return true;
	}

	private int getRandomPos(int shipSize){
		int limit = size - shipSize;
		return random.nextInt(limit);
	}
	
	public Navio getNavioByPoint(int[] point){
		if(map[point[0]][point[1]] != null)
			return map[point[0]][point[1]];
		return null;
	}

	public int hitTarget(int[] point) {
		if(field[point[0]][point[1]] == 0){
			if(map[point[0]][point[1]] != null){
				Navio navio = map[point[0]][point[1]];
				field[point[0]][point[1]] = 1;
				navio.hit();
				return 1;
			} else {
				field[point[0]][point[1]] = -1;
				return -1;
			}
		}
		return 0;
	}
}
