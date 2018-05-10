package br.feevale.conexaoSGBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// classe Wrapper
public class Conexao {
	
	private Connection cnx;
	
	public Conexao() throws SQLException, IOException {

		Parametros p = Parametros.getInstance();
		String url = p.getParameter( "urlCnx" );
		
		try{
			Class.forName( p.getParameter( "driverJDBC" ) );
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		cnx = DriverManager.getConnection( url, p.getParameter( "usuario"), p.getParameter( "senha" ) );
	}

	public Statement createStatement() throws SQLException {
		return cnx.createStatement();
	}

	public void close() throws SQLException {
		cnx.close();
	}

	public PreparedStatement prepareStatement( String cmd ) throws SQLException {
		return cnx.prepareStatement( cmd );
	}
}
