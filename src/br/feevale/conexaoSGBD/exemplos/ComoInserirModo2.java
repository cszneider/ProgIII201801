package br.feevale.conexaoSGBD.exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ComoInserirModo2 {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/PGIII201801";
		
		Connection cnx = DriverManager.getConnection( url, "postgres", "feevale" );
		System.out.println( "Conexão ao Banco de Dados foi efetuada com sucesso!" );
		
		try {

			int idCliente = 3;
			String dsNome = "Steeve Vai";
			String dtNascimento = "1958-10-10";
			String tpSexo = "M";
			int qtDependentes = 5;
			double vlCredito = 40000;
			boolean ativo = true;
			
			StringBuilder cmd = new StringBuilder();
			cmd.append( "insert into Clientes\n" );
			cmd.append( "( idCliente, dsNome, dtNascimento, qtDependentes, vlCredito, tpSexo, idAtivo )\n" );
			cmd.append( "values\n" );
			cmd.append( "( " );
			cmd.append( idCliente );
			cmd.append( ", '" );
			cmd.append( dsNome );
			cmd.append( "', '" );
			cmd.append( dtNascimento );
			cmd.append( "', " );
			cmd.append( qtDependentes );
			cmd.append( ", " );
			cmd.append( vlCredito );
			cmd.append( ", '" );
			cmd.append( tpSexo );
			cmd.append( "', " );
			cmd.append( ativo );
			cmd.append( " )" );

			try {
				Statement st = cnx.createStatement();
				boolean status = st.execute( cmd.toString() );
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
