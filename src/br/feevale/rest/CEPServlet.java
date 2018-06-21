package br.feevale.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import br.feevale.conexaoSGBD.Conexao;

@WebServlet("/CEPServlet")
public class CEPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init( ServletConfig config ) throws ServletException {
	}
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		
		String cep = request.getParameter( "cep" );
		
		JSONObject result = new JSONObject();
		
		try {
			if( cep == null ) {
				result.put( "status", -1 );
				result.put( "dsErro", "cep não informado" );
			} else {
				Conexao cnx = new Conexao();

				try {
					
					String cmd = "Select * from cidades where cd_cep = ?";
					PreparedStatement ps = cnx.prepareStatement( cmd );
					ps.setString( 1, cep );
					
					ResultSet rs = ps.executeQuery();
					if( rs.next() ) {
						result.put( "status", 0 );
						result.put( "cdEstado", rs.getString( "cd_estado" ) );
						result.put( "idCidade", rs.getInt( "id_cidade" ) );
						result.put( "dsCidade", rs.getString( "ds_cidade" ).trim() );
					} else {
						result.put( "status", -2 );
						result.put( "dsErro", "cep não encontrado" );
					}
				} finally {
					cnx.close();
				}
			}

			PrintWriter pw = response.getWriter();
			pw.write( result.toString() );
			pw.flush();
			
		} catch( Exception e ) {
			response.setStatus( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
