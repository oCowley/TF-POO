package bean;

public class Item {
	private String codigo;
	private String descricao;
	private String categoria;
	private String cliente;
	private double volume;
	private double valorDeclarado;
	//private  situacao;
	
	public Item(String codigo, String descricao, String categoria, String cliente, double volume,
			double valorDeclarado) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.cliente = cliente;
		this.volume = volume;
		this.valorDeclarado = valorDeclarado;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getValorDeclarado() {
		return valorDeclarado;
	}
	public void setValorDeclarado(double valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}
	
	
}
