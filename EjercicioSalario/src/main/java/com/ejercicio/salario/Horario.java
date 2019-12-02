package com.ejercicio.salario;

import java.time.LocalTime;

/**
 * 
 * <b> Clase horario para colocar el incio y fin con su respectivo salario. </b>
 * 
 * @author jlucero
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: jlucero $, $Date: 29/11/2019 $]
 *          </p>
 */
public class Horario {

	private LocalTime horaInicio;
	private LocalTime horaFin;
	private Double salario;

	/**
	 * @param localTime
	 * @param localTime2
	 * @param salario
	 */
	public Horario(LocalTime horaInicio, LocalTime horaFin, Double salario) {
		super();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.salario = salario;
	}
	

	public Horario() {
		super();
	}



	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	/**
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}

	/**
	 * @param salario
	 *            the salario to set
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Horario [horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", salario=" + salario + "]";
	}
	
	

}
