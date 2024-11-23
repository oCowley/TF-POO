package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import bean.Cliente;

public class ClienteService {
ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public ClienteService() {
		this.clientes =  new ArrayList<Cliente>();
	}

	public void cadastroCliente(String codigo, String nome, String telefone) {
		
		Cliente novoCliente = new Cliente(codigo, nome, telefone);
		clientes.add(novoCliente);
		ordenaClientes();
		System.out.println("Cliente "+ codigo + " Cadastrado");
		System.out.println(toString());
	}
	
	public void ordenaClientes() {
		Collections.sort(clientes, Comparator.comparing(Cliente::getCodigo));
	}

	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
	
	public Optional<Cliente> getClienteByCodigo(String codigo) {
		return this.clientes.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst();
	}

	@Override
	public String toString() {
		return "clienteService [clientes=" + clientes + "]";
	}
}
