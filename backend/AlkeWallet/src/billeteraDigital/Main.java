package billeteraDigital;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Divisas divisasMain = new Divisas(); //instanciación de objeto que contiene las divisas, por defecto tiene dolar, euro y peso chileno
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); //creación de arraylist de usuarios
		int i = 0; //contador multiuso
		int usuarioEnUso;
		boolean repetir = true;
		
		//usuarios por defecto, con una cuenta de divisa de peso chileno, valentina y joaquín, se añaden al arraylist de usuarios
		Usuario nuevo1 = new Usuario("Valentina", "17175378-0", "valentina.delahoz@gmail.com"); 
		Usuario nuevo2 = new Usuario("Joaquín", "16711874-K", "juacocardenas7@gmail.com");
		nuevo1.crearCuenta(divisasMain.divisas.get(2));
		nuevo2.crearCuenta(divisasMain.divisas.get(2));
		usuarios.add(nuevo1);
		usuarios.add(nuevo2);
		
		do {
		System.out.println("Seleccione usuario:\n");
		for (Usuario usuario : usuarios) {
			System.out.println("Usuario " + i);
			System.out.println(usuario.toString());
			i++;
		}
		
		System.out.print("\nUsuario: ");
		usuarioEnUso = teclado.nextInt();
		System.out.println("Ha seleccionado el usuario " + usuarios.get(usuarioEnUso).getNombre() + "\n");
		System.out.println();
		
		

		} while (repetir);
	}

}
