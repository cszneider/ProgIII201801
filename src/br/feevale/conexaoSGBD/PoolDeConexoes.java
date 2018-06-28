package br.feevale.conexaoSGBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/* Tarefas:
 * 
 * 1) tornar esta classe um Singleton
 *    . construtor privado;
 *    . referencia est�tica;
 *    . m�todo est�tico para retornar uma inst�ncia da classe.
 * 2) criar um ArrayList de Objetos Conexao;
 * 3) criar o m�todo getConexao()
 *    . percorrer a lista de conexoes e liberar uma conexao que esteja livre 
 */
public class PoolDeConexoes {
	
	private static PoolDeConexoes meuPool;
	private int qtMaxConexoes = 30;
	
	private ArrayList<Conexao> listaConexoes;
	
	private PoolDeConexoes() {
		listaConexoes = new ArrayList<Conexao>();
	}

	public static PoolDeConexoes getInstance() {
		
		if( meuPool == null ) {
			meuPool = new PoolDeConexoes();
		}
		
		return meuPool;
	}
	
	// Este m�todo n�o limita quantidade de conex�es
	public synchronized Conexao getConexao() throws IOException, SQLException {

		for( Conexao cnx : listaConexoes ) {

			if( cnx.isLivre() ) {
				cnx.reserva();
				return cnx;
			}
		}
		
		Conexao cnx = new Conexao();
		cnx.reserva();
		listaConexoes.add( cnx );
				
		return cnx;
	}
	
	// este m�todo � para o caso de se desejar controlar a quantidade m�xima de conex�es
	public synchronized Conexao getConexaoControlada() throws IOException, SQLException {

		for( Conexao cnx : listaConexoes ) {

			if( cnx.isLivre() ) {
				cnx.reserva();
				return cnx;
			}
		}

		if( listaConexoes.size() < qtMaxConexoes ) {
			Conexao cnx = new Conexao();
			cnx.reserva();
			listaConexoes.add( cnx );
			return cnx;
		}
				
		throw new SQLException( String.format( "A quantidade m�xima de conex�es (%d) foi atingida.", qtMaxConexoes ) );
	}
	
	public void setQtMaxConexoes(int qtMaxConexoes) {
		this.qtMaxConexoes = qtMaxConexoes;
	}
	
	public int getQtMaxConexoes() {
		return qtMaxConexoes;
	}
}











