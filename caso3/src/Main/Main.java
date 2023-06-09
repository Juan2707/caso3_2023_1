package Main;

import java.util.Scanner;

public class Main {
	public static boolean terminar;
	
	public static void main(String[] args) {
		terminar=false;
		System.out.println("Inicio programa encriptación");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Que algoritmo de generación desea usar?");
		System.out.println("SHA256 o SHA512");
		String tipoHash = scanner.nextLine();
		System.out.println("Ingresa la cadena C:");
		String cadenaSecuencia = scanner.nextLine();
		System.out.println("Ingresa la secuencia S");
		String sal = scanner.nextLine();
		System.out.println("Cuantos threads desea poner en ejecución? (1 o 2)");
		String numThreads = scanner.nextLine();
		
		if(numThreads.equals("1")) {
			Tbusqueda thread1 = new Tbusqueda(tipoHash, cadenaSecuencia, sal, 1, terminar);
			thread1.start();
		}
		else if(numThreads.equals("2")) {
			Tbusqueda thread1 = new Tbusqueda(tipoHash, cadenaSecuencia, sal, 1, terminar);
			Tbusqueda thread2 = new Tbusqueda(tipoHash, cadenaSecuencia, sal, 2, terminar);
			thread1.start();
			thread2.start();
		}
		
	}
}
