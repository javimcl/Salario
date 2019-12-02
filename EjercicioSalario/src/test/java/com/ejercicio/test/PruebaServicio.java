package com.ejercicio.test;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ejercicio.salario.Horario;
import com.ejercicio.salario.Semana;
import com.ejercicio.salario.ServicioHorario;

/**
 * <b> Clase para realizar las pruebas de todos los servicios. </b>
 * 
 * @author jlucero
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: jlucero $, $Date: 29/11/2019 $]
 *          </p>
 */
public class PruebaServicio {

	@Test
	public void horarioLleno() {
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		assert (!horarios.isEmpty());
	}

	@Test
	public void verificarHorarioLunes() {
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		assert (!horarios.get(Semana.MONDAY.getCodigo()).isEmpty());
	}

	@Test
	public void verificarHorarioCodigo() {
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		assert (horarios.get("MO").isEmpty());
	}

	@Test
	public void verificarSalarioHorario1Viernes() {
		LocalTime hora = LocalTime.of(00, 00);
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		Horario horarioObtenido = horarios.get(Semana.FRIDAY.getCodigo()).stream().filter(
				horario -> horario.getHoraInicio().compareTo(hora) <= 0 && horario.getHoraFin().compareTo(hora) >= 0)
				.findAny().orElse(new Horario(hora, hora, 00.00));
		assert (25.00 == horarioObtenido.getSalario());
	}

	@Test
	public void verificarSalarioHorario2Lunes() {
		LocalTime hora = LocalTime.of(10, 00);
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		Horario horarioObtenido = horarios.get(Semana.MONDAY.getCodigo()).stream().filter(
				horario -> horario.getHoraInicio().compareTo(hora) <= 0 && horario.getHoraFin().compareTo(hora) >= 0)
				.findAny().orElse(new Horario(hora, hora, 00.00));
		assert (15.00 == horarioObtenido.getSalario());
	}

	@Test
	public void verificarSalarioHorario3Miercoles() {
		LocalTime hora = LocalTime.of(20, 00);
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		Horario horarioObtenido = horarios.get(Semana.WEDNESDAY.getCodigo()).stream().filter(
				horario -> horario.getHoraInicio().compareTo(hora) <= 0 && horario.getHoraFin().compareTo(hora) >= 0)
				.findAny().orElse(new Horario(hora, hora, 00.00));
		assert (20.00 == horarioObtenido.getSalario());
	}

	@Test
	public void verificarSalarioHorario1Sabado() {
		LocalTime hora = LocalTime.of(00, 00);
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		Horario horarioObtenido = horarios.get(Semana.SATURDAY.getCodigo()).stream().filter(
				horario -> horario.getHoraInicio().compareTo(hora) <= 0 && horario.getHoraFin().compareTo(hora) >= 0)
				.findAny().orElse(new Horario(hora, hora, 00.00));
		assert (30.00 == horarioObtenido.getSalario());
	}

	@Test
	public void verificarSalarioHorario2Domingo() {
		LocalTime hora = LocalTime.of(11, 10);
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		Horario horarioObtenido = horarios.get(Semana.SUNDAY.getCodigo()).stream().filter(
				horario -> horario.getHoraInicio().compareTo(hora) <= 0 && horario.getHoraFin().compareTo(hora) >= 0)
				.findAny().orElse(new Horario(hora, hora, 00.00));
		assert (20.00 == horarioObtenido.getSalario());
	}

	@Test
	public void verificarSalarioHorario3Domingo() {
		LocalTime hora = LocalTime.of(22, 30);
		Map<String, List<Horario>> horarios = new HashMap<>();
		horarios = ServicioHorario.llenarHorario();
		Horario horarioObtenido = horarios.get(Semana.SUNDAY.getCodigo()).stream().filter(
				horario -> horario.getHoraInicio().compareTo(hora) <= 0 && horario.getHoraFin().compareTo(hora) >= 0)
				.findAny().orElse(new Horario(hora, hora, 00.00));
		assert (25.00 == horarioObtenido.getSalario());
	}

	@Test
	public void separaEntrada() {
		String entrada = "RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		List<String> lista = ServicioHorario.separarCadena(entrada);
		assert (!lista.isEmpty());
	}

	@Test
	public void verificarFormatoCadenaInicio() {
		String entrada = "Tes";
		boolean formatoValido = ServicioHorario.verificarFormatoCadenaInicio(entrada);
		assert (formatoValido);
	}

	@Test
	public void verificarFormatoCadena() {
		String entrada = "MO20:00-12:00";
		boolean formatoValido = ServicioHorario.verificarFormatoCadena(entrada);
		assert (formatoValido);
	}

	@Test
	public void verificarFormato() {
		String entrada = "RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		boolean formatoValido = ServicioHorario.validarFormato(entrada);
		assert (formatoValido);
	}

	@Test
	public void obtenerArchivo() {
		List<String> lineas = ServicioHorario.leerArchivo();
		assert (!lineas.isEmpty());
	}

}
