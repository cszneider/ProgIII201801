package br.feevale.conexaoSGBD.exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ComoExecutarSelect {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/PGIII201801";
		
		Connection cnx = DriverManager.getConnection( url, "postgres", "feevale" );
		System.out.println( "Conexão ao Banco de Dados foi efetuada com sucesso!" );
		
		try {
			
			StringBuilder cmd = new StringBuilder();
			cmd.append( "select * from Clientes;" );

			try {
				Statement st = cnx.createStatement();
				boolean possuiRS = st.execute( cmd.toString() );
				
				if( possuiRS ) {
					
					SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
					DecimalFormat df = new DecimalFormat( "###,###,##0.00");
					
					ResultSet rs = st.getResultSet();
					
					if( rs.next() ) {
						
						do {
							
							Integer id = rs.getInt( "idCliente" );
							String nome = rs.getString( "dsNome" );
							Timestamp dtn = rs.getTimestamp( "dtNascimento" );
							Double credito = rs.getDouble( "vlCredito" );
							
							System.out.println( String.format( "%d %s %s %s", id, nome, sdf.format( dtn ), df.format( credito ) ) );
							
							
						} while( rs.next() );
					} else {
						System.out.println( "O comando select não retornou linhas do banco de dados" );
					}
					
				}
			} catch( SQLException e ) {
				System.out.println( "Houve erro na execução do comando insert" );
				System.out.println( e.getMessage() );
				System.out.println( "Código de erro: " + e.getSQLState() );
			}
			
			
		} finally {
			cnx.close();
		}
	}
}
