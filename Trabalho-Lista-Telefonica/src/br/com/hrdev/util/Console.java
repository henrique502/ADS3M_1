package br.com.hrdev.util;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Console {

	public static String getString(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public static String getStringLower(){
		return getString().toLowerCase();
	}
	
	public static char getFirstChar(){
		char[] array = getString().toCharArray();
		return array[0];
	}
	
	public static char getFirstCharLower(){
		char[] array = getStringLower().toCharArray();
		return array[0];
	}
	
	public static int getInt(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
}
