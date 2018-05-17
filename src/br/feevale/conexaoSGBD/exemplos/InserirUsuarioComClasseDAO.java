package br.feevale.conexaoSGBD.exemplos;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import br.feevale.conexaoSGBD.Usuario;
import br.feevale.conexaoSGBD.UsuarioDAO;

public class InserirUsuarioComClasseDAO {

	public static void main(String[] args) throws SQLException {
		
		Calendar dtNascimento = Calendar.getInstance();
		dtNascimento.set( 1987, 10, 27 );
		
		Usuario novo = new Usuario();
		novo.setNome( "Fernando" );
		novo.setEmail( "fernando@feevale.br" );
		novo.setPass( "123321" );
		novo.setDatNasc( new Timestamp( dtNascimento.getTimeInMillis() ) );
		
		UsuarioDAO.insere( novo );
		
	}


}




