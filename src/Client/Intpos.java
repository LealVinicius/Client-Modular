package Client;

public class Intpos {
	private String id;
	private String codFuncao;
	private String header;
	private String identificacao;
	private String registroFinal;
	private String valor;
	private String moeda;
	private String nsu;
	private String finalizacao;
	private String CNPJ;
	private String infoLivre;
	
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInfoLivre() {
		return infoLivre;
	}
	public void setInfoLivre(String infoLivre) {
		this.infoLivre = infoLivre;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getFinalizacao() {
		return finalizacao;
	}
	public void setFinalizacao(String finalizacao) {
		this.finalizacao = finalizacao;
	}
	public String getValor() {
		System.out.println("valor = " + this.valor);
		return valor;
		
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getMoeda() {
		return moeda;
	}
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	public String getNsu() {
		return nsu;
	}
	public void setNsu(String nsu) {
		this.nsu = nsu;
	}
	public String getCodFuncao() {
		return codFuncao;
	}
	public void setCodFuncao(String codFuncao) {
		this.codFuncao = codFuncao;
	}
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public String getRegistroFinal() {
		return registroFinal;
	}
	public void setRegistroFinal(String registro) {
		this.registroFinal = registro;
	}
	
	
	
	
}
