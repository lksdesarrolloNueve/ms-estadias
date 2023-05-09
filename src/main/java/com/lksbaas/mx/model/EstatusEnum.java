package com.lksbaas.mx.model;

public enum EstatusEnum {
	
	/**
	 * Consulta existosa
	 */
	CONS_EXITOSA("0","Consulta Exitosa."),
	/**
	 * datos no encontrados
	 */
	DATOS_NO_ENCONTRADOS("1","Datos no encontrados."),
	/**
	 * Error servidor
	 */
	ERROR("5","Ocurrió un error al ejecutar la operación, intente más tarde.");
	
	/**
	 * Codigo de respuesta
	 */
	private final String codigo;
	
	/**
	 * Descripcion del mensaje de respuesta
	 */
	private final String mensaje;
	
	/**
	 *Constructor de la clase
	 */
	EstatusEnum(String codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;

	}
	
	/**
	 * Get codigo
	 * @return {String}
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Get Mensaje
	 * @return {String}
	 */
	public String getMensaje() {
		return mensaje;
	}

}
