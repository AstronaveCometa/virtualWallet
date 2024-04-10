package billeteraDigital;

import java.util.ArrayList;
import java.util.Scanner;

public class Divisas {
	
	public ArrayList<Moneda> divisas = new ArrayList<Moneda>(3);
	
	public Divisas() {
		Moneda dolar = new Moneda("dolar", 1f, '$');
		Moneda pesoChileno = new Moneda("peso chileno", 952.76f, '$');
		Moneda euro = new Moneda("euro", 0.93f, '€');
		
		divisas.add(dolar);
		divisas.add(euro);
		divisas.add(pesoChileno);

	}
	
	public void agregarDivisa () {
		String nombre;
		float proporcion;
		char simbolo;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre de la nueva divisa: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese la proporción con respecto del dolar de la nueva divisa: ");
		proporcion = teclado.nextFloat();
		
		System.out.println("Ingrese el símbolo de la nueva divisa: ");
		simbolo = teclado.next().charAt(0);
		
		Moneda nuevaDivisa = new Moneda(nombre, proporcion, simbolo);
		divisas.add(nuevaDivisa);
		
		teclado.close();
	}
	
	public void mostrarDivisas () {
		int i = 0;
		System.out.println("Divisas disponibles: ");
		for (Moneda moneda : divisas) {
			System.out.println("Divisa" + i + ": " + moneda.toString());
			i++;
		}
	}
}
