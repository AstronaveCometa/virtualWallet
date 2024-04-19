/** Clase para crear objetos Moneda, con nombre, proporcionDolar y signo
* @author Sebastián León
* @version 1.0
*
**/

package billeteraDigital;

public class Moneda implements Currency{
	
	//declaración de atributos
	private String nombre;
	private float proporcionDolar;
	private char signo;
	
	//constructor vacío
	public Moneda() {
		
	}
	
	/**
	* Constructor por defecto
	* @param String nombre - nombre de la divisa a crear
	* @param float proporcionDolar - proporción de la moneda con respecto de 1 dolar
	* @param char signo - signo de la divisa a crear
	**/
	public Moneda(String nombre, float proporcionDolar, char signo) {
		this.nombre = nombre;
		this.proporcionDolar = proporcionDolar;
		this.signo = signo;
	}

	
	
	//Setters y Getters
	
	//nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//proporcionDolar
	public float getProporcionDolar() {
		return proporcionDolar;
	}
	public void setProporcionDolar(float proporcionDolar) {
		this.proporcionDolar = proporcionDolar;
	}

	//signo
	public char getSigno() {
		return signo;
	}
	public void setSigno(char signo) {
		this.signo = signo;
	}

	//método toString
	@Override
	public String toString() {
		return "\nNombre: " + nombre + "\nProporcion con dolar: " + proporcionDolar + "\nSigno: " + signo + "\n";
	}
	
	
	
	
}
