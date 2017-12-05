package br.com.servicemanager.enumeration;

public enum Severidade {
	
	ALTA("1 - Alta"), 
	MODERADA("2 - Moderada"), 
	BAIXA("3 - Baixa");
	private String descricao = null;
	
	private Severidade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getFonte() {
		return this.descricao;
	}
	
	public static String[] retornarSeveridade() {
		String vet[] = new String[Severidade.values().length];
		int i = 0;
		for (Severidade op : Severidade.values()) {
			vet[i] = op.getFonte();
			i++;
		}
		return vet;
	}

}
