package ManipulateFiles;

import java.io.File;
import java.util.Scanner;
import Client.Intpos;

public class Search {

	File file = null; // new File("C:\\Client\\Resp\\Intpos.001");
	Scanner sc = null;// new Scanner(file);
	Intpos i = null;

	public Search(String diretorio, Intpos intpos) {
		try {
			this.file = new File(diretorio);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		this.i = intpos;
	}

	public void leArquivo() {
		try {
			sc = new Scanner(file);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		buscaInf();
	}

	public void buscaInf() {
		String parametro = null;
		String conteudo = null;
		while (sc.hasNextLine()) {
			conteudo = sc.nextLine();
			System.out.println(conteudo);
			parametro = conteudo.substring(0, 7);
			switch (parametro) {

			case "003-000":
				i.setValor(conteudo.substring(10, 15));
				break;

			case "027-000":
				i.setFinalizacao(conteudo.substring(10, 40));
				break;

			case "012-000":
				i.setNsu(conteudo.substring(10, 19));
				break;
			}
		}

	}



}
