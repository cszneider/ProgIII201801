package br.feevale.conexaoSGBD.exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ComoInserirModo1 {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/PGIII201801";
		
		Connection cnx = DriverManager.getConnection( url, "postgres", "feevale" );
		System.out.println( "Conex�o ao Banco de Dados foi efetuada com sucesso!" );
		
		try {
			
			StringBuilder cmd = new StringBuilder();
			cmd.append( "insert into Clientes\n" );
			cmd.append( "( idCliente, dsNome, dtNascimento, qtDependentes, vlCredito, tpSexo, idAtivo )\n" );
			cmd.append( "values\n" );
			cmd.append( "( 2, 'Mike Stern', '1972-09-29', 2, 28000, 'M', true )" );

			try {
				Statement st = cnx.createStatement();
				boolean status = st.execute( cmd.toString() );
				System.out.println( "O comando insert foi executado com status: " + status );
			} catch( SQLException e ) {
				System.out.println( "Houve erro na execu��o do comando insert" );
				System.out.println( e.getMessage() );
				System.out.println( "C�digo de erro: " + e.getSQLState() );
			}
			
			
		} finally {
			cnx.close();
		}
		
		
		
	}

}
