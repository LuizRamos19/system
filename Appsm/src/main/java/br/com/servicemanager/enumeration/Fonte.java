package br.com.servicemanager.enumeration;

public enum Fonte {
	
	PHONE("Telefone"), 
	EMAIL("E-mail"), 
	CHAT("Chat");
	
	private String descricao = null;
	
	private Fonte(String descricao) {
		this.descricao = descricao;
	}
	
	public String getFonte() {
		return this.descricao;
	}
	
	public static String[] retornarFonte() {
		String vet[] = new String[Fonte.values().length];
		int i = 0;
		for (Fonte op : Fonte.values()) {
			vet[i] = op.getFonte();
			i++;
		}
		return vet;
	}

}
