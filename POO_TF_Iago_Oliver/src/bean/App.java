package bean;

public class App {

	public static void main(String[] args) {
		Deposito dep1 = new Deposito(2, "JOMES", "Pelotas", "rua jundiai, 2003", 100);
		Deposito dep2 = new Deposito(1, "HOMMES", "Porto", "rua amadeus sho, 33", 20);
		Cliente c1 =  new Cliente("2", "Jorge", "5555555555");
		Cliente c2 =  new Cliente("1", "Jorge", "5555555555");
		Item i1 = new Item("2", "uma jabulane", "Durável", "Jorge", 1, 30, '1');
		Item i2 = new Item("1", "uma jabulane", "Durável", "Jorge", 1, 30, '1');
		
		dep1.CadastroDeposito();
		dep2.CadastroDeposito();
		c1.CadastroCliente();
		c2.CadastroCliente();
		
	
	}
	

}
