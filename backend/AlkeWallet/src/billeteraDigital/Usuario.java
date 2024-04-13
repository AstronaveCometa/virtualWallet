/** Clase para crear objetos usuario, con nombre, rut, email y cuentas
* @author Sebastián León
* @version 1.0
*
**/

package billeteraDigital;

import java.util.ArrayList;

public class Usuario {
	
	//atributos
	private String nombre;
	private String rut;
	private String email;
	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	//constructor vacío
	public Usuario() {
		
	}
	
	/** 
	* Constructor por defecto
	* @param String nombre - nombre del usuario a crear
	* @param String rut - rut del usuario a crear
	* @param String email - email del usuario a crear
	**/
	public Usuario(String nombre, String rut, String email) {
		this.nombre = nombre;
		this.rut = rut;
		this.email = email;
	}

	
	//Setters and Getters
	
	//nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//rut
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}

	//email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//ArrayList de cuentas
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	/** 
	* Método para crear nueva cuenta con numero de cuenta aleatorio
	* @param Objeto Moneda - divisa para configurar la nueva cuenta del usuario
	**/
	public void crearCuenta (Moneda divisa) {

		Cuenta nuevaCuenta = new Cuenta((int) (Math.random()*100000), 5000d, divisa);
		
		cuentas.add(nuevaCuenta);
		
		System.out.println("Se ha creado una nueva cuenta del usuario " + this.nombre + ": ");
		System.out.println(cuentas.get(cuentas.size()-1).toString());
				
	}
	
	/** 
	* Método para mostrar las cuentas de un usuario
	**/
	public void mostrarCuentas() {
		if(this.cuentas.isEmpty()) {
			System.out.println("El usuario " + nombre + " no tiene cuentas.");
		} else {
			for (Cuenta cuenta : cuentas) {
				cuenta.toString();
			}
		}
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nRut: " + rut + "\nEmail: " + email + "\n";
	}
	
	
	
	
	
}
