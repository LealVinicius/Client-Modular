package ManipulateFiles;

import java.io.File;
import java.util.Scanner;
import Client.Intpos;

public class Search {

	File file = null; 
	Scanner sc = null;
	Intpos i = null;

	public Search(String diretorio, Intpos intpos) {
		try {
			this.file = new File(diretorio);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		this.i = intpos;
	}
	
	public boolean leArquivo() {
		try {
			if(this.file.exists()) {
				sc = new Scanner(file);
				buscaInf();
				file.delete();
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
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
		sc.close();
	}



}
