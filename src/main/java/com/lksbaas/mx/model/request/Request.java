package com.lksbaas.mx.model.request;

import java.io.Serializable;

public class Request implements Serializable{
	
	/**
	 * Serial Id de la clase
	 */
	private static final long serialVersionUID = -4090945635978003617L;

	/**
	 * Arreglo de datos
	 */
	private String[] datos;
	
	/**
	 * Accion a realizar 
	 */
	private Integer accion;

	/**
	 * @return the datos
	 */
	public String[] getDatos() {
		return datos;
	}

	/**
	 * @param datos the datos to set
	 */
	public void setDatos(String[] datos) {
		this.datos = datos;
	}

	/**
	 * @return the accion
	 */
	public Integer getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(Integer accion) {
		this.accion = accion;
	}
	
	
	

}
