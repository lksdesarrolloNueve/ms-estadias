package com.lksbaas.mx.dao;


import org.springframework.jdbc.core.RowMapper;

import com.lksbaas.mx.model.Estatus;

/**
 * @author Juan Eric Juárez Jaramillo
 * @descripcion : Que para gestionar CRUDS y LISTAS desde la base de datos
 * @clase : IGestionDAO.java
 * @since 15 sep. 2022
 * @version : 1.0
 *
 */
public interface IGestionDAO<T> {
	
	/**
	 * Metodo que retornara una consulta desde una funcion
	 * @param query - Query a consultar
	 * @param params - PArametros a filtrar
	 * @return {@link Estatus<T>} Info generica a retormnar
	 */
	Estatus<T> getList(String query, Object[] params, RowMapper<T> rowMapp);
	
	
	/**
	 * Metodo que recibe un crud
	 * @param query - Crud a ejecutar
	 * @param params - Parametros a registrar
	 * @return {@link Estatus<T>} Info generica a retormnar
	 */
	Estatus<T> crud(String query, Object[] params);
	
	
	/**
	 * Metodo que retornara una consulta desde una funcion y retorna un JSON en text
	 * @param query - Query a consultar
	 * @param params - PArametros a filtrar
	 * @return {@link String} JSON generico
	 */
	String exeJSON(String query, Object[] params);

}
