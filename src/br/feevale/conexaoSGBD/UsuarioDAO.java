package br.feevale.conexaoSGBD;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsuarioDAO {
	
	public static void insere( Usuario usuario ) throws SQLException, IOException {
		
		PoolDeConexoes pool = PoolDeConexoes.getInstance();
		Conexao cnx = pool.getConexao();
		
		try {

			String cmd = "select nextval( 'sqIdUsuario' );";
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery( cmd );
			
			if( rs.next() ) {

				String cmdins = "insert into usuarios (idUsuario, endEmail, dtInclusao, nome, senha, dtNascimento ) values ( ?,?,current_timestamp,?,?,? );";
				
				usuario.setId( rs.getInt( 1 ) );
				
				PreparedStatement ps = cnx.prepareStatement( cmdins );
				ps.setInt( 1, usuario.getId() );
				ps.setString( 2, usuario.getEmail() );
				ps.setString( 3, usuario.getNome() );
				ps.setString( 4, usuario.getPass() );
				ps.setTimestamp( 5, usuario.getDatNasc() );
				
				ps.execute();
			} else {
				throw new SQLException( "Sequencia sqIdUsuario não está definida" );
			}
		} finally {
			cnx.libera();
		}
	}
	
	public static void altera( Usuario usuario ) throws SQLException {
		
	}
	
	public static void exclui( Usuario usuario ) throws SQLException {
	}
	
	public static List<Usuario> getUsuarios( String clausulaWhere ) throws SQLException {
		
		return null;
	}
	
	public static Usuario getUsuarioPorEmail( String email ) throws SQLException, IOException {

		PoolDeConexoes pool = PoolDeConexoes.getInstance();
		Conexao cnx = pool.getConexao();
		
		try {

			String cmd = "select * from usuarios where endEmail = ?";
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setString( 1, email );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				
				Usuario usuario = new Usuario();
				usuario.setId( rs.getInt( "idUsuario" ) );
				usuario.setEmail( rs.getString( "endEmail" ) );
				usuario.setDtIncl( rs.getTimestamp( "dtInclusao" ) );
				usuario.setNome( rs.getString( "nome" ) );
				usuario.setPass( rs.getString( "senha" ) );
				usuario.setDatNasc( rs.getTimestamp( "dtNascimento" ) );
				
				return usuario;
				
			} else {
				return null;
			}
			
		} finally {
			cnx.libera();
		}
	}
}







