package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cliente {
	
	private String codigo;
	private String nome;
	private String telefone;
	
	public Cliente(String codigo, String nome, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void CadastroCliente() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente novoCliente = new Cliente(codigo, nome, telefone);
		clientes.add(novoCliente);
		Collections.sort(clientes, Comparator.comparing(Cliente::getCodigo));
		System.out.println("feito");
		System.out.println(novoCliente);
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + "]";
	}
	
	
}