package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {
	
	private Empleado emp = new Empleado();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");
	}
	
	@Test
	void testCalculoNominaBrutaTipoEmpleado() {
		//No se bien como comprobar este, me parece extraño tener que comprobarlo.
		
		enum expectedTipos{Encargado, Vendedor}

		TipoEmpleado encarg = TipoEmpleado.Encargado;
		TipoEmpleado vend = TipoEmpleado.Vendedor;
		
		assertEquals(encarg.name(), expectedTipos.Encargado.name());
		assertEquals(vend.name(), expectedTipos.Vendedor.name());
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioBaseVendedor() {
		
		float expected = 2000;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Vendedor, 0, 0);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioBaseEncargado() {
		
		float expected = 2500;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Encargado, 0, 0);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioVendedorVentasMas1500() {
		
		float expected = 2200;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Vendedor, 1600, 0);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioVendedorVentasMas1000() {
		
		float expected = 2100;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Vendedor, 1200, 0);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioVendedorVentasMenos1000() {
		
		float expected = 2000;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Vendedor, 600, 0);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioEncargadoVentasMas1500() {
		
		float expected = 2700;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Encargado, 1600, 0);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioEncargadoVentasMas1000() {
		
		float expected = 2600;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Encargado, 1200, 0);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioEncargadoVentasMenos1000() {
		
		float expected = 2500;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Encargado, 600, 0);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioVendedor2HorasExtras() {
		
		float expected = 2060;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Vendedor, 0, 2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMas_SalarioEncargado2HorasExtras() {
		
		float expected = 2560;
		float actual = emp.CalculoNominaBruta(TipoEmpleado.Encargado, 0, 2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNeta_RetencionMas2500() {
		
		float expected = 2600*(1-0.18f);
		float actual = emp.calculoNominaNeta(2600);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNeta_RetencionMas2100() {
		
		float expected = 2300*(1-0.15f);
		float actual = emp.calculoNominaNeta(2300);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNeta_RetencionMenos2100() {
		
		float expected = 1700;
		float actual = emp.calculoNominaNeta(1700);
		
		assertEquals(expected, actual);
	}

}
