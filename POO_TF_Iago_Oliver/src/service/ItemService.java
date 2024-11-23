package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import bean.Cliente;
import bean.EnumaracaoSituacao;
import bean.Item;

public class ItemService {
	ArrayList<Item> items = new ArrayList<Item>();

	public ItemService() {
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

	@Override
	public String toString() {
		return "itemService [items=" + items + "]";
	}
}
