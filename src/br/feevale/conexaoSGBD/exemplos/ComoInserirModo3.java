package br.feevale.conexaoSGBD.exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class ComoInserirModo3 {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/PGIII201801";
		
		Connection cnx = DriverManager.getConnection( url, "postgres", "feevale" );
		System.out.println( "Conexão ao Banco de Dados foi efetuada com sucesso!" );
		
		try {

			int idCliente = 4;
			String dsNome = "Lari Basilio";
			Calendar dtNascimento = Calendar.getInstance();
			dtNascimento.set( 1998, 11, 14 );
			String tpSexo = "F";
			int qtDependentes = 0;
			double vlCredito = 40000;
			boolean ativo = true;
			
			StringBuilder cmd = new StringBuilder();
			cmd.append( "insert into Clientes\n" );
			cmd.append( "( idCliente, dsNome, dtNascimento, qtDependentes, vlCredito, tpSexo, idAtivo )\n" );
			cmd.append( "values\n" );
			cmd.append( "( ?, ?, ?, ?, ?, ?, ? )" );

			try {
				PreparedStatement st = cnx.prepareStatement( cmd.toString() );
				
				st.setInt( 1, idCliente );
				st.setString( 2, dsNome );
				st.setTimestamp( 3, new Timestamp( dtNascimento.getTimeInMillis() ) );
				st.setInt( 4, qtDependentes );
				st.setDouble( 5, vlCredito );
				st.setString( 6, tpSexo );
				st.setBoolean( 7, ativo );
				
				boolean status = st.execute();
				
				System.out.println( "O comando insert foi executado com status: " + status );
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
