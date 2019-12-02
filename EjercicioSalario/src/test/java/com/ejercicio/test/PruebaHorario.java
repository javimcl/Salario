/*
 * Copyright 2019 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package com.ejercicio.test;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import com.ejercicio.salario.Horario;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author jlucero
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: jlucero $, $Date: 29/11/2019 $]
 *          </p>
 */
public class PruebaHorario {

	@Test
	public void verificarHoraInicioMayorIgual() {
		LocalTime hora = LocalTime.of(00, 01);
		Horario horario = new Horario(LocalTime.of(00, 01), LocalTime.of(9, 00), 25.00);
		assert (horario.getHoraInicio().compareTo(hora) >= 0);
	}

	@Test
	public void verificarHoraInicioMenor() {
		LocalTime hora = LocalTime.of(00, 02);
		Horario horario = new Horario(LocalTime.of(00, 01), LocalTime.of(9, 00), 25.00);
		assert (horario.getHoraInicio().compareTo(hora) < 0);
	}

	@Test
	public void verificarHoraEntreInicioFin() {
		LocalTime hora = LocalTime.of(8, 02);
		Horario horario = new Horario(LocalTime.of(00, 01), LocalTime.of(9, 00), 25.00);
		assert (horario.getHoraInicio().compareTo(hora) <= 0 && horario.getHoraFin().compareTo(hora) >= 0);
	}

	@Test
	public void verificarHoraFueraInicio() {
		LocalTime hora = LocalTime.of(10, 00);
		Horario horario = new Horario(LocalTime.of(00, 01), LocalTime.of(9, 00), 25.00);
		assert (horario.getHoraInicio().compareTo(hora) > 0 || horario.getHoraFin().compareTo(hora) < 0);
	}

}
