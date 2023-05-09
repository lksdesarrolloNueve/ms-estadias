package com.lksbaas.mx.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lksbaas.mx.dao.IGestionDAO;
import com.lksbaas.mx.mapper.ResponseJsonMapper;
import com.lksbaas.mx.model.Estatus;
import com.lksbaas.mx.model.EstatusEnum;
/**
 * @author Juan Eric Juárez Jaramillo
 * @descripcion : Clase para gestionar CRUDS y LISTAS desde la base de datos
 * @clase : ImplGestionDAO.java
 * @since 15 sep. 2022
 * @version : 1.0
 *
 */
@Repository
public class ImplGestionDAO<T> implements IGestionDAO<T> {

	/**
	 * Instancia de JDBCTemplate para el acceso a la BD
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Metodo que retornara una consulta desde una funcion
	 * 
	 * @param query  - Query a consultar
	 * @param params - PArametros a filtrar
	 * @return {@link Estatus<T>} Info generica a retormnar
	 */
	@Override
	public Estatus<T> getList(String query, Object[] params, RowMapper<T> rowMapp) {
		var estatus = new Estatus<T>(EstatusEnum.ERROR);

		List<T> list = null;
		try {
			if (params != null && params.length > 0) {
				list = jdbcTemplate.query(query, rowMapp, params);
			} else {
				list = jdbcTemplate.query(query, rowMapp);
			}

			if (list.isEmpty()) {
				estatus = new Estatus<T>(EstatusEnum.DATOS_NO_ENCONTRADOS);
			} else {
				estatus = new Estatus<T>(EstatusEnum.CONS_EXITOSA);
				estatus.setLista(list);
			}

		} catch (DataAccessException e) {
			estatus.setCodigo("5");
			estatus.setMensaje(e.getMessage()+" "+e.getRootCause());
		}

		return estatus;
	}

	/**
	 * Metodo que recibe un crud
	 * 
	 * @param query  - Crud a ejecutar
	 * @param params - Parametros a registrar
	 * @return {@link Estatus<T>} Info generica a retormnar
	 */
	@Override
	public Estatus<T> crud(String query, Object[] params) {
		var estatus = new Estatus<T>(EstatusEnum.ERROR);

		try {

			var response = jdbcTemplate.queryForObject(query, new RowMapper<String[]>() {

				@Override
				public String[] mapRow(ResultSet rs, int rowNum) throws SQLException {
					var arr = rs.getArray(1);

					return (String[]) arr.getArray();
				}

			}, params);

			if (response != null) {
				estatus.setCodigo(response[0]);
				estatus.setMensaje(response[1]);
			}

		} catch (DataAccessException e) {
			estatus.setCodigo("5");
			estatus.setMensaje(e.getMessage());
		}

		return estatus;
	}

	/**
	 * Metodo que retornara una consulta desde una funcion y retorna un JSON en text
	 * @param query - Query a consultar
	 * @param params - PArametros a filtrar
	 * @return {@link String} JSON generico
	 */
	@Override
	public String getJSON(String query, Object[] params) {
		return jdbcTemplate.queryForObject(query, new ResponseJsonMapper(), params);
	}

}
