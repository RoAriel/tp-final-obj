package tipoDeImpresion;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Cuota;
import prestamos.Prestamo;

public class TestPorXML {

	private PorXML porXML;

	@Mock
	Cuota mockedCuota = mock(Cuota.class);
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		porXML = new PorXML();
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(porXML);
	}

	@Test
	public void testGenerarCabecera(){
		String nuevalinea = System.getProperty("line.separator");
		String texto = "<cuadroMarcha>";
		texto = texto + nuevalinea;	
		
		assertEquals(texto, porXML.generarCabecera());	
	}
	
	@Test
	public void testGenerarFinCabecera(){
		String nuevalinea = System.getProperty("line.separator");
		String texto ="";
		texto = texto+nuevalinea+"</cuadroMarcha>";
		
		assertEquals(texto, porXML.generarFinCabecera());
	}
	
	@Test
	public void testGenerarCuerpo(){
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"    ";
		String texto = "";
		texto = texto + nuevalinea2+"<cuota>";
		
		assertEquals(texto, porXML.generarCuerpo());
	}
	
	@Test 
	public void testGenerarFinCuerpo(){
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"    ";
		String texto = "";
		texto = texto + nuevalinea2 + "</cuota>" + nuevalinea;
		
		assertEquals(texto, porXML.generarFinCuerpo());		
	}
	
	@Test
	public void testGenerarCuota(){
		when(mockedCuota.getNroCuota()).thenReturn(0);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<numero>";
		texto = texto + 0;
		texto = texto + "</numero>";
		
		assertEquals(texto, porXML.generarCuota(mockedCuota));
		verify(mockedCuota).getNroCuota();
	}
	
	@Test
	public void testGenerarVencimiento(){
		when(mockedCuota.mostrarFecha(mockedCuota.getFechaVencimiento())).thenReturn("fecha");
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<vencimiento>";
		texto = texto + "fecha";
		texto = texto + "</vencimiento>";
		
		assertEquals(texto, porXML.generarVencimiento(mockedCuota));
		verify(mockedCuota).mostrarFecha((GregorianCalendar) any());
	}
	
	@Test
	public void testGenerarAmortizacion(){
		when(mockedCuota.getAmortizacion()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<amortizacion>";
		texto = texto + 1.00;
		texto = texto + "</amortizacion>";
		
		assertEquals(texto, porXML.generarAmortizacion(mockedCuota));
		verify(mockedCuota).getAmortizacion();
	}
	
	@Test
	public void testGenerarInteres(){
		when(mockedCuota.getInteres()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<interes>";
		texto = texto + 1.00;
		texto = texto + "</interes>";
		
		assertEquals(texto, porXML.generarInteres(mockedCuota));
		verify(mockedCuota).getInteres();		
	}
	
	@Test
	public void testGenerarSaldoDeuda(){
		when(mockedCuota.getSaldoDeuda()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<saldodeuda>";
		texto = texto + 1.00;
		texto = texto + "</saldodeuda>";
		
		assertEquals(texto, porXML.generarSaldoDeuda(mockedCuota));
		verify(mockedCuota).getSaldoDeuda();	
	}
	
	@Test
	public void testGenerarSeguro(){
		when(mockedCuota.getSeguro()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<seguro>";
		texto = texto + 1.00;
		texto = texto + "</seguro>";
		
		assertEquals(texto, porXML.generarSeguro(mockedCuota));
		verify(mockedCuota).getSeguro();	
	}
	
	@Test
	public void testGenerarGastos(){
		when(mockedCuota.getGastoTotal()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<gastos>";
		texto = texto + 1.00;
		texto = texto + "</gastos>";
		
		assertEquals(texto, porXML.generarGastos(mockedCuota));
		verify(mockedCuota).getGastoTotal();	
	}
	
	@Test
	public void testGenerarValorCuota(){
		when(mockedCuota.getMontoCuota()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<valorcuota>";
		texto = texto + 1.00;
		texto = texto + "</valorcuota>";
		
		assertEquals(texto, porXML.generarValorCuota(mockedCuota));
		verify(mockedCuota).getMontoCuota();	
	}
	
	@Test
	public void testGenerarValorTotalCuota(){
		when(mockedCuota.getValorTotalCuota()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<valortotalcuota>";
		texto = texto + 1.00;
		texto = texto + "</valortotalcuota>";
		
		assertEquals(texto, porXML.generarValorTotalCuota(mockedCuota));
		verify(mockedCuota).getValorTotalCuota();	
	}
	
	@Test
	public void testGenerarFechaPago(){
		when(mockedCuota.mostrarFecha(mockedCuota.getFechaDePago())).thenReturn("fecha");
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<fechadepago>";
		texto = texto + "fecha";
		texto = texto + "</fechadepago>";
		
		assertEquals(texto, porXML.generarFechaPago(mockedCuota));
		verify(mockedCuota).mostrarFecha((GregorianCalendar) any());	
	}
	
	@Test
	public void testGenerarInteresPorMora(){
		when(mockedCuota.getInteresPorMora()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<interesmora>";
		texto = texto + 1.00;
		texto = texto + "</interesmora>";
		
		assertEquals(texto, porXML.generarInteresPorMora(mockedCuota));
		verify(mockedCuota).getInteresPorMora();	
	}
	
	@Test
	public void testNombreArchivo(){
		assertEquals("Prestamo.xml", porXML.nombreArchivo());
	}

	@Test
	public void testImrimir(){
		String texto = "";
		texto = texto + porXML.generarCabecera();
		texto = texto + this.generarTextoParaTestGenerarCuerpo();
		texto = texto + porXML.generarFinCabecera();
		
		assertEquals(texto, porXML.imprimir(mockedPrestamo));
	}
	
	public String generarTextoParaTestGenerarCuerpo(){
		List<Cuota> cuotas = new Vector<Cuota>();
		cuotas.add(mockedCuota);
		when(mockedPrestamo.getCuotas()).thenReturn(cuotas);
		String texto = "";
		texto = texto + porXML.generarCuerpo();
		texto = texto + this.generarTextoParaTestGenerarInfo();
		texto = texto + porXML.generarFinCuerpo();
		return texto;
	}
	
	@Test
	public void testGenerarCurpo(){
		
		String texto = this.generarTextoParaTestGenerarCuerpo();
		assertEquals(texto, porXML.generarCuerpo(mockedPrestamo));
	}
	
	public String generarTextoParaTestGenerarInfo(){
		when(mockedCuota.getNroCuota()).thenReturn(1);
		when(mockedCuota.mostrarFecha(mockedCuota.getFechaVencimiento())).thenReturn("fecha");
		when(mockedCuota.getAmortizacion()).thenReturn((double) 1);
		when(mockedCuota.getInteres()).thenReturn((double) 1);
		when(mockedCuota.getSaldoDeuda()).thenReturn((double) 1);
		when(mockedCuota.getSeguro()).thenReturn((double) 1);
		when(mockedCuota.getGastoTotal()).thenReturn((double) 1);
		when(mockedCuota.getMontoCuota()).thenReturn((double) 1);
		when(mockedCuota.getValorTotalCuota()).thenReturn((double) 1);
		when(mockedCuota.mostrarFecha(mockedCuota.getFechaDePago())).thenReturn("fecha");
		when(mockedCuota.getInteresPorMora()).thenReturn((double) 1);
		
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = "";

		texto = texto+nuevalinea2+"<numero>";
		texto = texto + 1;
		texto = texto + "</numero>";
		texto = texto + nuevalinea2+"<vencimiento>";
		texto = texto + "fecha";
		texto = texto + "</vencimiento>";
		texto = texto+nuevalinea2+"<amortizacion>";
		texto = texto + 1.00;
		texto = texto + "</amortizacion>";
		texto = texto+nuevalinea2+"<interes>";
		texto = texto + 1.00;
		texto = texto + "</interes>";
		texto = texto+nuevalinea2+"<saldodeuda>";
		texto = texto + 1.00;
		texto = texto + "</saldodeuda>";
		texto = texto+nuevalinea2+"<seguro>";
		texto = texto + 1.00;
		texto = texto + "</seguro>";
		texto = texto+nuevalinea2+"<gastos>";
		texto = texto + 1.00;
		texto = texto + "</gastos>";
		texto = texto+nuevalinea2+"<valorcuota>";
		texto = texto + 1.00;
		texto = texto + "</valorcuota>";
		texto = texto + nuevalinea2+"<valortotalcuota>";
		texto = texto + 1.00;
		texto = texto + "</valortotalcuota>";
		texto = texto + nuevalinea2+"<fechadepago>";
		texto = texto + "fecha";
		texto = texto + "</fechadepago>";
		texto = texto+nuevalinea2+"<interesmora>";
		texto = texto + 1.00;
		texto = texto + "</interesmora>";	
		return texto;
	}
	
	@Test
	public void testGenerarInfo(){
		String s = this.generarTextoParaTestGenerarInfo();
		assertEquals(s, porXML.generarInfo(mockedCuota));
		
	}
	
}
