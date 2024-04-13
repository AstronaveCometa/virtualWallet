/** Clase MAIN
* @author Sebastián León
* @version 1.0
*
**/

package billeteraDigital;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner teclado = new Scanner(System.in);
	
	/** 
	* Método para escoger entre elegir o crear usuario y cuenta, devuelve 1 para "Elegir" y 2 para "Crear"
	* @param elemento - String con "usuario" o "cuenta" para desplegarlo en la pregunta
	* @return entero 1 o 2, que representa elegir o crear respectivamente 
	**/
	public static int elegirOCrear(String elemento) {
		int eleccion;
		do {
		System.out.println("¿Elegir o crear " + elemento + "?");
		System.out.println("1) Elegir\n"
						+ "2) Crear");
		eleccion = teclado.nextInt();
		if (eleccion > 2 || eleccion < 1) {
			System.out.println("Elección no válida");
		} else {
			
		}
		} while (eleccion > 2 || eleccion < 1);
		return eleccion;
	}
	
	/** 
	* Método para elegir usuario, devuelve el índice del usuario elegido por consola de entre un ArrayList de usuarios
	* @param ArrayList de objetos Usuario - lista de los usuarios del proyecto
	* @return entero con el índice del usuario elegido de entre los del ArrayList
	**/
	public static int elegirUsuario(ArrayList<Usuario> usuarios) {
		int i = 0;
		int eleccion;
		do {
		System.out.println("Seleccione usuario:\n");
		for (Usuario usuario : usuarios) {
			System.out.println("Usuario " + i);
			System.out.println(usuario.toString());
			i++;
		}
		
		System.out.print("\nUsuario: ");
		eleccion = teclado.nextInt();
		
		//validación de elección
		if (eleccion > usuarios.size() || eleccion < 0) {
			System.out.println("Usuario no válido");
		} else {
		}
		i = 0;
		} while (eleccion > usuarios.size() || eleccion < 0);
		return eleccion;
		
	}
	
	/** 
	* Método para elegir cuenta, devuelve el índice de la cuenta elegida por consola de entre un ArrayList de cuentas
	* @param ArrayList de objetos cuenta - lista de las cuentas de un usuario
	* @return entero con el índice de la cuenta elegida en consola
	**/
	public static int elegirCuenta(ArrayList<Cuenta> cuentas) {
		int i = 0;
		int eleccion;
		do {
		System.out.println("Seleccione la cuenta del usuario:\n");
		for (Cuenta cuenta : cuentas) {
			System.out.println("Cuenta " + i);
			System.out.println(cuenta.toString());
			i++;
		}
		
		System.out.print("\nCuenta: ");
		eleccion = teclado.nextInt();
		
		//validación de elección
		if (eleccion > cuentas.size() || eleccion < 0) {
			System.out.println("Cuenta no válida.");
		} else {
		}
		i = 0;
		} while (eleccion > cuentas.size() || eleccion < 0);
		return eleccion;
	}
	
	public static void crearDivisa (Divisas divisas) {
			System.out.println("Divisas disponibles: ");
			divisas.mostrarDivisas();
			divisas.agregarDivisa();
	}
	
	/** 
	* Método para elegir operación, devuelve el número de la alternativa elegida por consola
	* @return entero con la alternativa elegida en consola
	**/
	public static int alternativa() {
		int eleccion;
		System.out.println("Elija la operación que desea realizar:\n"
				+ "1) Consultar saldo"
				+ "2) Depósito\n"
				+ "3) Giro\n"
				+ "4) Transferencia\n"
				+ "5) Cambiar de divisa\n"
				+ "6) Cambio de cuenta\n"
				+ "7) Cambio de usuario\n"
				+ "8) Crear nueva divisa\n"
				+ "9) Salir\n");
		eleccion = teclado.nextInt();
		if (eleccion > 9 || eleccion < 1) {
			System.out.println("Operación no válida.");
		} else {
		}
		return eleccion;
	}
	
	
	
	// Método ejecutor
	public static void main(String[] args) {
		
		Divisas divisasMain = new Divisas(); //instanciación de objeto que contiene las divisas, por defecto tiene dolar, euro y peso chileno
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); //creación de arraylist de usuarios
		int usuarioEnUso = 0; //variable para determinar cuál es el usuario en uso
		int cuentaEnUso = 0; //variable para determinar cuál es la cuenta en uso
		int opcionSeleccionada; //variable para recibir la opción seleccionada cuando se llame a alternativas()
		int divisaSeleccionada; //variable para recibir la divisa elegida por consola para crear una nueva divisa
		Double transferencia; //Double para recibir monto de transferencia
		int usuarioTransferencia; //variable para recibir el índice del usuario elegido para recibir una transferencia
		int cuentaTransferencia; //variable para recibir el índice de la cuenta elegida para recibir una transferencia
		
		boolean continuarUsuario = true; //boolean para determinar si se continúa usando el mismo usuario en el do while correspondiente
		boolean continuarCuenta = true; //boolean para determinar si se continúa usando la misma cuenta en el do while correspondiente
		boolean repetir = true; //boolean para determinar si se continúa operando en consola en el do while correspondiente
		
		//creación usuarios por defecto, con una cuenta de divisa de peso chileno, valentina y joaquín, se añaden al arraylist de usuarios
		Usuario nuevo1 = new Usuario("Valentina", "17175378-0", "valentina.delahoz@gmail.com"); 
		Usuario nuevo2 = new Usuario("Joaquín", "16711874-K", "juacocardenas7@gmail.com");
		nuevo1.crearCuenta(divisasMain.divisas.get(2));
		nuevo2.crearCuenta(divisasMain.divisas.get(2));
		usuarios.add(nuevo1);
		usuarios.add(nuevo2);

		
		//inicio de operaciones
		do {
			do { 
			opcionSeleccionada = elegirOCrear("usuario");
			switch (opcionSeleccionada) {
				case 1:
					continuarUsuario = true;
					usuarioEnUso = elegirUsuario(usuarios);
					System.out.println("Ha seleccionado el usuario " + usuarios.get(usuarioEnUso).getNombre() + "\n");
					break;
				case 2:
					System.out.println("Escriba el nombre del nuevo usuario:");
					nuevo1.setNombre(teclado.next());
					System.out.println("Escriba el rut del nuevo usuario:");
					nuevo1.setRut(teclado.next());
					System.out.println("Escriba el email del nuevo usuario:");
					nuevo1.setEmail(teclado.next());
					usuarios.add(nuevo1);
					System.out.println("Usuario creado exitosamente.");
					break;
			} while (opcionSeleccionada == 2);
				
			do { 
			opcionSeleccionada = elegirOCrear("cuenta");
			switch (opcionSeleccionada) {
				case 1:
					continuarCuenta = true;
					cuentaEnUso = elegirCuenta(usuarios.get(usuarioEnUso).getCuentas());
					System.out.println("Ha seleccionado la cuenta " + usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).getNumeroCuenta() + "\n");
					break;
				case 2:
					System.out.println("Seleccione la divisa de la cuenta: ");
					divisasMain.mostrarDivisas();
					divisaSeleccionada = teclado.nextInt();
					usuarios.get(usuarioEnUso).crearCuenta(divisasMain.divisas.get(divisaSeleccionada));
					break;
			}
			} while (opcionSeleccionada == 2);
		
		
		
			do {
					//selección de operación con método alternativa()
					opcionSeleccionada = alternativa();
					switch(opcionSeleccionada) { //switch con la alternativa elegida por consola
						case 1:
							System.out.print("El saldo de la cuenta " + usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).getNumeroCuenta() + " es: " + usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).getDivisa().getSigno() + usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).getSaldo());
							break;
						case 2:
							System.out.print("Ingrese el monto del depósito: ");
						    usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).realizarDeposito(teclado.nextDouble());
						    System.out.println("¿Desea realizar otra operación?\n"
						    		+ "Sí: 1  No: 2");
						    opcionSeleccionada = teclado.nextInt();
						    if(opcionSeleccionada == 1) {
						    	break;
						    } else {
						    	continuarCuenta = false;
						    	continuarUsuario = false;
						    	repetir = false;
						    	break;
						    }
						case 3:
							System.out.print("Ingrese el monto del giro: ");
						    usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).realizarGiro(teclado.nextDouble());
						    System.out.println("¿Desea realizar otra operación?\n"
						    		+ "Sí: 1  No: 2");
						    opcionSeleccionada = teclado.nextInt();
						    if(opcionSeleccionada == 1) {
						    	break;
						    } else {
						    	continuarCuenta = false;
						    	continuarUsuario = false;
						    	repetir = false;
						    	break;
						    }
						case 4:
							System.out.print("Ingrese el monto de la transferencia: ");
							transferencia = teclado.nextDouble();
							System.out.println("Seleccione el usuario a transferir");
							usuarioTransferencia = elegirUsuario(usuarios);
							System.out.println("Seleccione el usuario a transferir");
							cuentaTransferencia = elegirCuenta(usuarios.get(usuarioTransferencia).getCuentas());
							usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).realizarTransferencia(usuarios.get(usuarioTransferencia).getCuentas().get(cuentaTransferencia), transferencia);
						    
						    System.out.println("¿Desea realizar otra operación?\n"
						    		+ "Sí: 1  No: 2");
						    opcionSeleccionada = teclado.nextInt();
						    if(opcionSeleccionada == 1) {
						    	break;
						    } else {
						    	continuarCuenta = false;
						    	continuarUsuario = false;
						    	repetir = false;
						    	break;
						    }
						case 5:
							System.out.println("Seleccione la nueva divisa de la cuenta: ");
							divisasMain.mostrarDivisas();
							divisaSeleccionada = teclado.nextInt();
							//se divide el saldo de la cuenta por el proporcional con los dólares para obtener la cantidad de dólares
							usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).setSaldo(usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).getSaldo()/usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).getDivisa().getProporcionDolar());
							//se cambia la moneda de la cuenta
							usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).setDivisa(divisasMain.divisas.get(divisaSeleccionada));
							//se multiplica el saldo (ahora en cantidad de dólares) por el proporcional con dólares para obtener el saldo en la nueva divisa
							usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).setSaldo(usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).getSaldo()*usuarios.get(usuarioEnUso).getCuentas().get(cuentaEnUso).getDivisa().getProporcionDolar());
							//en caso de que la moneda originalmente sea dólares, en la división quedará inalterado
							//en caso de que la moneda termine en dólares, la multiplicación quedará sin efecto
							//en caso de que vaya de dólares a dólares, todo el proceso no alterará el saldo
							break;
						case 6:
						    continuarCuenta = false;
						    break;
						case 7:
							continuarCuenta = false;
							continuarUsuario = false;
							break;
						case 8:	
							crearDivisa(divisasMain);
							break;
						case 9:
							continuarCuenta = false;
					    	continuarUsuario = false;
					    	repetir = false;
					    	break;
					    default:
					    	break;
					}
					
				} while (continuarCuenta);
				
			} while (continuarUsuario);
		
		} while (repetir);
		System.out.println("Hasta la próxima.");
	}
			
}

		