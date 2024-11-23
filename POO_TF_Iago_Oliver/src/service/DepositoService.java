package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import bean.Deposito;

public class DepositoService {
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

	@Override
	public String toString() {
		return "DepositoService [depositos=" + depositos + "]";
	}

}
