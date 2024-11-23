package bean;

import service.ClienteService;
import service.DepositoService;
import service.ItemService;

public class App {

	public static void main(String[] args) {
		DepositoService dep = new DepositoService();
		
		dep.cadastroDeposito(3, "PETER", "Canoas", "rua 12 de Outubro, 22", 30);
		dep.cadastroDeposito(2, "JOMES", "Pelotas", "rua jundiai, 2003", 100);
		dep.cadastroDeposito(1, "HOMMES", "Porto", "rua amadeus sho, 33", 20);
		System.out.println("------------------");
		ClienteService c = new ClienteService();
		c.cadastroCliente("2B", "Jorge", "5555555555");
		c.cadastroCliente("1A", "Adalirio", "3434334343");
		System.out.println("------------------");
		ItemService i = new ItemService();
		i.cadastroItem("2", "uma jabulane", "Dur�vel", c.getClienteByCodigo("1A").get(), 1, 30, EnumaracaoSituacao.ARMAZENADO);
		i.cadastroItem("1", "Banana", "Perec��vel", c.getClienteByCodigo("2B").get(), 1, 10, EnumaracaoSituacao.PENDENTE);


	}
	

}
