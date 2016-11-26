
public class chmod implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		int p=Integer.parseInt(arg[1]);
		String[] Path = arg[2].split("/");
		String[] aux=new String[2];
		aux[0]=arg[0];
		aux[1]=arg[2];
		// String s=arg[1];
		// System.out.println(Path[Path.length-1]);
		// int n=arg[1].indexOf(Path[Path.length-1]);
		// System.out.println(n);
		arg[2] = arg[2].substring(0, arg[2].indexOf(Path[Path.length - 1]));
		// System.out.println(arg[1]);
		Bash auxbash = bash;
		cd go = new cd();
		int n=0;
		if(arg[2].equals("")==false){
			n = go.execute(aux, auxbash, comanda);
		}
		if (n == 0) {
			Director dir = new Director(Path[Path.length - 1], bash.getUser(),
					auxbash.getWorkingDir());
			if (auxbash.getWorkingDir().hasFile(dir.getName()) != null) {
				if (auxbash.getWorkingDir().haswPermision(auxbash.getUser())) {
					auxbash.getWorkingDir().hasFile(dir.getName()).setPermisiuni(p);
				} else {
					System.out.println("-5: " + comanda
							+ ": No rights to write");
					return -5;
				}
			} else {
				System.out.println("-12: " + comanda + ": No such file or directory");
				return -12;
			}
		}
		
		
		
		
		
		return 0;
	}

}
