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
	
	//constructor para poblar	
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

	//método para crear nueva cuenta con numero de cuenta aleatorio
	public void crearCuenta (Moneda divisa) {

		Cuenta nuevaCuenta = new Cuenta((int) (Math.random()*100000), 5000d, divisa);
		
		cuentas.add(nuevaCuenta);
		
		System.out.println("Se ha creado una nueva cuenta del usuario " + this.nombre + ": ");
		System.out.println(cuentas.get(cuentas.size()-1).toString());
				
	}
	
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
