import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Bash bash;
		String comanda;
		File f;
		Director slash;
		User root;
		root = new User("root");
		slash=new Director("/", root, null);
		root.setHome(slash);
		slash.setParent(slash);
		slash.addPermisiuni(5);
		bash=new Bash(root,slash);
		bash.setroot(slash);
		f=new File("data.in");
		BufferedReader br = new BufferedReader(new FileReader(f));
		comanda=br.readLine();
		comanda=br.readLine();
		CommandFactory cf=new CommandFactory();
		while(comanda!=null){
			//System.out.println(comanda);
			cf.newCommand(comanda, bash);
			comanda=br.readLine();
		}
		//System.out.println(bash.getUserCurent()+" "+bash.getWorkingDir()+" "+bash.getUtilizatori());
		//System.out.println(bash.getUtilizatori().get(1).getOwned());
		bash.getroot().printRecursiv("");
		
		
		
		
		br.close();
	}

}
