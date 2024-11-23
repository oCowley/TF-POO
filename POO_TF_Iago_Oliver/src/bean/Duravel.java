package bean;

public class Duravel implements Categoria {
	private String setor;
	private String materialPrincipal;

	public Duravel(String setor, String materialPrincipal) {
		this.setor = setor;
		this.materialPrincipal = materialPrincipal;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getMaterialPrincipal() {
		return materialPrincipal;
	}

	public void setMaterialPrincipal(String materialPrincipal) {
		this.materialPrincipal = materialPrincipal;
	}

}
