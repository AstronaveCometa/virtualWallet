package billeteraDigital;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner teclado = new Scanner(System.in);
	
	
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
	
	//método para elegir usuario
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
	
	//método para elegir cuenta
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
	
	//método para elegir operación
	public static int alternativa() {
		int eleccion;
		System.out.println("Elija la operación que desea realizar:\n"
				+ "1) Depósito\n"
				+ "2) Giro\n"
				+ "3) Transferencia\n"
				+ "4) Cambiar de divisa\n"
				+ "5) Cambio de cuenta\n"
				+ "6) Cambio de usuario\n"
				+ "7) Salir\n");
		eleccion = teclado.nextInt();
		if (eleccion > 6 || eleccion < 1) {
			System.out.println("Operación no válida.");
		} else {
		}
		return eleccion;
	}
	
	
	
	//método ejecutor

	public static void main(String[] args) {
		
		Divisas divisasMain = new Divisas(); //instanciación de objeto que contiene las divisas, por defecto tiene dolar, euro y peso chileno
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); //creación de arraylist de usuarios
		int usuarioEnUso = 0;
		int cuentaEnUso = 0;
		int opcionSeleccionada;
		int divisaSeleccionada;
		Double transferencia;
		int usuarioTransferencia;
		int cuentaTransferencia;
		
		boolean continuarUsuario = true;
		boolean continuarCuenta = true;
		boolean repetir = true;
		
		//usuarios por defecto, con una cuenta de divisa de peso chileno, valentina y joaquín, se añaden al arraylist de usuarios
		Usuario nuevo1 = new Usuario("Valentina", "17175378-0", "valentina.delahoz@gmail.com"); 
		Usuario nuevo2 = new Usuario("Joaquín", "16711874-K", "juacocardenas7@gmail.com");
		nuevo1.crearCuenta(divisasMain.divisas.get(2));
		nuevo2.crearCuenta(divisasMain.divisas.get(2));
		usuarios.add(nuevo1);
		usuarios.add(nuevo2);
		
		//opción para agregar nuevas divisas
		do {
			System.out.println("Divisas disponibles: ");
			divisasMain.mostrarDivisas();
			System.out.println("¿Agregar nuevas divisas?\n"
					+ "Sí: 1  No: 2");
			opcionSeleccionada = teclado.nextInt();
			if(opcionSeleccionada == 1) {
				divisasMain.agregarDivisa();
			} else if (opcionSeleccionada == 2){
				
			} else {
				System.out.println("Opción no válida.");
				opcionSeleccionada = 1;
			}
		} while (opcionSeleccionada == 1);
		
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
					//selección de operación
					opcionSeleccionada = alternativa();
					switch(opcionSeleccionada) {
						case 1:
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
						case 2:
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
						case 3:
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
						case 4:
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
						case 5:
						    continuarCuenta = false;
						    break;
						case 6:
							continuarCuenta = false;
							continuarUsuario = false;
							break;
						case 7:
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

		