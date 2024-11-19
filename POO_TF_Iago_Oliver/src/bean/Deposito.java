package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deposito {
	private int codigo;
	private String nome;
	private String cidade;
	private String endereco;
	private int capacidadeMax;
	
	public Deposito(int codigo, String nome, String cidade, String endereco, int capacidadeMax) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
		this.capacidadeMax = capacidadeMax;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCapacidadeMax() {
		return capacidadeMax;
	}

	public void setCapacidadeMax(int capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}
	
	public void CadastroDeposito() {
		ArrayList<Deposito> depositos = new ArrayList<Deposito>();
		Deposito novoDeposito = new Deposito(codigo, nome, cidade, endereco, capacidadeMax);
		depositos.add(novoDeposito);
		Collections.sort(depositos, Comparator.comparingInt(Deposito::getCodigo));
		System.out.println("feito");
		System.out.println(novoDeposito);
	}

	@Override
	public String toString() {
		return "Deposito [codigo=" + codigo + ", nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco
				+ ", capacidadeMax=" + capacidadeMax + "]";
	}
	
	
}
