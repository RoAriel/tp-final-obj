package estadoPrestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EstadoPrestamo;
import estadoPrestamos.Finalizado;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;

public class TestEnCurso {
	private EnCurso enCurso;
	private Prestamo mockedPrestamo;
	
	@Before
	public void setUp() throws Exception {
		enCurso= new EnCurso();
		mockedPrestamo= mock(Prestamo.class);
	}
	
	@Test(expected= DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException {
	
	when(mockedPrestamo.getEstado()).thenReturn(enCurso);
	
	mockedPrestamo.getEstado().aDeudorIncobrable(mockedPrestamo);
	
	assertSame(enCurso, mockedPrestamo.getEstado());
	}


	@Test(expected= AprobadoException.class)
	public void testAprobar() throws AprobadoException {
		
		when(mockedPrestamo.getEstado()).thenReturn(enCurso);
		mockedPrestamo.getEstado().aprobar(mockedPrestamo);
		
		assertSame(enCurso, mockedPrestamo.getEstado());
	}  

	@Test(expected= RechazadoException.class)
	public void testRechazar() throws RechazadoException {
		
		when(mockedPrestamo.getEstado()).thenReturn(enCurso);
		mockedPrestamo.getEstado().rechazar(mockedPrestamo);
	}
	
	@Test
	public void testFinalizar() throws FinalizadoException{
		
		when(mockedPrestamo.getEstado()).thenReturn(enCurso);
		
		mockedPrestamo.getEstado().finalizar(mockedPrestamo);
			
		assertSame(new Finalizado(), (Finalizado)mockedPrestamo.getEstado());}
}