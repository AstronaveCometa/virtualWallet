package billeteraDigital.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.configuration.injection.scanner.MockScanner;

import billeteraDigital.Divisas;

class DivisasTest {

	Divisas divisasPrueba;
	
	
	@BeforeEach
	public void setUp() {
		divisasPrueba = new Divisas();
	}
	
	@Test
	public void testConstructorNombre() {
		assertEquals("peso chileno", divisasPrueba.getMonedas(2).getNombre());
	}
	
	@Test
	public void testConstructorProporcionConDolar() {
		assertEquals(952.76f, divisasPrueba.getMonedas(2).getProporcionDolar());
	}
	
	@Test
	public void testConstructorSigno() {
		assertEquals('$', divisasPrueba.getMonedas(2).getSigno());
	}
	
	@Test
	public void testAgregarDivisaNombre() {
		divisasPrueba.agregarDivisa("Yuan", 0.14f, '¥');
		assertEquals("Yuan",divisasPrueba.getMonedas(3).getNombre());
	}
	
	@Test
	public void testAgregarDivisaProporcionDolar() {
		divisasPrueba.agregarDivisa("Yuan", 0.14f, '¥');
		assertEquals(0.14f,divisasPrueba.getMonedas(3).getProporcionDolar());
	}
	
	@Test
	public void testAgregarDivisaSigno() {
		divisasPrueba.agregarDivisa("Yuan", 0.14f, '¥');
		assertEquals('¥',divisasPrueba.getMonedas(3).getSigno());
	}

}
