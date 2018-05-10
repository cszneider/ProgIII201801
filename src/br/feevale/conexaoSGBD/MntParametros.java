package br.feevale.conexaoSGBD;

import java.io.IOException;

public class MntParametros {

	
	public static void main(String[] args) throws IOException {
		
		Parametros p = Parametros.getInstance();
		
		System.out.println( p.getParameter( "urlCnx") );
		
	}
}
