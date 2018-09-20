package br.uva.main;

public class Teste {

	public static void main(String[] args) {

		Node tree = null; 
		tree = Node.inserir(tree, "É comestivel ?", "sim");
		tree.inserir(tree, "É Laranja ?", "nao");
		tree.inserir(tree, "facil descascar", "sim");
		tree.inserir(tree, "é azul ?", "nao");
		tree.inserir(tree, "", "Laranja");
		
		System.out.println(tree.getPergunta());
		System.out.println(tree.getResposta());
//		
//		System.out.println(tree.getSim().getPergunta());
//		System.out.println(tree.getSim().getResposta());
		
		System.out.println(tree.getNao().getPergunta());
		System.out.println(tree.getNao().getResposta());
		
		System.out.println(tree.getSim().getSim().getPergunta());
		System.out.println(tree.getSim().getSim().getResposta());
		
		System.out.println(tree.getSim().getSim().getNao().getPergunta());
		System.out.println(tree.getSim().getSim().getNao().getResposta());
		
	}

}
