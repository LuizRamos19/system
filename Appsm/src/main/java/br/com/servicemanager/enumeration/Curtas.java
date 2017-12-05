package br.com.servicemanager.enumeration;

public enum Curtas {
	ENGANO("Engano"), 
	QUEDA("Queda de ligação"), 
	CONSULTA("Consulta de chamado"),
	TRANSFER("Transferência de ligação");
	
	private String descricao = null;
	
	private Curtas(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCurtas() {
		return this.descricao;
	}
	
	public static String[] retornarCurtas() {
		String vet[] = new String[Curtas.values().length];
		int i = 0;
		for (Curtas op : Curtas.values()) {
			vet[i] = op.getCurtas();
			i++;
		}
		return vet;
	}
}