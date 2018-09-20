package br.uva.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {

	File file = null;
	BufferedReader conteudoCSV = null;

	ArrayList<String> perguntas = new ArrayList<String>();
	ArrayList<String[]> respostas = new ArrayList<String[]>();

	Map<String, String> mapPerguntaResposta = new HashMap<String, String>();
	
//	public Map<String, String> mapearPerguntasERespostas() {
//		
//		
////		for (int i = 0; i < lista.size(); i++) {
////			for (int j = 0; j < lista.get(i).length; j++) {
////				System.out.println(lista.get(i)[j]);
////			}
////		}
//		
//		
//		return mapPerguntaResposta;
//	}

	public ArrayList<String[]> lerArquivo() {
		
		URL resource = getClass().getResource("/file/regrasDeProducao.csv");
		
		String linha = "";
		String separadorDeCampo = ";";
		
		try {

			file = new File(resource.toURI());
			
			conteudoCSV = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1252"));

			linha = conteudoCSV.readLine();
			String[] titulos = linha.split(separadorDeCampo);

			for (int i = 0; i < titulos.length; i++) {
				perguntas.add(titulos[i]);
			}

			while ((linha = conteudoCSV.readLine()) != null) {
				String[] campos = linha.split(separadorDeCampo);
				respostas.add(campos);
			}

		} catch (IOException | URISyntaxException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conteudoCSV.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return respostas;

	}
}
