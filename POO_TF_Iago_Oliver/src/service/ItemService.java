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
import bean.EnumaracaoSituacao;
import bean.Item;

public class ItemService {
	private static final String SEPARADOR = ";";
	private static final String QUEBRADELINHA = "\n";
	private static final String ITENS_CSV = "Itens.csv";
	private ClienteService c;
	ArrayList<Item> items = new ArrayList<Item>();

	public ItemService(ClienteService cS) {
		this.c = cS;
		this.items = new ArrayList<Item>();
	}

	public void cadastroItem(String codigo, String descricao, String categoria, Cliente cliente, double volume,
			double valorDeclarado, EnumaracaoSituacao situacao) throws Exception {
		if (getItemByCodigo(codigo).isPresent()) {
			throw new Exception("item " + codigo + " já existe!!!");
		}
		Item novoItem = new Item(codigo, descricao, categoria, cliente, volume, valorDeclarado, situacao);
		items.add(novoItem);
		ordenaItems();
		System.out.println("Item " + codigo + " Cadastrado");
		System.out.println(toString());
	}

	public void ordenaItems() {
		Collections.sort(items, Comparator.comparing(Item::getCodigo));
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public Optional<Item> getItemByCodigo(String codigo) {
		return this.items.stream().filter(i -> i.getCodigo().equals(codigo)).findFirst();
	}

	public void salvar() {
		System.out.println("salvando item...");
		FileWriter arq = null;
		try {
			arq = new FileWriter(ITENS_CSV);
			PrintWriter gravararq = new PrintWriter(arq);
			gravararq.print(toCSV());
			arq.close();
		} catch (Exception e) {
			System.err.format("Erro de E/S: %s%n", e);
		}

	}

	public void carregar() {
		System.out.println("carregado item...");
		try {
			FileReader f = new FileReader(ITENS_CSV);
			// Scanner é responsável por ler
			Scanner arquivolido = new Scanner(f);
			// mostra o delimitador
			arquivolido.useDelimiter(QUEBRADELINHA);
			// pega o proximo texto entre um ; e outro
			String valorlido = "";
			// le o arquivo considerando os delimitadores
			this.items = new ArrayList<Item>();
			while (arquivolido.hasNext()) {
				valorlido = arquivolido.next();
				String[] valor = valorlido.split(SEPARADOR);
				cadastroItem(valor[0], valor[1], valor[2], c.getClienteByCodigo(valor[3]).get(),
						Double.parseDouble(valor[4]), Double.parseDouble(valor[5]),
						EnumaracaoSituacao.valueOf(valor[6]));
			}
		} catch (Exception e) {
			System.err.format("Erro de E/S: %s%n", e);
		}

	}

	public String toCSV() {
		String texto = "";
		for (Item item : items) {
			texto += item.getCodigo() + SEPARADOR + item.getDescricao() + SEPARADOR + item.getCategoria() + SEPARADOR
					+ item.getCliente().getCodigo() + SEPARADOR + item.getVolume() + SEPARADOR
					+ item.getValorDeclarado() + SEPARADOR + item.getSituacao() + QUEBRADELINHA;
		}
		return texto;
	}

	@Override
	public String toString() {
		return "itemService [items=" + items + "]";
	}
}
