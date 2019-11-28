package ManipulateFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import Client.Intpos;

public class WritingInFile {
	public static void main(String[] args) {

		int escolha;
		Intpos i = new Intpos();
		Search search = new Search("C:\\Client\\Resp\\Intpos.001", i);
		i.setHeader("000-000 = ");
		i.setIdentificacao("001-000 = ");
		i.setRegistroFinal("999-999 = 0");
		i.setInfoLivre("565-008 = 1=");
		i.setCNPJ("04988631000111");
		
		try {
			FileWriter writer = new FileWriter("C:\\Client\\Req\\Intpos.tmp", true);
			
			escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
					"\n  Digite 0 para leitura do Resp" + "\n  Digite 1 para Funções adminstrativas  "
							+ "\n  Digite 2 para Pagamento via cartão  " + "\n  Digite 3 para Confirmação  "
							+ "\n  Digite 4 para Não confirmação  " + "\n  Digite 5 para Cancelamento  "));

			if (escolha == 0) {
				search.leArquivo();
			}

			if (escolha == 1) {
				i.setCodFuncao("ADM");
				writer.write(i.getHeader() + i.getCodFuncao());
				writer.write("\n" + i.getIdentificacao() + "1");
				writer.write("\n" + i.getInfoLivre() + i.getCNPJ());
				writer.write("\n" + i.getRegistroFinal() + "\n");
			}
			if (escolha == 2) {
				i.setValor(JOptionPane.showInputDialog(null, "Insira o valor da transação: "));
				i.setCodFuncao("CRT");
				writer.write(i.getHeader() + i.getCodFuncao());
				writer.write("\n" + i.getIdentificacao() + "1");
				writer.write("\n003-000 = " + i.getValor());
				writer.write("\n" + i.getInfoLivre() + i.getCNPJ());
				writer.write("\n" + i.getRegistroFinal() + "\n");
			}
			if (escolha == 3 || escolha == 4) {
				if (escolha == 3) {
					i.setCodFuncao("CNF");
				} else {
					i.setCodFuncao("NCN");
				}
				search.leArquivo();
				writer.write(i.getHeader() + i.getCodFuncao());
				writer.write("\n" + i.getIdentificacao() + "1");
				writer.write("\n003-000 = " + i.getValor());
				writer.write("\n" + i.getInfoLivre() + i.getCNPJ());
				writer.write("\n027-000 = " + i.getFinalizacao());
				writer.write("\n" + i.getRegistroFinal() + "\n");
			}

			if (escolha == 5) {
				i.setCodFuncao("CNC");
				search.leArquivo();
				writer.write(i.getHeader() + i.getCodFuncao());
				writer.write("\n" + i.getIdentificacao() + "1");
				writer.write("\n003-000 = " + i.getValor());
				writer.write("\n" + i.getInfoLivre() + i.getCNPJ());
				writer.write("\n012-000 = " + i.getNsu());
				writer.write("\n999-999 = 0");
			}
			writer.close();
			// Thread.sleep(5000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new File("C:\\Client\\Req\\Intpos.tmp").renameTo(new File("C:\\Client\\Req\\Intpos.001"));
	}



}