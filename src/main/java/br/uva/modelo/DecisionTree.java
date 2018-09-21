package br.uva.modelo;

import org.springframework.stereotype.Service;

@Service
public class DecisionTree {

	public class Node {

		private int nodeID;
		private String info = null;
		private Node yesBranch = null;
		private Node noBranch = null;

		public Node(int novoNodeID, String novaInfo) {
			nodeID = novoNodeID;
			info = novaInfo;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
		
	}

	Node nodeRaiz = null;
	
	public Node getNodeRaiz() {
		return nodeRaiz;
	}

	public DecisionTree() {
	}

	public void criarRaiz(int novoNodeID, String novaPerguntaOuResposta) {
		nodeRaiz = new Node(novoNodeID, novaPerguntaOuResposta);
		System.out.println("Criado Node Raiz " + novoNodeID);
	}

	public void addYesNode(int NodeIDExistente, int novoNodeID, String novaPerguntaOuResposta) {

		if (nodeRaiz == null) {
			System.out.println("ERROR: No root node!");
			return;
		}

		// Procura arvore
		searchTreeAndAddYesNode(nodeRaiz, NodeIDExistente, novoNodeID, novaPerguntaOuResposta);
	}

	private boolean searchTreeAndAddYesNode(Node nodeAtual, int NodeIDExistente, int novoNodeID,
			String novaPerguntaOuResposta) {
		if (nodeAtual.nodeID == NodeIDExistente) {
			// Found node
			if (nodeAtual.yesBranch == null) {
				nodeAtual.yesBranch = new Node(novoNodeID, novaPerguntaOuResposta);
			} else {
				System.out.println("WARNING: Overwriting previous node " + "(id = " + nodeAtual.yesBranch.nodeID
						+ ") linked to yes branch of node " + NodeIDExistente);
				nodeAtual.yesBranch = new Node(novoNodeID, novaPerguntaOuResposta);
			}
			return (true);
		} else {
			if (nodeAtual.yesBranch != null) {
				if (searchTreeAndAddYesNode(nodeAtual.yesBranch, NodeIDExistente, novoNodeID, novaPerguntaOuResposta)) {
					return (true);
				} else {
					if (nodeAtual.noBranch != null) {
						return (searchTreeAndAddYesNode(nodeAtual.noBranch, NodeIDExistente, novoNodeID,
								novaPerguntaOuResposta));
					} else
						return (false); 
				}
			}
			return (false); 
		}
	}

	public void addNoNode(int NodeIDExistente, int novoNodeID, String novaPerguntaOuResposta) {

		if (nodeRaiz == null) {
			System.out.println("ERROR: No root node!");
			return;
		}

		// Procura arvore
		searchTreeAndAddNoNode(nodeRaiz, NodeIDExistente, novoNodeID, novaPerguntaOuResposta);
	}

	private boolean searchTreeAndAddNoNode(Node nodeAtual, int NodeIDExistente, int novoNodeID,
			String novaPerguntaOuResposta) {
		if (nodeAtual.nodeID == NodeIDExistente) {
			if (nodeAtual.noBranch == null) {
				nodeAtual.noBranch = new Node(novoNodeID, novaPerguntaOuResposta);
			} else {
				System.out.println("WARNING: Overwriting previous node " + "(id = " + nodeAtual.noBranch.nodeID
						+ ") linked to yes branch of node " + NodeIDExistente);
				nodeAtual.noBranch = new Node(novoNodeID, novaPerguntaOuResposta);
			}
			return (true);
		} else {
			if (nodeAtual.yesBranch != null) {
				if (searchTreeAndAddNoNode(nodeAtual.yesBranch, NodeIDExistente, novoNodeID, novaPerguntaOuResposta)) {
					return (true);
				} else {
					if (nodeAtual.noBranch != null) {
						return (searchTreeAndAddNoNode(nodeAtual.noBranch, NodeIDExistente, novoNodeID,
								novaPerguntaOuResposta));
					} else
						return (false);
				}
			} else
				return (false); 
		}
	}

	public boolean verificaSeEhFolha(Node nodeAtual) {
		if (nodeAtual.yesBranch == null) {
			if (nodeAtual.noBranch == null)
				System.out.println(nodeAtual.info);
				return true;
		}
		return false;
	}

	public Node escutandoResposta(Node nodeAtual, boolean resposta) {
		if (resposta) {
			return nodeAtual.yesBranch;
		} else {
			return nodeAtual.noBranch;
		}
	}

}
