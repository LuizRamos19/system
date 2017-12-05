package br.com.servicemanager.enumeration;

public enum Solucao {

	RESOLVED("Resolvido"), 
	SOLVED("Sem ação"), 
	ASSIGN("Direcionado"), 
	PENDING("Pendente");
	
	private String descricao = null;

	private Solucao(String descricao) {
			this.descricao = descricao;
		}

	public String getSolucaoEnum() {
		return this.descricao;
	}

	public static String[] retornarSolucaoEnum() {
		String vet[] = new String[Solucao.values().length];
		int i = 0;
		for (Solucao op : Solucao.values()) {
			vet[i] = op.getSolucaoEnum();
			i++;
		}
		return vet;
	}

}
