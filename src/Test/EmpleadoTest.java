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
	
	//CalculoNomina Bruta hacer 7 u 8
	
	@Test
	void testCalculoNominaBrutaTipoEmpleado() {
		String t1="Vendedor";
		String t2="Encargado";
		
		
		emp.CalculoNominaBruta(null, 0, 0);
		
		assertEquals(t1, null);
	}

	@Test
	void testCalculoNominaNeta() {
		fail("Not yet implemented");
	}

}
