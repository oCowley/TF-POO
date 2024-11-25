package service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import bean.Cliente;
import bean.Deposito;

public class ClienteService {
	private static final String SEPARADOR = ";";
	private static final String QUEBRADELINHA = "\n";
	private static final String CLIENTE_CSV = "Clientes.csv";
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public ClienteService() {
		this.clientes = new ArrayList<Cliente>();
	}

	public void cadastroCliente(String codigo, String nome, String telefone) {

		Cliente novoCliente = new Cliente(codigo, nome, telefone);
		clientes.add(novoCliente);
		ordenaClientes();
		System.out.println("Cliente " + codigo + " Cadastrado");
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

	public void salvar() {
		System.out.println("salvando cliente...");
		FileWriter arq = null;
		try {
			arq = new FileWriter(CLIENTE_CSV);
			PrintWriter gravararq = new PrintWriter(arq);
			gravararq.print(toCSV());
			arq.close();
		} catch (Exception e) {
			System.err.format("Erro de E/S: %s%n", e);
		}

	}

	public void carregar() {
		System.out.println("carregado cliente...");
		try {
			FileReader f = new FileReader(CLIENTE_CSV);
			// Scanner � respons�vel por ler
			Scanner arquivolido = new Scanner(f);
			// mostra o delimitador
			arquivolido.useDelimiter(QUEBRADELINHA);
			// pega o proximo texto entre um ; e outro
			String valorlido = "";
			// le o arquivo considerando os delimitadores
			this.clientes = new ArrayList<Cliente>();
			while (arquivolido.hasNext()) {
				valorlido = arquivolido.next();
				String[] valor = valorlido.split(SEPARADOR);
				cadastroCliente(valor[0], valor[1], valor[2]);
			}
		} catch (Exception e) {
			System.err.format("Erro de E/S: %s%n", e);
		}

	}

	public String toCSV() {
		String texto = "";
		for (Cliente cliente : clientes) {
			texto += cliente.getCodigo() + SEPARADOR + cliente.getNome() + SEPARADOR + cliente.getTelefone()
					+ QUEBRADELINHA;
		}
		return texto;
	}

	@Override
	public String toString() {
		return "clienteService [clientes=" + clientes + "]";
	}
}
