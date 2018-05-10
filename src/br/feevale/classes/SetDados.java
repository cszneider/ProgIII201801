package br.feevale.classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import br.feevale.classes.GetDados;
import br.feevale.conexaoSGBD.Conexao;
import br.feevale.conexaoSGBD.Parametros;

public class SetDados {
	
	Dados dado = new Dados();
	
	public void setDados(String email, String nome, String pass, String datNasc) {
		this.dado.setEmail(email);
		this.dado.setNome(nome);
		this.dado.setPass(pass);
		this.dado.setDatNasc(datNasc);
	}
	
	public void addNewUser() throws SQLException, ParseException, IOException {
		
		Conexao cnx = new Conexao();
		
		try {
			
			StringBuilder cmd = new StringBuilder();
			cmd.append( "insert into Usuarios\n" );
			cmd.append( "(idUsuario, endEmail, nome, senha,	dtNascimento)\n" );
			cmd.append( "values\n" );
			cmd.append( "( ?, ?, ?, ?, ?)" );

			PreparedStatement st = cnx.prepareStatement( cmd.toString() );
				
			st.setInt(1, getUltId()+1);
			st.setString(2, dado.getEmail());
			st.setString(3, dado.getNome());
			st.setString(4, dado.getPass());
			
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
		    st.setTimestamp(5, new Timestamp(df.parse(dado.getDatNasc()).getTime()));
		    
		    st.execute();
		} finally {
			cnx.close();
		}
	}
	
	public int getUltId() throws SQLException {
		GetDados dadoId = new GetDados();
		dadoId.getIdNumb();
		return dadoId.getLastId();	
	}
	
}