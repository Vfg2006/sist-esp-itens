package br.uva.modelo;

public class Atributo {

	private String pergunta;
	private boolean resposta;
	private String resultadoFinal;
	
	public Atributo(String newPergunta) {
		this.pergunta = newPergunta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = "O item " + pergunta.toLowerCase();
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}
	
	public String getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(String resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	@Override
	public String toString() {
		return "Pergunta: " + this.pergunta + "\n" + "Resposta: " + this.resposta;
	}
}
