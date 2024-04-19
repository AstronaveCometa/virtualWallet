package billeteraDigital.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import billeteraDigital.Moneda;
import billeteraDigital.Usuario;

class UsuarioTest {

	Usuario usuario;
	
	@BeforeEach
	public void setUp () {
		usuario = new Usuario ("Valentina", "12.345.678-9","valentina@correo.com");
	}
	
	@Test
	public void testCrearCuentaSaldo() {
		Moneda dolar = new Moneda ("Dolar", 1, '$');
		
		usuario.crearCuenta(dolar);
		assertEquals(5000d,usuario.getCuentas().get(0).getSaldo());
	}
	
	@Test
	public void testCrearCuentaDivisa() {
		Moneda dolar = new Moneda ("Dolar", 1, '$');
		
		usuario.crearCuenta(dolar);
		assertEquals(dolar,usuario.getCuentas().get(0).getDivisa());
	}


}
