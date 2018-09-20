package br.uva.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class DecisionTree {

	private class BinTree {

		private int nodeID;
		private String perguntaOuResposta = null;
		private BinTree yesBranch = null;
		private BinTree noBranch = null;

		public BinTree(int novoNodeID, String novaPerguntaOuResposta) {
			nodeID = novoNodeID;
			perguntaOuResposta = novaPerguntaOuResposta;
		}
	}

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
	BinTree nodeRaiz = null;

	public DecisionTree() {
	}

	public void criarRaiz(int novoNodeID, String novaPerguntaOuResposta) {
		nodeRaiz = new BinTree(novoNodeID, novaPerguntaOuResposta);
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

	private boolean searchTreeAndAddYesNode(BinTree nodeAtual, int NodeIDExistente, int novoNodeID, String novaPerguntaOuResposta) {
		if (nodeAtual.nodeID == NodeIDExistente) {
			// Found node
			if (nodeAtual.yesBranch == null)
				nodeAtual.yesBranch = new BinTree(novoNodeID, novaPerguntaOuResposta);
			else {
				System.out.println("WARNING: Overwriting previous node " + "(id = " + nodeAtual.yesBranch.nodeID
						+ ") linked to yes branch of node " + NodeIDExistente);
				nodeAtual.yesBranch = new BinTree(novoNodeID, novaPerguntaOuResposta);
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
						return (searchTreeAndAddYesNode(nodeAtual.noBranch, NodeIDExistente, novoNodeID, novaPerguntaOuResposta));
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

	private boolean searchTreeAndAddNoNode(BinTree nodeAtual, int NodeIDExistente, int novoNodeID, String novaPerguntaOuResposta) {
		if (nodeAtual.nodeID == NodeIDExistente) {
			// Found node
			if (nodeAtual.noBranch == null)
				nodeAtual.noBranch = new BinTree(novoNodeID, novaPerguntaOuResposta);
			else {
				System.out.println("WARNING: Overwriting previous node " + "(id = " + nodeAtual.noBranch.nodeID
						+ ") linked to yes branch of node " + NodeIDExistente);
				nodeAtual.noBranch = new BinTree(novoNodeID, novaPerguntaOuResposta);
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
						return (searchTreeAndAddNoNode(nodeAtual.noBranch, NodeIDExistente, novoNodeID, novaPerguntaOuResposta));
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

	public void queryBinTree() throws IOException {
		queryBinTree(nodeRaiz);
	}

	private void queryBinTree(BinTree nodeAtual) throws IOException {

		// Test for leaf node (answer) and missing branches

		if (nodeAtual.yesBranch == null) {
			if (nodeAtual.noBranch == null)
				System.out.println(nodeAtual.perguntaOuResposta);
			else
				System.out.println(
						"Error: Missing \"Yes\" branch at \"" + nodeAtual.perguntaOuResposta + "\" question");
			return;
		}
		if (nodeAtual.noBranch == null) {
			System.out.println("Error: Missing \"No\" branch at \"" + nodeAtual.perguntaOuResposta + "\" question");
			return;
		}

		// Question

		askQuestion(nodeAtual);
	}

	private void askQuestion(BinTree nodeAtual) throws IOException {
		System.out.println(nodeAtual.perguntaOuResposta + " (enter \"Yes\" or \"No\")");
		String answer = keyboardInput.readLine();

		if (answer.equals("Yes"))
			queryBinTree(nodeAtual.yesBranch);
		else {
			if (answer.equals("No"))
				queryBinTree(nodeAtual.noBranch);
			else {
				System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
				askQuestion(nodeAtual);
			}
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


