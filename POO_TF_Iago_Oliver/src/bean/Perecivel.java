package bean;

public class Perecivel implements Categoria{
	private String origem;
	private String tempoMaximoValidade;
	
	public Perecivel(String origem, String tempoMaximoValidade) {
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
