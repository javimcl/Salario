package com.ejercicio.salario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b> Clase principal para obtener el valor total ganado por el empleador. </b>
 * 
 * @author jlucero
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: jlucero $, $Date: 9/4/2019 $]
 *          </p>
 */
public class Principal {

	public static void main(String[] args) {
		Map<String, List<Horario>> horarioSemana = new HashMap<>();
		horarioSemana = ServicioHorario.llenarHorario();
		List<String> empleados = ServicioHorario.leerArchivo();
		for (String empleado : empleados) {
			Double total = 0.0;
			if (ServicioHorario.validarFormato(empleado)) {
				List<String> campos = ServicioHorario.separarCadena(empleado);
				for (int i = 1; i < campos.size(); i++) {
					total += ServicioHorario.obtenerTotalPagar(horarioSemana, campos.get(i));
				}
				System.out.println("El monto a pagar " + campos.get(0) + " is: " + total + " USD");
			}
		}
	}

}
