package br.feevale.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CEPServlet")
public class CEPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init( ServletConfig config ) throws ServletException {
	}
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		String cep = request.getParameter( "cep" );
		
		if( cep == null ) {
			cep = "Não Informado";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append( "<html>" );
		sb.append( "<body>" );
		sb.append( "<h1>Boa noite Feevale</h1>" );
		sb.append( "<h2>Cep de busca: " );
		sb.append( cep );
		sb.append( "</h2></body>" );
		sb.append( "</html>" );

		PrintWriter pw = response.getWriter();
		pw.write( sb.toString() );
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
