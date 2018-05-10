package br.feevale.conexaoSGBD;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Parametros {

	private Properties parametros;
	
	private static Parametros mySelf;
	
	public static Parametros getInstance() throws IOException {

		if( mySelf == null ) {
			mySelf = new Parametros();
			mySelf.loadFromFile( "C:/Users/0000782/Desktop/workspace/ProjetoWeb1/conf/parametros.xml" );
		}
		
		return mySelf;
	}
	
	private Parametros() {
		parametros = new Properties();
	}
	
	public void addParameter( String key, String value ) {
		parametros.put( key, value );
	}
	
	public String getParameter( String key ) {
		return parametros.getProperty( key );
	}
	
	public void saveToFile( String fileName ) throws IOException {
		
		FileOutputStream fos = new FileOutputStream( fileName );
		
		try {
			parametros.storeToXML( fos,  "Parametros do Banco de Dados" );
		} finally {
			fos.close();
		}
	}
	
	public void loadFromFile( String fileName ) throws IOException {
		
		FileInputStream fis = new FileInputStream( fileName );
		
		try {
			parametros = new Properties();
			parametros.loadFromXML( fis );
		} finally {
			fis.close();
		}
	}
}








