package br.feevale.conexaoSGBD.exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ComoConectar {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/PGIII201801";
		
		Connection cnx = DriverManager.getConnection( url, "postgres", "feevale" );
		
		try {

			System.out.println( "Conexão ao Banco de Dados foi efetuada com sucesso!" );
			
		} finally {
			cnx.close();
		}
		
		
		
	}

}
