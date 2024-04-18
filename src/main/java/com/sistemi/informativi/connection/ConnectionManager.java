package com.sistemi.informativi.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sistemi.informativi.singleton.ConnectionSingleton;

public class ConnectionManager {

	private Connection connection;

	/*
	 * Implementazione di un metodo generico che si occupa di inizializzare una
	 * variabile di tipo PreparedStatement per dare la possibilità a chi lo invoca
	 * di effettuare una operazione di CRUD
	 *
	 */
	public PreparedStatement getPreparedStatement(String sql) {

		PreparedStatement ps = null;

		try {

			ps = connection.prepareStatement(sql);

		}

		catch (SQLException ex) {

			ex.printStackTrace();
		}

		return ps;
	}

	/*
	 * Implementazione di un metodo generico che si occupa di inizializzare una
	 * variabile di tipo ResultSet in maniera tale che, ogni volta che verrà
	 * invocato, restituisca una Struttura Dati già formata con i risultati della
	 * specifica query richiesta (applicabile pe query non parametriche)
	 */
	public ResultSet getResultSet(String sql) {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}

		catch (SQLException ex) {

			ex.printStackTrace();
		}

		return rs;
	}

	public  void closeConnection() {

		try {

			if (connection != null) {

				connection.close();

			}

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

	}

	/*
	 * Quando verrà istanziata la classe ConnectionManager
	 * tramite il Costruttore sottostante verrà inizializzata
	 * la connessione sempre e solo una volta dato che abbiamo
	 * implementato il pattern Singleton
	 */
	public ConnectionManager() {

		try {

			this.connection = ConnectionSingleton.getConnection();

		}

		catch (SQLException ex) {

			ex.printStackTrace();
		}

	}

}
