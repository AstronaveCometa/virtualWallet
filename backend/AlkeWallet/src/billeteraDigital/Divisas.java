/** Clase para crear objetos Divisas, con un arraylist de monedas y con dolar, peso chileno y euro por defecto
* @author Sebastián León
* @version 1.0
*
**/

package billeteraDigital;

import java.util.ArrayList;
import java.util.Scanner;

public class Divisas {
	
	protected ArrayList<Moneda> divisas = new ArrayList<Moneda>(3);
	
	/** 
	* Constructor que pobla el ArrayList de monedas del objeto Divisas con 3 objetos de tipo Moneda por defecto: dolar, peso y euro
	**/
	public Divisas() {
		Moneda dolar = new Moneda("dolar", 1f, '$');
		Moneda euro = new Moneda("euro", 0.93f, '€');
		Moneda pesoChileno = new Moneda("peso chileno", 952.76f, '$');
		
		divisas.add(dolar);
		divisas.add(euro);
		divisas.add(pesoChileno);

	}
	
	
	public Moneda getMonedas(int index) {
		return divisas.get(index);
	}
	
	/** 
	* Método para crear nuevas divisas y agregarlas al ArrayList de Divisas por consola
	**/
	public void agregarDivisa (String nombre, float proporcion, char simbolo) {
		Moneda nuevaDivisa = new Moneda(nombre, proporcion, simbolo);
		divisas.add(nuevaDivisa);
		System.out.println("Nueva divisa creada: \n" + divisas.get(divisas.size()-1).toString());
	}
	
	/** 
	* Método para mostrar las divisas del objeto
	**/
	public void mostrarDivisas () {
		int i = 0;
		System.out.println("Divisas disponibles: ");
		for (Moneda moneda : divisas) {
			System.out.println("Divisa " + i + ": " + moneda.toString());
			i++;
		}
	}
}
