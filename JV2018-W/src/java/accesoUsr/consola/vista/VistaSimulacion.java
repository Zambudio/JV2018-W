/**
 * Proyecto: Juego de la vida.
 * Implementación de la clase VistaSimulacion.java para mostrar el aspecto
 * de un mundo para la simulacion.
 * Colabora en el patrón MVC.
 * @since: prototipo2.1
 * @source: VistaPrincipal.java 
 * @version: 2.1 - 2019/05/15
 * @author: Grupo2
 * @author: arm
 * @author: Fran Arce
 */

package accesoUsr.consola.vista;

import java.io.Console;
import java.util.Scanner;

import accesoUsr.OperacionesVista;
import accesoUsr.consola.control.ControlSimulacion;

public class VistaSimulacion implements OperacionesVista {

	private Console consola; //Atributo para teclado de consola.

	/**
	 * Constructor de la clase VistaSimulacion.
	 * Crea objeto para consola por teclado.
	 */
	
	public VistaSimulacion() {
		consola = System.console();
	}
	
	/**
	 * Metodo que muestra la forma de un mundo para la simulacion. 
	 * @param controlSimulacion
	 */

	public void mostrarSimulacion(ControlSimulacion controlSimulacion) {
		byte[][] espacio = controlSimulacion.getMundo().getEspacio();
		for(int i=0 ; i< espacio.length ; i++) {
			for(int j=0 ; j< espacio.length ; j++) {
				this.mostrarTextoSimple((espacio[i][j] == 1) ? "|o" : "| ");
			}
			this.mostrarMensaje("|");
		}

	}

	/**
	 * Metodo que muestra un simple texto para imprimir el tablero del mundo. 
	 * @param texto
	 */
	
	private void mostrarTextoSimple(String texto) {
		if(consola != null) {
			consola.writer().println(texto);
			return;
		}
		System.out.println(texto);
	}
	
	/**
	 * Metodo que muestra un texto como finalizacion de la simulacion.
	 */

	public void confirmar() {
		mostrarTextoSimple("Simulacion Completada.");
	}

	/**
	 * Metodo de la interfaz OperacionesVista que muestra un mensaje de texto.
	 */
	
	@Override
	public void mostrarMensaje(String mensaje) {
		if (consola != null) {
			consola.writer().println(mensaje);
			return;
		}
		System.out.println(mensaje);
	}

}//class