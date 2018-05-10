package br.feevale.classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.feevale.conexaoSGBD.Conexao;

public class GetDados {
	
	Dados dado = new Dados();
	int lastId;
	
	public GetDados() {
		
	}
	
	public void getAUser() throws SQLException, IOException {

		Conexao cnx = new Conexao();
		
		try {
			
			StringBuilder cmd = new StringBuilder();
			cmd.append( "select * from Usuarios where idUsuario = "+lastId+";" );

			try {
				Statement st = cnx.createStatement();
				boolean possuiRS = st.execute( cmd.toString() );
				
				if( possuiRS ) {
					
					ResultSet rs = st.getResultSet();
					
					if( rs.next() ) {
						
						do {
							
							dado.setEmail(rs.getString("endEmail"));
							dado.setNome(rs.getString("Nome"));
							dado.setDatNasc(rs.getString("dtNascimento"));
							dado.setDtIncl(rs.getString("dtInclusao"));
							dado.setId(rs.getInt("idUsuario"));
							dado.setPass(rs.getString("senha"));
							
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
	
	public String getDadoNome() {
		return dado.getNome();
	}
	
	public int getDadoId() {
		return dado.getId();
	}
	
	public String getDadoNasc() {
		return dado.getDatNasc();
	}
	
	public String getDadoIncl() {
		return dado.getDtIncl();
	}
	
	public String getDadoEmail() {
		return dado.getEmail();
	}
	
	public String getDadoPass() {
		return dado.getPass();
	}
	
	public void getIdNumb() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/PGIII201801";
		
		try{
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		Connection cnx = DriverManager.getConnection( url, "postgres", "feevale" );
		System.out.println( "Conexão ao Banco de Dados foi efetuada com sucesso!" );
		
		try {
			
			StringBuilder cmd = new StringBuilder();
			cmd.append( "select * from Usuarios;" );

			try {
				Statement st = cnx.createStatement();
				boolean possuiRS = st.execute( cmd.toString() );
				
				if( possuiRS ) {
					
					ResultSet rs = st.getResultSet();
					
					if( rs.next() ) {
						
						do {
							
							lastId = rs.getInt("idUsuario");

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

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}
	
}