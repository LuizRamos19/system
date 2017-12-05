package br.com.servicemanager.enumeration;

public enum Impacto {
	
	LOCALIDADE("1 - Toda a localidade"), 
	DEPARTAMENTO("2 - Apenas um departamento"), 
	USUARIOS("3 - Vários funcionários"),
	PESSOAL("4 - Um funcionário");
	private String descricao = null;
	
	private Impacto(String descricao) {
		this.descricao = descricao;
	}
	
	public String getFonte() {
		return this.descricao;
	}
	
	public static String[] retornarImpacto() {
		String vet[] = new String[Impacto.values().length];
		int i = 0;
		for (Impacto op : Impacto.values()) {
			vet[i] = op.getFonte();
			i++;
		}
		return vet;
	}

}
