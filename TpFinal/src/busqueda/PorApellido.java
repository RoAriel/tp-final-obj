package busqueda;

import prestamos.Prestamo;

/**
 * se fija que el apellido del cliente del prestamo contenga el string de la variable privada.
 * 
 * @author juan
 *
 */

public class PorApellido extends Condicion {

	private String apellido;
	
	private String getApellido() {
		return apellido;
	}

	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public PorApellido(String apellido){
		this.setApellido(apellido);
		
	}

	@Override
	/**
	 * respetaCondicion se fija que el apellido del cliente del prestamo contenga el string de la 
	 * variable privada. 
	 * 
	 * @return boolean 
	 */
	public boolean respetaCondicion(Prestamo p){
		String aux = p.obtenerApellidoCliente().toLowerCase();
		return (aux.contains(this.getApellido().toLowerCase()));
	}
	
	
}
