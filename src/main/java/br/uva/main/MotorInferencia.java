package br.uva.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import br.uva.modelo.DecisionTree;

@Service
public class MotorInferencia {

	static DecisionTree newTree;

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {

		newTree = new DecisionTree();

		generateTree();

//		System.out.println("\nOUTPUT DECISION TREE");
//		System.out.println("====================");
//		newTree.outputBinTree();

		try {
			queryTree();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void queryTree() throws IOException {
		System.out.println("\nQUERY DECISION TREE");
		System.out.println("===================");
		newTree.queryBinTree();

		// Option to exit

		optionToExit();
	}

	static void generateTree() {
		System.out.println("\nGENERATE DECISION TREE\n");

		newTree.criarRaiz(1, "É comestível?");
		newTree.addYesNode(1, 2, "Tem Acidez ?");
		newTree.addNoNode(1, 3, "É um eletrônico ?");
		newTree.addYesNode(2, 4, "Tem casca verde ?");
		newTree.addNoNode(2, 5, "É composto por muita água ?");
		newTree.addYesNode(3, 6, "É portátil ?");
		newTree.addNoNode(3, 7, "É um móvel");
		newTree.addYesNode(4, 8, "É usado para fazer vinho ?");
		newTree.addNoNode(4, 9, "Precisa descascar para comer ?");
		newTree.addYesNode(5, 10, "Possui polpa vermelha ?");
		newTree.addNoNode(5, 11, "Tem formato Arredondado ?");
		newTree.addYesNode(6, 12, "Toca música ?");
		newTree.addNoNode(6, 13, "Processa dados ?");
		newTree.addYesNode(7, 14, "É usado para guardar ou apoiar objetos ?");
		newTree.addNoNode(7, 15, "É material escolar ?");
		newTree.addYesNode(8, 16, "Uva verde");
		newTree.addNoNode(8, 17, "É usado para temperar comida ?");
		newTree.addYesNode(9, 18, "Possui muitas sementes ?");
		newTree.addNoNode(9, 19, "É vermelho ?");
		newTree.addYesNode(10, 20, "Melancia");
		newTree.addNoNode(10, 21, "Melão");
		newTree.addYesNode(11, 22, "É bem pequeno ?");
		newTree.addNoNode(11, 23, "Tem muitas calorias ?");
		newTree.addYesNode(12, 24, "Faz ligações ?");
		newTree.addNoNode(12, 25, "Lanterna");
		newTree.addYesNode(13, 26, "Computador");
		newTree.addNoNode(13, 27, "Televisão");
		newTree.addYesNode(14, 28, "É usado em um jantar ?");
		newTree.addNoNode(14, 29, "É usado para dormir ?");
		newTree.addYesNode(15, 30, "É composto de papel ?");
		newTree.addNoNode(15, 31, "É acessório pessoal ?");
		newTree.addYesNode(17, 34, "Limão");
		newTree.addNoNode(17, 35, "Possui polpa vermelha ?");
		newTree.addYesNode(18, 36, "É coberto por pelos ?");
		newTree.addNoNode(18, 37, "Possui cor laranja ?");
		newTree.addYesNode(19, 38, "Possui apenas um caroço ?");
		newTree.addNoNode(19, 39, "Possui castanha ?");
		newTree.addYesNode(22, 44, "Açaí");
		newTree.addNoNode(22, 45, "Armazena água no seu interior ?");
		newTree.addYesNode(23, 46, "Possui seiva grudenta ?");
		newTree.addNoNode(23, 47, "É o alimento de um macaco ?");
		newTree.addYesNode(24, 48, "Celular");
		newTree.addNoNode(24, 49, "Rádio");
		newTree.addYesNode(28, 56, "Mesa");
		newTree.addNoNode(28, 57, "É usado para guardar roupas ?");
		newTree.addYesNode(29, 58, "Cama");
		newTree.addNoNode(29, 59, "Cadeira");
		newTree.addYesNode(30, 60, "É usado para fazer anotações ?");
		newTree.addNoNode(30, 61, "Cabe na palma da sua mão ?");
		newTree.addYesNode(31, 62, "É usado no pé ?");
		newTree.addNoNode(31, 63, "É um utensílio ?");
		newTree.addYesNode(35, 70, "Goiaba");
		newTree.addNoNode(35, 71, "Pêra");
		newTree.addYesNode(36, 72, "Kiwi");
		newTree.addNoNode(36, 73, "Tem finalidade medicinal ?");
		newTree.addYesNode(37, 74, "É fácil de descascar ?");
		newTree.addNoNode(37, 75, "Possui coroa ?");
		newTree.addYesNode(38, 76, "Cereja");
		newTree.addNoNode(38, 77, "Possui pequenas folhas em cima ?");
		newTree.addYesNode(39, 78, "Caju");
		newTree.addNoNode(39, 79, "Carambola");
		newTree.addYesNode(45, 90, "Coco");
		newTree.addNoNode(45, 91, "Caqui");
		newTree.addYesNode(46, 92, "Jaca");
		newTree.addNoNode(46, 93, "Abacate");
		newTree.addYesNode(47, 94, "Banana");
		newTree.addNoNode(47, 95, "Mamão");
		newTree.addYesNode(57, 114, "Armário");
		newTree.addNoNode(57, 115, "Estante");
		newTree.addYesNode(60, 120, "Caderno");
		newTree.addNoNode(60, 121, "Livro");
		newTree.addYesNode(61, 122, "Caneta");
		newTree.addNoNode(61, 123, "Mochila");
		newTree.addYesNode(62, 124, "Ajuda a se aquecer ?");
		newTree.addNoNode(62, 125, "É usado para guardar dinheiro ?");
		newTree.addYesNode(63, 126, "Pode ser de plástico ?");
		newTree.addNoNode(63, 127, "Necessita de energia ?");
		newTree.addYesNode(73, 146, "Romã");
		newTree.addNoNode(73, 147, "Maracujá");
		newTree.addYesNode(74, 148, "Tangerina");
		newTree.addNoNode(74, 149, "Laranja");
		newTree.addYesNode(75, 150, "Abacaxi");
		newTree.addNoNode(75, 151, "Manga");
		newTree.addYesNode(77, 154, "Morango");
		newTree.addNoNode(77, 155, "Maçã");
		newTree.addYesNode(124, 248, "Meia");
		newTree.addNoNode(124, 249, "Chinelo");
		newTree.addYesNode(125, 250, "Carteira");
		newTree.addNoNode(125, 251, "Brinco");
		newTree.addYesNode(126, 252, "É usado para limpeza ?");
		newTree.addNoNode(126, 253, "Martelo");
		newTree.addYesNode(127, 254, "Pode ser portátil ?");
		newTree.addNoNode(127, 255, "Bola");
		newTree.addYesNode(252, 504, "Vassoura");
		newTree.addNoNode(252, 505, "É usado para armazenar líquidos ?");
		newTree.addYesNode(254, 508, "Ventilador");
		newTree.addNoNode(254, 509, "Geladeira");
		newTree.addYesNode(505, 1010, "Garrafa");
		newTree.addNoNode(505, 1011, "Garfo");
	}

	static void optionToExit() throws IOException {
		System.out.println("Exit? (enter \"Yes\" or \"No\")");
		String answer = keyboardInput.readLine();
		if (answer.equals("Yes"))
			return;
		else {
			if (answer.equals("No"))
				queryTree();
			else {
				System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
				optionToExit();
			}
		}
	}
}
