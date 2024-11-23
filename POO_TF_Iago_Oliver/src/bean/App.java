package bean;

import service.ClienteService;
import service.DepositoService;
import service.ItemService;

public class App {

	public static void main(String[] args) throws Exception {
		DepositoService dep = new DepositoService();

		dep.cadastroDeposito(3, "PETER", "Canoas", "rua 12 de Outubro, 22", 30);
		dep.cadastroDeposito(2, "JOMES", "Pelotas", "rua jundiai, 2003", 100);
		dep.cadastroDeposito(1, "HOMMES", "Porto", "rua amadeus sho, 33", 20);
		System.out.println("------------------");
		ClienteService c = new ClienteService();
		c.cadastroCliente("2B", "Jorge", "5555555555");
		c.cadastroCliente("1A", "Adalirio", "3434334343");
		System.out.println("------------------");
		ItemService i = new ItemService(c);
		try {
			i.cadastroItem("2", "uma jabulane", "Durável", c.getClienteByCodigo("1A").get(), 1, 30,
					EnumaracaoSituacao.ARMAZENADO);
			i.cadastroItem("1", "Banana", "Perecível", c.getClienteByCodigo("2B").get(), 1, 10,
					EnumaracaoSituacao.PENDENTE);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("------------------");
		System.out.println("------------------");
		// dep.salvar();
		dep.carregar();
		System.out.println("++++++++++++++++++");
		System.out.println("------------------");
		// c.salvar();
		c.carregar();
		System.out.println("++++++++++++++++++");
		System.out.println("++++++++++++++++++");
		i.salvar();
		i.carregar();
		c.cadastroCliente("5J", "Karlos", "5555655855");
		try {
			i.cadastroItem("22", "Oscar", "Durável", c.getClienteByCodigo("5J").get(), 1, 350,
					EnumaracaoSituacao.ARMAZENADO);
			i.cadastroItem("6", "Maca", "Perecível", c.getClienteByCodigo("5J").get(), 1, 150,
					EnumaracaoSituacao.PENDENTE);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		i.salvar();
		i.carregar();
	}

}
