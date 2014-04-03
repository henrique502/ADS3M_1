package hr.com.hrdev.controllers;

import hr.com.hrdev.helpers.Console;
import hr.com.hrdev.models.Player;
import hr.com.hrdev.models.navios.Navio;
import hr.com.hrdev.views.GameView;

public class HomeController {

	private Player players[];
	
	public HomeController(){
		
		GameView.Welcome();
		setPlayers();
		startGame();
	}
	
	private void setPlayers(){
		players = new Player[2];
		for (int i = 0; i < players.length; i++) {
			GameView.setPlayerName(i);
			players[i] = new Player(Console.nextLine());
		}
	}
	
	private void startGame(){
		int turno = 1;
		
		do {
			Player player = getNextPlayer(turno);
			GameView.turno(turno, player);
			turno++;
			
			Player enemy = getNextPlayer(turno);
			GameView.showFiled(enemy);
			
			requestTarget(player, enemy);
			
			GameView.separador();
		} while(!gameHasEnd());
		
		GameView.showVictory(players);
	}
	
	private void requestTarget(Player player, Player enemy) {
		do {
			GameView.setPoint();
			try {
				int[] point = Console.nextPoint();
				int status = enemy.getBattlefield().hitTarget(point);
				
				if(status == 1){
					Navio navio = enemy.getBattlefield().getNavioByPoint(point);
					
					if(navio.isDead()){
						player.shotDestroy();
						GameView.shipIsDestroy(navio);
					} else {
						player.shotHit();
						GameView.shotHit();
					}
					break;
				}
				
				if(status == -1){
					player.shotMissing();
					GameView.shotMissing();
					break;
				}
				
				GameView.invalidTarget();
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		} while(true);
	}

	private boolean gameHasEnd(){
		boolean status = true;
		for (int i = 0; i < players.length; i++) {
			if(players[i].isDead())
				return true;
			
			Navio[] navios = players[i].getNavios();
			for (int n = 0; n < navios.length; n++) {
				if(!navios[n].isDead())
					status = false;
			}
			if(status)
				players[i].kill();
		}
		return status;
	}
	
	private Player getNextPlayer(int turno){
		if((turno % 2) == 0)
			return players[1];
		
		return players[0];
	}
	
}
