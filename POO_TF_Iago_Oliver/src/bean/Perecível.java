package bean;

public class Perec�vel implements Categoria{
	private String origem;
	private String tempoMaximoValidade;
	
	public Perec�vel(String origem, String tempoMaximoValidade) {
		this.origem = origem;
		this.tempoMaximoValidade = tempoMaximoValidade;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getTempoMaximoValidade() {
		return tempoMaximoValidade;
	}

	public void setTempoMaximoValidade(String tempoMaximoValidade) {
		this.tempoMaximoValidade = tempoMaximoValidade;
	}
	
	
}
