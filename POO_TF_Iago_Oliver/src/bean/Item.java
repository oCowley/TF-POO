package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Item {
	private String codigo;
	private String descricao;
	private String categoria;
	private Cliente cliente;
	private double volume;
	private double valorDeclarado;
	private EnumaracaoSituacao situacao;

	public Item(String codigo, String descricao, String categoria, Cliente cliente, double volume,
			double valorDeclarado, EnumaracaoSituacao situacao) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.cliente = cliente;
		this.volume = volume;
		this.valorDeclarado = valorDeclarado;
		this.situacao = situacao;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public EnumaracaoSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(EnumaracaoSituacao situacao) {
		this.situacao = situacao;
	}

	public void CadastroItem() {
		ArrayList<Item> itens = new ArrayList<Item>();
		Item novoitem = new Item(codigo, descricao, categoria, cliente, volume, valorDeclarado, situacao);
		itens.add(novoitem);
		System.out.println("feito");
		System.out.println(novoitem);
	}

	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", descricao=" + descricao + ", categoria=" + categoria + ", cliente="
				+ cliente + ", volume=" + volume + ", valorDeclarado=" + valorDeclarado + ", situacao=" + situacao
				+ "]";
	}

}
