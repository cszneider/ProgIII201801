package br.feevale.classes;

public class Cliente {
	
	private static double limiteMaximoDeCredito = 200000;
	
	private String cpf;
	private String nome;
	private double limiteDeCredito;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getLimiteDeCredito() {
		return limiteDeCredito;
	}
	
	public void setLimiteDeCredito(double limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}
	
	public static double getLimiteMaximoDeCredito() {
		return limiteMaximoDeCredito;
	}
	
}