package hr.com.hrdev.views;
import static java.lang.System.out;

import hr.com.hrdev.models.Player;
import hr.com.hrdev.models.navios.Navio;

public class GameView {
	
	private static char[] letras = {'A','B','C','D','E','F','G','H','I','J'};
	
	public static void Welcome(){
		out.println("-- | Batalha Naval | --");
	}
	
	public static void setPlayerName(int index){
		out.println("Digite o nome do jogador " + (index + 1));
	}
	
	public static void turno(int turno, Player player){
		out.println("Turno " + turno + ", vez do jogador " + player + ", pontos restantes: " + player.getPoints());
	}

	public static void showFiled(Player player) {
		int[][] field = player.getBattlefield().getField();
		
		out.print("   ");
		for (int y = 0; y < field[0].length; y++){
			out.print(" " + y);
		}
		out.println();
		
		for (int x = 0; x < field.length; x++) {
			out.print(letras[x] + " |");
			for (int y = 0; y < field[x].length; y++){
				char marca = '.';
				if(field[x][y] == 1)
					marca = 'o';
				if(field[x][y] == -1)
					marca = '-';
				out.print(" " + marca);
			}
			out.println(" |");
		}
	}

	public static void setPoint() {
		out.println("Digite a coordenada:");
	}

	public static void shotHit() {
		out.println("O disparo acertou");
	}

	public static void shotMissing() {
		out.println("O disparo nao acertou");
	}

	public static void invalidTarget() {
		out.println("Alvo invalido");
	}
	
	public static void separador() {
		out.println("\n-----------------------\n");
	}

	public static void shipIsDestroy(Navio navio) {
		out.println(navio + " foi destruido!");
		
	}

	public static void showVictory(Player[] players) {
		Player vencedor, derrotado;
		if(players[0].isDead()){
			vencedor = players[1];
			derrotado = players[0];
		} else {
			vencedor = players[0];
			derrotado = players[1];	
		}
		out.println(vencedor + " venceu o " + derrotado + "!\nNavios:");
		Navio[] navios = vencedor.getNavios();
		for (int i = 0; i < navios.length; i++) {
			if(navios[i].isDead()){
				out.println(" - " + navios[i] + ", Destruido");
			} else {
				out.println(" - " + navios[i] + ", " + navios[i].getLife() + "/" + navios[i].getSize());
			}
		}
	}
}
