package br.feevale.classes;

public class Dados {
	
		private String email;
		private String nome;
		private String pass;
		private String datNasc;
		private int id;
		private String dtIncl;
		
		public Dados() {
			
		}
		
		public Dados(String email, String nome, String pass, String datNasc) {
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

		public String getDatNasc() {
			return datNasc;
		}

		public void setDatNasc(String datNasc) {
			this.datNasc = datNasc;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDtIncl() {
			return dtIncl;
		}

		public void setDtIncl(String dtIncl) {
			this.dtIncl = dtIncl;
		}
}