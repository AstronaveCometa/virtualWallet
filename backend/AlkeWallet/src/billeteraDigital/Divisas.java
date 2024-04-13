/** Clase para crear objetos Divisas, con un arraylist de monedas y con dolar, peso chileno y euro por defecto
* @author Sebastián León
* @version 1.0
*
**/

package billeteraDigital;

import java.util.ArrayList;
import java.util.Scanner;

public class Divisas {
	
	public ArrayList<Moneda> divisas = new ArrayList<Moneda>(3);
	
	/** 
	* Constructor que pobla el ArrayList de monedas del objeto Divisas con 3 objetos de tipo Moneda por defecto: dolar, peso y euro
	**/
	public Divisas() {
		Moneda dolar = new Moneda("dolar", 1f, '$');
		Moneda pesoChileno = new Moneda("peso chileno", 952.76f, '$');
		Moneda euro = new Moneda("euro", 0.93f, '€');
		
		divisas.add(dolar);
		divisas.add(euro);
		divisas.add(pesoChileno);

	}
	
	/** 
	* Método para crear nuevas divisas y agregarlas al ArrayList de Divisas por consola
	**/
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
		System.out.println("Nueva divisa creada: \n" + divisas.get(divisas.size()).toString());
		teclado.close();
	}
	
	/** 
	* Método para mostrar las divisas del objeto
	**/
	public void mostrarDivisas () {
		int i = 0;
		System.out.println("Divisas disponibles: ");
		for (Moneda moneda : divisas) {
			System.out.println("Divisa" + i + ": " + moneda.toString());
			i++;
		}
	}
}
