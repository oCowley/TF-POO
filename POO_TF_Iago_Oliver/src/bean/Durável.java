package bean;

public class Durável implements Categoria {
	private String setor;
	private String materialPrincipal;

	public Durável(String setor, String materialPrincipal) {
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
