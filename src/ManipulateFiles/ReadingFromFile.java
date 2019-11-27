/*package ManipulateFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Client.Intpos;
//Classe que deixou de ser usada após a criação da Search.
public class ReadingFromFile {

	// Consulta na RESP
	File file = new File("C:\\Client\\Resp\\Intpos.001");
	Scanner sc = new Scanner(file);
	Intpos i = new Intpos();

	while(sc.hasNextLine())
	{
		String iden = sc.nextLine();
		System.out.println(iden);
		// System.out.println("substring = " + iden.substring(0,9));
		if (iden.substring(0, 7).equals("027-000")) {
			String code = iden.substring(10, 40);
			i.setFinalizacao(code);

		}

		if (iden.substring(0, 7).contentEquals("012-000")) {
			String nsu = iden.substring(10, 19);
			i.setNsu(nsu);
		}

	}System.out.println("027: "+i.getFinalizacao());
}

}
*/