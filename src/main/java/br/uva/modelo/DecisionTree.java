package br.uva.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

//	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
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

	/* ADD YES NODE */

	public void addYesNode(int NodeIDExistente, int novoNodeID, String novaPerguntaOuResposta) {
		// If no root node do nothing

		if (nodeRaiz == null) {
			System.out.println("ERROR: No root node!");
			return;
		}

		// Search tree

		if (searchTreeAndAddYesNode(nodeRaiz, NodeIDExistente, novoNodeID, novaPerguntaOuResposta)) {
			System.out.println("Added node " + novoNodeID + " onto \"yes\" branch of node " + NodeIDExistente);
		} else
			System.out.println("Node " + NodeIDExistente + " não encontrado");
	}

	/* SEARCH TREE AND ADD YES NODE */

	private boolean searchTreeAndAddYesNode(Node nodeAtual, int NodeIDExistente, int novoNodeID,
			String novaPerguntaOuResposta) {
		if (nodeAtual.nodeID == NodeIDExistente) {
			// Found node
			if (nodeAtual.yesBranch == null)
				nodeAtual.yesBranch = new Node(novoNodeID, novaPerguntaOuResposta);
			else {
				System.out.println("WARNING: Overwriting previous node " + "(id = " + nodeAtual.yesBranch.nodeID
						+ ") linked to yes branch of node " + NodeIDExistente);
				nodeAtual.yesBranch = new Node(novoNodeID, novaPerguntaOuResposta);
			}
			return (true);
		} else {
			// Try yes branch if it exists
			if (nodeAtual.yesBranch != null) {
				if (searchTreeAndAddYesNode(nodeAtual.yesBranch, NodeIDExistente, novoNodeID, novaPerguntaOuResposta)) {
					return (true);
				} else {
					// Try no branch if it exists
					if (nodeAtual.noBranch != null) {
						return (searchTreeAndAddYesNode(nodeAtual.noBranch, NodeIDExistente, novoNodeID,
								novaPerguntaOuResposta));
					} else
						return (false); // Not found here
				}
			}
			return (false); // Not found here
		}
	}

	/* ADD NO NODE */

	public void addNoNode(int NodeIDExistente, int novoNodeID, String novaPerguntaOuResposta) {
		// If no root node do nothing

		if (nodeRaiz == null) {
			System.out.println("ERROR: No root node!");
			return;
		}

		// Search tree

		if (searchTreeAndAddNoNode(nodeRaiz, NodeIDExistente, novoNodeID, novaPerguntaOuResposta)) {
			System.out.println("Added node " + novoNodeID + " onto \"no\" branch of node " + NodeIDExistente);
		} else
			System.out.println("Node " + NodeIDExistente + " não encontrado");
	}

	/* SEARCH TREE AND ADD NO NODE */

	private boolean searchTreeAndAddNoNode(Node nodeAtual, int NodeIDExistente, int novoNodeID,
			String novaPerguntaOuResposta) {
		if (nodeAtual.nodeID == NodeIDExistente) {
			// Found node
			if (nodeAtual.noBranch == null)
				nodeAtual.noBranch = new Node(novoNodeID, novaPerguntaOuResposta);
			else {
				System.out.println("WARNING: Overwriting previous node " + "(id = " + nodeAtual.noBranch.nodeID
						+ ") linked to yes branch of node " + NodeIDExistente);
				nodeAtual.noBranch = new Node(novoNodeID, novaPerguntaOuResposta);
			}
			return (true);
		} else {
			// Try yes branch if it exists
			if (nodeAtual.yesBranch != null) {
				if (searchTreeAndAddNoNode(nodeAtual.yesBranch, NodeIDExistente, novoNodeID, novaPerguntaOuResposta)) {
					return (true);
				} else {
					// Try no branch if it exists
					if (nodeAtual.noBranch != null) {
						return (searchTreeAndAddNoNode(nodeAtual.noBranch, NodeIDExistente, novoNodeID,
								novaPerguntaOuResposta));
					} else
						return (false); // Not found here
				}
			} else
				return (false); // Not found here
		}
	}

	/* --------------------------------------------- */
	/*                                               */
	/* TREE QUERY METHODS */
	/*                                               */
	/* --------------------------------------------- */

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

	/* ----------------------------------------------- */
	/*                                                 */
	/* TREE OUTPUT METHODS */
	/*                                                 */
	/* ----------------------------------------------- */

	/* OUTPUT BIN TREE */

//	public void outputBinTree() {
//
//		outputBinTree("1", rootNode);
//	}
//
//	private void outputBinTree(String tag, BinTree nodeAtual) {
//
//		// Check for empty node
//
//		if (nodeAtual == null)
//			return;
//
//		// Output
//
//		System.out.println(
//				"[" + tag + "] nodeID = " + nodeAtual.nodeID + ", question/answer = " + nodeAtual.questOrAns);
//
//		// Go down yes branch
//
//		outputBinTree(tag + ".1", nodeAtual.yesBranch);
//
//		// Go down no branch
//
//		outputBinTree(tag + ".2", nodeAtual.noBranch);
//	}

}
