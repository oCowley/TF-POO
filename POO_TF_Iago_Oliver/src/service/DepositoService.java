package service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import bean.Deposito;

public class DepositoService {
	private static final String QUEBRADELINHA = "\n";
	private static final String SEPARADOR = ";";
	private static final String DEPOSITOS_CSV = "Depositos.csv";
	ArrayList<Deposito> depositos = new ArrayList<Deposito>();

	public DepositoService() {
		this.depositos = new ArrayList<Deposito>();
	}

	public void cadastroDeposito(int codigo, String nome, String cidade, String endereco, int capacidadeMax) {

		Deposito novoDeposito = new Deposito(codigo, nome, cidade, endereco, capacidadeMax);
		depositos.add(novoDeposito);
		ordenaDepositos();
		System.out.println("Deposito " + codigo + " Cadastrado");
		System.out.println(toString());
	}

	public void ordenaDepositos() {
		Collections.sort(depositos, Comparator.comparingInt(Deposito::getCodigo));
	}

	public ArrayList<Deposito> getDepositos() {
		return depositos;
	}

	public void salvar() {
		System.out.println("salvando deposito...");
		FileWriter arq = null;
		try {
			arq = new FileWriter(DEPOSITOS_CSV);
			PrintWriter gravararq = new PrintWriter(arq);
			gravararq.print(toCSV());
			arq.close();
		} catch (Exception e) {
			System.err.format("Erro de E/S: %s%n", e);
		}

	}

	public void carregar() {
		System.out.println("carregado deposito...");
		try {
			FileReader f = new FileReader(DEPOSITOS_CSV);
			// Scanner é responsável por ler
			Scanner arquivolido = new Scanner(f);
			// mostra o delimitador
			arquivolido.useDelimiter(QUEBRADELINHA);
			// pega o proximo texto entre um ; e outro
			String valorlido = "";
			// le o arquivo considerando os delimitadores
			this.depositos = new ArrayList<Deposito>();
			while (arquivolido.hasNext()) {
				valorlido = arquivolido.next();
				String[] valor = valorlido.split(SEPARADOR);
				cadastroDeposito(Integer.parseInt(valor[0]), valor[1], valor[2], valor[3], Integer.parseInt(valor[4]));
			}
		} catch (Exception e) {
			System.err.format("Erro de E/S: %s%n", e);
		}

	}

	public String toCSV() {
		String texto = "";
		for (Deposito deposito : depositos) {
			texto += deposito.getCodigo() + SEPARADOR + deposito.getNome() + SEPARADOR + deposito.getCidade() + SEPARADOR
					+ deposito.getEndereco() + SEPARADOR + deposito.getCapacidadeMax() + QUEBRADELINHA;
		}
		return texto;
	}

	@Override
	public String toString() {
		return "DepositoService [depositos=" + depositos + "]";
	}

}
