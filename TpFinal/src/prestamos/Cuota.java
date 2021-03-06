package prestamos;

import java.util.GregorianCalendar;

import estadoCuotas.APagar;
import estadoCuotas.EstadoCuota;
import exceptions.EstadoCuotaException;


/**
  *  Modela una cuota con todos los datos que se encuentran en el cuadroDeMarcha. Esta tambien indica
  *  en que estado se encuentra.
  * 
  * @author juan
  *
  */

public class Cuota {
	
	private GregorianCalendar fechaVencimiento; 
	private double montoCuota;
	private Integer nroCuota; 
	private double interesPorMora; 
	private GregorianCalendar fechaDePago;
	private double amortizacion;
	private double interes;
	private double gastoTotal;
	private double saldoDeuda;
	private double seguro;
	private double valorTotalCuota;
	private EstadoCuota estadoCuota;
	
	
	public double getValorTotalCuota() {
		return valorTotalCuota;
	}
	public void setValorTotalCuota(double valorTotalCuota) {
		this.valorTotalCuota = valorTotalCuota;
	}
	public double getSeguro() {
		return seguro;
	}
	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}
	public GregorianCalendar getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(GregorianCalendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public double getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}
	public Integer getNroCuota() {
		return nroCuota;
	}
	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}
	public double getInteresPorMora() {
		return interesPorMora;
	}
	public void setInteresPorMora(double interesPorMora) {
		this.interesPorMora = interesPorMora;
	}
	public GregorianCalendar getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(GregorianCalendar fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	public double getAmortizacion() {
		return amortizacion;
	}
	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public double getGastoTotal() {
		return gastoTotal;
	}
	public void setGastoTotal(double gastoTotal) {
		this.gastoTotal = gastoTotal;
	}
	public double getSaldoDeuda() {
		return saldoDeuda;
	}
	public void setSaldoDeuda(double saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}
	public EstadoCuota getEstadoCuota() {
		return estadoCuota;
	}
	public void setEstadoCuota(EstadoCuota estadoCuota) {
		this.estadoCuota = estadoCuota;
	}
	
	/**
	 * Usar solo cuando se consulta el valor cuota.
	 */
	public Cuota(){
		super();
	}
	
	/**
	 * Orden de los parametros:
	 * @param fechaVencimiento
	 * @param monto
	 * @param nroCuota
	 * @param amortizacion
	 * @param interes
	 * @param saldoDeuda
	 */
	public Cuota(GregorianCalendar fechaVencimiento, double monto, Integer nroCuota, double amortizacion, double interes,double saldoDeuda){
		this.setAmortizacion(amortizacion);
		this.setFechaVencimiento(fechaVencimiento);
		this.setInteres(interes);
		this.setMontoCuota(monto);
		this.setSaldoDeuda(saldoDeuda);
		this.setNroCuota(nroCuota);
		this.setEstadoCuota(new APagar());
		this.setFechaDePago(null);
		this.setValorTotalCuota(0);
		this.setSeguro(0);
		this.setInteresPorMora(0);
	}

	
	/**
	 * EstaPaga realiza una inspeccion del estado
	 * 
	 * @return un bool que chequea el estado
	 */
	public boolean estaPaga(){
		return this.getEstadoCuota().estaPaga();
	}
	
	/**
	 * @param fechaPago
	 * Pagar recibe la fecha en la que se efectua el pago
	 * @throws EstadoCuotaException 
	 */
	public void pagar(GregorianCalendar fechaPago) throws EstadoCuotaException{
		this.getEstadoCuota().pagar(this);
		this.setFechaDePago(fechaPago);
	}
	
	
	/**
	 * cambia el estado a vencido.
	 * @throws EstadoCuotaException 
	 * 
	 */
	public void aVencido() throws EstadoCuotaException{
		this.getEstadoCuota().aVencido(this);
	}
	
	/**
	 * @param fechaActual 
	 * chequea si la fecha de vencimiento es menor que la pasada por parametro
	 * si es asi la pasa a vencida.
	 * @throws EstadoCuotaException 
	 * 
	 */
	public void verificarFecha(GregorianCalendar fechaActual) throws EstadoCuotaException{
		if(this.getFechaVencimiento().before(fechaActual)){
			this.aVencido();
		}
	}
	
	public void actualizarGastoTotal(double montoActuralizado){
		this.setGastoTotal(montoActuralizado);
	}
	
	public String mostrarFecha(GregorianCalendar fecha){
		if(fecha == null){
			return "0/0/0";
		}
		String ret = "";
		ret = ret + fecha.get(1);
		ret = ret + "/" + (fecha.get(2) + 1);
		ret = ret + "/" + fecha.get(5);
		return ret;
	} 
	
	
}
