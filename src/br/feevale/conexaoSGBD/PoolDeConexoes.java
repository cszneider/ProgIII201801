package br.feevale.conexaoSGBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/* Tarefas:
 * 
 * 1) tornar esta classe um Singleton
 *    . construtor privado;
 *    . referencia estática;
 *    . método estático para retornar uma instância da classe.
 * 2) criar um ArrayList de Objetos Conexao;
 * 3) criar o método getConexao()
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
	
	// Este método não limita quantidade de conexões
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
	
	// este método é para o caso de se desejar controlar a quantidade máxima de conexões
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
				
		throw new SQLException( String.format( "A quantidade máxima de conexões (%d) foi atingida.", qtMaxConexoes ) );
	}
	
	public void setQtMaxConexoes(int qtMaxConexoes) {
		this.qtMaxConexoes = qtMaxConexoes;
	}
	
	public int getQtMaxConexoes() {
		return qtMaxConexoes;
	}
}











