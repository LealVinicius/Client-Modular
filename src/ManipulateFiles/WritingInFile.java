package ManipulateFiles;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import Client.Intpos;

public class WritingInFile {
	
	public static void main(String[] args) {

		
		//A resposta da Resp está exibindo assim que a requisição é feita, estudar uma maneira
		//de como fazê-la aparecer somente após a requisição, informando se deu certo ou não.
		//Pois atualmente, ela está sendo exibida antes de o Client abrir.
		//Reading reading = new Reading();
		Intpos i = new Intpos();
		//Search r = new Search("C:\\Client\\Resp\\Intpos.001", i);
		
		//Verificação se está passando o 027
	
		i.setHeader("000-000 = ");
		i.setIdentificacao("001-000 = " );
		i.setRegistroFinal("999-999 = 0");
		i.setInfoLivre("565-008 = 1=");
		i.setCNPJ("04988631000111");
		

		try {
			FileWriter writer1 = new FileWriter("C:\\Client\\Req\\Intpos.tmp", true);
			int escolha = 0;
			escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
					"\n  Digite 0 para leitura do Resp" + 
					"\n  Digite 1 para Funções adminstrativas  " + "\n  Digite 2 para Pagamento via cartão  "
							+ "\n  Digite 3 para Confirmação  " + "\n  Digite 4 para Não confirmação  "
							+ "\n  Digite 5 para Cancelamento  "));
			
			
			if (escolha == 0 ) {
				Search s = new Search("C:\\Client\\Resp\\Intpos.001", i);
				s.leResp();
			}
			
			if (escolha == 1) {
				i.setCodFuncao("ADM");
				writer1.write(i.getHeader() + i.getCodFuncao());
				writer1.write("\n" + i.getIdentificacao());
				writer1.write(i.getInfoLivre() + i.getCNPJ());
				writer1.write("\n" + i.getRegistroFinal() + "\n");
			}
			if (escolha == 2) {
				i.setValor(JOptionPane.showInputDialog(null, "Insira o valor da transação: "));
				i.setCodFuncao("CRT");
				writer1.write(i.getHeader() + i.getCodFuncao());
				writer1.write("\n" + i.getIdentificacao() + "1");
				writer1.write("\n003-000 = " + i.getValor());
				writer1.write("\n" + i.getInfoLivre() + i.getCNPJ());
				writer1.write("\n" + i.getRegistroFinal() + "\n");
			} 
			if (escolha == 3 || escolha == 4) {
				if (escolha == 3) {
					i.setCodFuncao("CNF");
				}
				else {
					i.setCodFuncao("NCN");	
				}
				Search read = new Search("C:\\Client\\Resp\\Intpos.001", i);
				read.LeArquivo();
				//i.setValor(JOptionPane.showInputDialog(null, "Insira o valor da transação: "));
				writer1.write(i.getHeader() + i.getCodFuncao());
				writer1.write("\n" + i.getIdentificacao() + "1");
				writer1.write("\n003-000 = " + i.getValor());
				writer1.write("\n" + i.getInfoLivre() + i.getCNPJ());
				writer1.write("\n027-000 = " + i.getFinalizacao());
				writer1.write("\n" + i.getRegistroFinal() + "\n");
			}
			
			// cancelamento
			if (escolha == 5) {
				i.setCodFuncao("CNC");
				//i.setValor(JOptionPane.showInputDialog(null, "Insira o valor da transação: "));
				//i.setNsu(JOptionPane.showInputDialog(null, "Insira o número do documento (NSU): "));
				writer1.write(i.getHeader() + i.getCodFuncao());
				writer1.write("\n" + i.getIdentificacao() + "1");
				writer1.write("\n003-000 = " + i.getValor());
				writer1.write("\n" + i.getInfoLivre() + i.getCNPJ());
				writer1.write("\n012-000 = " + i.getNsu());
				writer1.write("\n999-999 = 0");
				
			}
			writer1.close();
			
			//Thread.sleep(5000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new File("C:\\Client\\Req\\Intpos.tmp").renameTo(new File("C:\\Client\\Req\\Intpos.001"));
		
		//r.leResp();
	}


}
