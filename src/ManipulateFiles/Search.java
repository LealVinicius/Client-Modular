package ManipulateFiles;

import java.io.File;
import java.util.Scanner;

import Client.Intpos;

public class Search {

	File file = null; // new File("C:\\Client\\Resp\\Intpos.001");
	Scanner sc = null;// new Scanner(file);
	Intpos i = null;

	// Lê diretório do arquivo e joga na variável file.
	// instancia o Intpos e chama leArquivo();
	public Search(String diretorio, Intpos intpos) {
		try {
			this.file = new File(diretorio);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		this.i = intpos;
		LeArquivo();
	}

	public void leResp() {
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}

	// joga o arquivo no Scanner
	public void LeArquivo() {

		try {
			sc = new Scanner(file);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		buscaFinalizacao();
		buscaValor();
	}

	public String buscaNsu(String nsuuu) {
		while (sc.hasNextLine()) {
			String nsu = sc.nextLine();
			if (nsu.substring(0, 7).contentEquals("012-000")) {
				String nsuu = nsu.substring(10, 19);
				i.setNsu(nsu);
				
			} 
		}
		return nsuuu;
	}

	public void buscaFinalizacao() {
		while (sc.hasNextLine()) {
			String iden = sc.nextLine();
			// System.out.println(iden);
			if (iden.substring(0, 7).equals("027-000")) {
				String code = iden.substring(10, 40);
				i.setFinalizacao(code);
			}
		}

		// System.out.println("027: " + i.getFinalizacao());

	}

	public void buscaValor() {
		System.out.println("Entrou no método buscaValor sem while");
		while (sc.hasNextLine()) {
			System.out.println("Valor no método buscaValor: ");
			String valor = sc.nextLine();
			System.out.println("antes do if. Valor: " + valor);
			if (valor.substring(0, 7).equals("003-000")) {
				String FinalValue = valor.substring(10, 16);

				i.setValor(FinalValue);
				System.out.println(FinalValue);
			}

		}
	}

}