package br.uva.modelo;

public class PerguntaResposta {

	private String pergunta;
	private boolean resposta;
	
	public PerguntaResposta(String newPergunta) {
		this.pergunta = newPergunta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	@Override
	public String toString() {
		return "Pergunta: " + this.pergunta + "\n" + "Resposta: " + this.resposta;
	}
}
