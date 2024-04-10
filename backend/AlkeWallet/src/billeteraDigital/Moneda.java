package billeteraDigital;

public class Moneda {
	
	//declaración de atributos
	private String nombre;
	private float proporcionDolar;
	private char signo;
	
	//constructor vacío
	public Moneda() {
		
	}
	
	//constructor para poblado de atributos
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
