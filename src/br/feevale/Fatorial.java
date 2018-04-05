package br.feevale;

public class Fatorial {

	private int nro;
	private long fatorial;
	
	private boolean calculouFatorial;
	private boolean deuRuim;
	private String msgErro;

	public Fatorial( String nro ) {
	
		calculouFatorial = false;
		deuRuim = false;
		
		if( nro != null ) {
		
			try {
				
				this.nro = Integer.parseInt( nro );
				int n = this.nro;
				fatorial = 1;
				
				while( n > 1 ) {
					fatorial *= n--;
				}
			} catch( Exception e ) {
				deuRuim = true;
				msgErro = "Não sei calcular o fatorial de " + nro;
			}
		}
	}
	
	public Fatorial( int nro ) {
		
		this.nro = nro;
		
		fatorial = 1;
		while( nro > 1 ) {
			fatorial *= nro--;
		}
	}
	
	public int getNro() {
		return nro;
	}

	public long getFatorial() {
		return fatorial;
	}
	
	public boolean isCalculouFatorial() {
		return calculouFatorial;
	}
	
	public boolean isDeuRuim() {
		return deuRuim;
	}
	
	public String getMsgErro() {
		return msgErro;
	}
}














