package hr.com.hrdev.helpers;

import static java.lang.System.out;

import java.util.Scanner;

public class Console {

	private static Scanner sc;

	public static int[] nextPoint() throws Exception {
		int[] point = new int[2];
		sc = new Scanner(System.in);
		String line = sc.nextLine().toLowerCase();
		
		if(line.length() == 2 || line.length() == 3){
			char letra = line.charAt(0);
			switch (letra) {
				case 'a': point[0] = 0; break;
				case 'b': point[0] = 1; break;
				case 'c': point[0] = 2; break;
				case 'd': point[0] = 3; break;
				case 'e': point[0] = 4; break;
				case 'f': point[0] = 5; break;
				case 'g': point[0] = 6; break;
				case 'h': point[0] = 7; break;
				case 'i': point[0] = 8; break;
				case 'j': point[0] = 9; break;
				default: throw new Exception("Letra invalida");
			}
			int numero = Integer.parseInt("" + line.charAt(1));
			if(numero >= 0 && numero <= 9){
				point[1] = numero;
			} else {
				throw new Exception("Numero invalido");
			}
		} else {
			throw new Exception("Comando invalido");
		}
		return point;
	}
	
	public static String nextLine() {
		sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static int nextInt() {
		sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static void pressEnter() {
		out.println("\nPrecione Enter para continuar\n");
		try {
			System.in.read();
		} catch(Exception e){}
	}
	
}
