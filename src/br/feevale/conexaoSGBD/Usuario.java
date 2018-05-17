package br.feevale.conexaoSGBD;

import java.sql.Timestamp;

public class Usuario {
	
		private int id;
		private String email;
		private String nome;
		private String pass;
		private Timestamp datNasc;
		private Timestamp dtIncl;
		
		public Usuario() {
			
		}
		
		public Usuario( String email, String nome, String pass, Timestamp datNasc ) {
			this.email = email;
			this.nome = nome;
			this.pass = pass;
			this.datNasc = datNasc;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public Timestamp getDatNasc() {
			return datNasc;
		}

		public void setDatNasc(Timestamp datNasc) {
			this.datNasc = datNasc;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Timestamp getDtIncl() {
			return dtIncl;
		}

		public void setDtIncl(Timestamp dtIncl) {
			this.dtIncl = dtIncl;
		}
}