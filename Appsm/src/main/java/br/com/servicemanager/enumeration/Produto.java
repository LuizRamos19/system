package br.com.servicemanager.enumeration;

public enum Produto {
	HWD("Hardware-Desktop"), 
	HWL("Hardware-Laptop"), 
	HWT("Telephony"),
	HWM("MobilePhone"),
	HWB("Bitlocker"),
	SWO("MS Office"),
	SWP("Software Produtivo"),
	SWW("Windows 7"),
	SWS("Windows 10"),
	NWL("Rede LAN"),
	NWW("Rede WAN"),
	NWP("Senha bloqueada/reset"),
	NWS("Servidor indisponível/lentidão"),
	SAP("SAP"),
	PRT("Impressora com erro"),
	PRP("Impressora sem papel");
	
	private String descricao = null;
	
	private Produto(String descricao) {
		this.descricao = descricao;
	}
	
	public String getProduto() {
		return this.descricao;
	}
	
	public static String[] retornarProduto() {
		String vet[] = new String[Produto.values().length];
		int i = 0;
		for (Produto op : Produto.values()) {
			vet[i] = op.getProduto();
			i++;
		}
		return vet;
	}
}