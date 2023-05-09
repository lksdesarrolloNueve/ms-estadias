package com.lksbaas.mx.model;

/**
 * @author Juan Eric Juárez Jaramillo
 * @descripcion : Moddelo Generico para respuesta al cliente
 * @clase : Estatus.java
 * @since 15 sep. 2022
 * @version : 1.0
 *
 */

import java.util.List;

public class Estatus<T> {

	/**
	 * Codigo de respuesta
	 */
	private String codigo;

	/**
	 * Descripcion del mensaje de respuesta
	 */
	private String mensaje;

	/**
	 * Lista Generica
	 */
	private List<T> lista;

	public Estatus(EstatusEnum esnun) {
		super();
		this.codigo = esnun.getCodigo();
		this.mensaje = esnun.getMensaje();
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the lista
	 */
	public List<T> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<T> lista) {
		this.lista = lista;
	}

}
