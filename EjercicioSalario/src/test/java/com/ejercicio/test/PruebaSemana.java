/*
 * Copyright 2019 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package com.ejercicio.test;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

import com.ejercicio.salario.Semana;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author jlucero
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: jlucero $, $Date: 29/11/2019 $]
 *          </p>
 */
public class PruebaSemana {

	@Test
	public void obtenerLunes() {
		assert (Semana.MONDAY == Semana.valueOf(Semana.MONDAY.getCodigo()));
	}

	@Test
	public void obtenerSemana() {
		assert (Arrays.asList(Semana.values()).stream().distinct().count() == 7);
	}

	// @Test
	public void obtenerCodigoViernes() {
		assert (Semana.FRIDAY.getCodigo().equals(Semana.valueOf(Semana.FRIDAY.getCodigo()).getCodigo()));
	}

	@Test
	public void existeCodigo() {
		assert (Stream.of(Semana.values()).filter(d -> d.getCodigo().equals("MO")).findAny().isPresent());
	}

}
