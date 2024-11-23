package bean;

public enum EnumaracaoSituacao {
	PENDENTE("PENDENTE"), 
	ARMAZENADO("ARMAZENADO"), 
	CANCELADO("CANCELADO"), 
	RETIRADO("RETIRADO");
	
	
	private final String nome;       

    private EnumaracaoSituacao(String s) {
        nome = s;
    }
    
}
