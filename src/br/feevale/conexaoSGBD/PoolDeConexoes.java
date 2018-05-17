package br.feevale.conexaoSGBD;

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
	
	private ArrayList<Conexao> listaConexoes;
	
	private PoolDeConexoes() {
		listaConexoes = new ArrayList<Conexao>();
	}

	public static PoolDeConexoes getInstance() {
		return null;
	}
	
	public synchronized Conexao getConexao() {
		return null;
	}
}











