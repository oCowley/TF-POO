import java.util.Optional;

public class App {
    public static void main(String[] args) throws Exception {
        DepositoService depositoService = new DepositoService();
        ClienteService clienteService = new ClienteService();
        ItemService itemService = new ItemService(clienteService, depositoService);

        depositoService.cadastroDeposito(1, "Depósito 1", "Cidade A", "Endereço 1", 50);
        depositoService.cadastroDeposito(2, "Depósito 2", "Cidade B", "Endereço 2", 100);

        clienteService.cadastroCliente("1A", "Cliente 1", "999999999");
        clienteService.cadastroCliente("2B", "Cliente 2", "888888888");

        itemService.cadastroItem("001", "Item 1", "Durável", clienteService.getClienteByCodigo("1A").get(), 20, 200.0, EnumaracaoSituacao.PENDENTE);
        itemService.cadastroItem("002", "Item 2", "Perecível", clienteService.getClienteByCodigo("2B").get(), 70, 300.0, EnumaracaoSituacao.PENDENTE);

        itemService.organizarItens();

        itemService.consultarItens();

        
        try {
            itemService.alterarSituacao("001", EnumaracaoSituacao.RETIRADO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
