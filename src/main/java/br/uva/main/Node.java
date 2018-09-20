package br.uva.main;

public class Node {

	private String pergunta;
	private String resposta;
	private Node sim;
	private Node nao;
	
	public Node() {};

	public Node(String pergunta, String resposta, Node sim, Node nao) {
		super();
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.sim = sim;
		this.nao = nao;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Node getSim() {
		return sim;
	}

	public void setSim(Node sim) {
		this.sim = sim;
	}

	public Node getNao() {
		return nao;
	}

	public void setNao(Node nao) {
		this.nao = nao;
	}

	public static Node inserir(Node node, String pergunta, String resposta) {
		if (node == null) {
			node = new Node(pergunta, resposta, null, null);
		} else if (node.getResposta() == "sim") {
			node.setSim(inserir(node.getSim(), pergunta, resposta));
		} else if (node.getResposta() == "nao") {
			node.setNao(inserir(node.getNao(), pergunta, resposta));
		}

		return node;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
