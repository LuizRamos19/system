package br.com.servicemanager.enumeration;

public enum Filas {
	
	NETWORK("NETWORK-ORANGE"), 
	FIELD("FIELD SERVICES"), 
	SERVICEDESK("SERVICEDESK"),
	SAP("SAP SERVICES"),
	PRINTER("PRINTER SERVICES"),
	MOBILE("MOBILE SERVICES"); 
	private String descricao = null;
	
	private Filas(String descricao) {
		this.descricao = descricao;
	}
	
	public String getFonte() {
		return this.descricao;
	}
	
	public static String[] retornarFila() {
		String vet[] = new String[Filas.values().length];
		int i = 0;
		for (Filas op : Filas.values()) {
			vet[i] = op.getFonte();
			i++;
		}
		return vet;
	}

}
