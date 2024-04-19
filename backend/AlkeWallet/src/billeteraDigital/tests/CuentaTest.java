package billeteraDigital.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import billeteraDigital.Cuenta;
import billeteraDigital.Moneda;

class CuentaTest {
	
	Moneda dolar;
	Cuenta cuenta;
	Cuenta cuenta2;
	
	@BeforeEach
	public void setUp (){
	dolar = new Moneda ("Dolar", 1, '$');
	cuenta = new Cuenta (1001, 10000d, dolar);
	cuenta2 = new Cuenta (1002, 10000d, dolar);
	}
	
	@Test
	public void testRealizarGiro() {
		cuenta.realizarGiro(2000d);
		assertEquals(8000d, cuenta.getSaldo(), 0.0);
	}
	
	@Test
	public void testRealizarDeposito() {
		cuenta.realizarDeposito(2000d);
		assertEquals(12000d, cuenta.getSaldo(), 0.0);
	}
	
	@Test
	public void testRealizarTransferenciaEmisor() {
		cuenta.realizarTransferencia(cuenta2, 2000d);
		assertEquals(8000d, cuenta.getSaldo(), 0.0);
	}
	
	@Test
	public void testRealizarTransferenciaReceptor() {
		cuenta.realizarTransferencia(cuenta2, 2000d);
		assertEquals(12000d, cuenta2.getSaldo(), 0.0);
	}

}
