package gastos;

import prestamos.Cuota;
import prestamos.Prestamo;

public class GastoMensual extends Gasto {

	public GastoMensual(float monto, TipoDeGasto tipoDeGasto){
		this.setTipoDeGasto(tipoDeGasto);
	
	}

	@Override
	public void calcularGasto(Prestamo prestamo) {
		for(Cuota c : prestamo.getCuotas()){
			c.setGastoTotal(c.getGastoTotal() + this.getTipoDeGasto().calcularGasto(c.getMontoCuota()));
			
		}
		
	}
	
	

}