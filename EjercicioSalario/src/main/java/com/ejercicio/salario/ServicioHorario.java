package com.ejercicio.salario;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * <b> Clase servicio para obtener todos los metodos utlizados para el calculo
 * del salario. </b>
 * 
 * @author jlucero
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: jlucero $, $Date: 29/11/2019 $]
 *          </p>
 */
public class ServicioHorario {

	/**
	 * 
	 * <b> Metodo que llena la semana segun el dia y el horario correspondiente
	 * con sus repectivos valores del salario. </b>
	 * <p>
	 * [Author: jlucero, Date: 29/11/2019]
	 * </p>
	 *
	 * @return Map<String, List<Horario>> la llave es la semana asignada con su
	 *         codigo con su respectiva lista de horarios
	 */
	public static Map<String, List<Horario>> llenarHorario() {
		Map<String, List<Horario>> horarioSemana = new HashMap<>();
		List<Horario> semana = new ArrayList<>();
		Horario horario1 = new Horario(LocalTime.of(00, 00), LocalTime.of(9, 00), 25.00);
		Horario horario2 = new Horario(LocalTime.of(9, 01), LocalTime.of(18, 00), 15.00);
		Horario horario3 = new Horario(LocalTime.of(18, 01), LocalTime.MAX, 20.00);
		semana.add(horario1);
		semana.add(horario2);
		semana.add(horario3);

		List<Horario> horariosFinSemana = new ArrayList<>();
		Horario horario4 = new Horario(LocalTime.of(00, 00), LocalTime.of(9, 00), 30.00);
		Horario horario5 = new Horario(LocalTime.of(9, 01), LocalTime.of(18, 00), 20.00);
		Horario horario6 = new Horario(LocalTime.of(18, 01), LocalTime.MAX, 25.00);
		horariosFinSemana.add(horario4);
		horariosFinSemana.add(horario5);
		horariosFinSemana.add(horario6);

		horarioSemana.put(Semana.MONDAY.getCodigo(), semana);
		horarioSemana.put(Semana.TUESDAY.getCodigo(), semana);
		horarioSemana.put(Semana.WEDNESDAY.getCodigo(), semana);
		horarioSemana.put(Semana.THURDAY.getCodigo(), semana);
		horarioSemana.put(Semana.FRIDAY.getCodigo(), semana);
		horarioSemana.put(Semana.SATURDAY.getCodigo(), horariosFinSemana);
		horarioSemana.put(Semana.SUNDAY.getCodigo(), horariosFinSemana);
		return horarioSemana;
	}

	public static boolean verificarFormatoCadenaInicio(String cadena) {
		Pattern pattern = Pattern.compile("([A-Za-z])+");
		Matcher matcher = pattern.matcher(cadena);
		return matcher.matches();
	}

	public static boolean verificarFormatoCadena(String cadena) {
		Pattern pattern = Pattern.compile("([A-Za-z]{2})(\\d{2}):(\\d{2})-(\\d{2}):(\\d{2})");
		Matcher matcher = pattern.matcher(cadena);
		return matcher.matches();
	}

	public static List<String> separarCadena(String str) {
		return Stream.of(str.split("\\s+=|=\\s*|,\\s*")).map(String::new).collect(Collectors.toList());
	}

	public static List<String> separarHoras(String str) {
		return Stream.of(str.split("-")).map(String::new).collect(Collectors.toList());
	}

	public static boolean validarFormato(String entrada) {
		List<String> lista = ServicioHorario.separarCadena(entrada);
		boolean formatoValido = Boolean.TRUE;
		for (int i = 0; i < lista.size() && formatoValido; i++) {
			if ((i == 0 && !ServicioHorario.verificarFormatoCadenaInicio(lista.get(i)))
					|| (i > 0 && !ServicioHorario.verificarFormatoCadena(lista.get(i)))) {
				System.out.println("Error en el registro: " + lista.get(i));
				formatoValido = Boolean.FALSE;
			}

		}
		return formatoValido;
	}

	public static List<String> leerArchivo() {
		List<String> lineas = new ArrayList<String>();
		try {
			Path p = Paths.get("fichero.txt");
			if (Files.exists(p)) {
				lineas = Files.readAllLines(p);
			} else {
				BufferedWriter bw = Files.newBufferedWriter(p, Charset.forName("UTF-8"));

				String prueba1 = "RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
				String prueba2 = "ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00";
				String prueba3 = "JAVIER=MO12:00-14:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
				String prueba4 = "JENNY=TU10:00-12:00,WE12:00-15:00,SA13:00-18:00";
				String prueba5 = "PATRICIO=FR02:00-03:00,SA15:00-18:00,SU20:00-22:00";
				lineas = new ArrayList<>();
				lineas.add(prueba1);
				lineas.add(prueba2);
				lineas.add(prueba3);
				lineas.add(prueba4);
				lineas.add(prueba5);

				lineas.forEach((s) -> {
					try {
						bw.write(s);
						bw.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lineas;

	}

	public static double obtenerTotalPagar(Map<String, List<Horario>> horarioSemana, String campo) {
		Double total = 0.0;
		List<String> horas = ServicioHorario.separarHoras(campo.substring(2));
		List<Horario> horariosDia = new ArrayList<Horario>();
		horariosDia = horarioSemana.get(campo.substring(0, 2));
		List<Horario> horariosFiltrado = horariosDia.stream()
				.filter(horario -> LocalTime.parse(horas.get(0)).compareTo(horario.getHoraInicio()) >= 0
						&& LocalTime.parse(horas.get(1)).compareTo(horario.getHoraFin()) <= 0)
				.collect(Collectors.toList());
		for (Horario horarioFiltrado : horariosFiltrado) {
			Long totalHoras = ChronoUnit.HOURS.between(LocalTime.parse(horas.get(0)), LocalTime.parse(horas.get(1)));
			total += horarioFiltrado.getSalario() * totalHoras;
		}
		return total;
	}

}
