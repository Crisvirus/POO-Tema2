
public class chmod implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {

		String s1=new String(arg[1].substring(0, 1));
		//System.out.println(arg[1].substring(0, 1));
		int p=Integer.parseInt(s1);
		if(arg[1].length()==2)
		{
			String s2=new String(arg[1].substring(1, 2));
			p=p<<3;
			p=p+Integer.parseInt(s2);
		}
		
		String[] Path = arg[2].split("/");
		String[] aux=new String[2];
		aux[0]=arg[0];
		// String s=arg[1];
		// System.out.println(Path[Path.length-1]);
		// int n=arg[1].indexOf(Path[Path.length-1]);
		// System.out.println(n);
		arg[2] = arg[2].substring(0, arg[2].indexOf(Path[Path.length - 1]));
		// System.out.println(arg[1]);
		aux[1]=arg[2];
		Bash auxbash=new Bash(bash.getUser(),bash.getWorkingDir());
		auxbash.copy(bash);
		cd go = new cd();
		int n=0;
		if(arg[2].equals("")==false && arg[2].equals("/")==false){
			n = go.execute(aux, auxbash, comanda);
		}
		if(arg[2].equals("/")){
			auxbash.setWorkingDir(auxbash.getroot());
		}
		if (n == 0) {
			Director dir = new Director(Path[Path.length - 1], bash.getUser(),
					auxbash.getWorkingDir());
			if (auxbash.getWorkingDir().hasFile(dir.getName()) != null) {
				if (auxbash.getWorkingDir().hasFile(dir.getName()).haswPermision(auxbash.getUser())) {
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
