package br.feevale.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class TrabalhandoComDatas {
	
	public static void main(String[] args) {
		
		long horaAtual = System.currentTimeMillis();
		System.out.println( horaAtual );

		Calendar diaAtual = Calendar.getInstance();
		System.out.println( diaAtual.getTimeInMillis() );
		
		System.out.println( "Dia no mes    : " + diaAtual.get( Calendar.DAY_OF_MONTH ) );
		System.out.println( "Dia no ano    : " + diaAtual.get( Calendar.DAY_OF_YEAR ) );
		System.out.println( "Dia na semana : " + diaAtual.get( Calendar.DAY_OF_WEEK ) );
		
		System.out.println( "Ano           : " + diaAtual.get( Calendar.YEAR ) );
		System.out.println( "Mes           : " + diaAtual.get( Calendar.MONTH ) );
		
		diaAtual.add( Calendar.DAY_OF_MONTH, 45 );
		System.out.println( diaAtual.getTimeInMillis() );
		
		System.out.println( diaAtual.get( Calendar.DAY_OF_MONTH ) + "/" + ( diaAtual.get( Calendar.MONTH ) + 1 ) + "    " + diaAtual.get( Calendar.DAY_OF_WEEK ) );
		
		// Transformando de Calendar para Timestamp
		
		Timestamp data = new Timestamp( diaAtual.getTimeInMillis() );
		System.out.println( "Data no formato Timestamp: " + data.toString() );
		
		// Transformando de Timestamp para Calendar
		
		Calendar diaFuturo = Calendar.getInstance();
		diaFuturo.setTimeInMillis( data.getTime() );
	}

}








