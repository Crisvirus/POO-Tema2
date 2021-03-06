import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	/*
	 * Clasa Test este clasa ce contine main-ul, si este clasa din care se
	 * parcurge fiecare comanda
	 */
	public static void main(String[] args) throws IOException {
		Bash bash;
		String comanda;
		File f;
		Director slash;
		User root;
		root = new User("root");
		slash = new Director("/", root, null);
		root.setHome(slash);
		slash.setParent(slash);
		slash.addPermisiuni(5);
		bash = new Bash(root, slash);
		bash.setroot(slash);
		f = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(f));
		comanda = br.readLine();
		comanda = br.readLine();
		CommandFactory cf = new CommandFactory();
		while (comanda != null) {
			cf.newCommand(comanda, bash);
			comanda = br.readLine();
		}
		bash.getroot().printRecursiv("");
		br.close();
	}

}
