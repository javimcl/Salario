package com.ejercicio.salario;

/*
 * Copyright 2019 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */

/**
 * 
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author jlucero
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: jlucero $, $Date: 29/11/2019 $]
 *          </p>
 */
public enum Semana {

	MONDAY("MO"), TUESDAY("TU"), WEDNESDAY("WE"), THURDAY("TH"), FRIDAY("FR"), SATURDAY("SA"), SUNDAY("SU");

	private String codigo;

	/**
	 * @param codigo
	 */
	private Semana(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

}
