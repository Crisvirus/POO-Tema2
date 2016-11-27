
public class rmdir implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		if(arg[1].equals("."))
		{
			System.out.println("-13: " + comanda
					+ ": Cannot delete parent or current directory");
			return -13;
		}
		if(arg[1].equals(".."))
		{
			System.out.println("-13: " + comanda
					+ ": Cannot delete parent or current directory");
			return -13;
		}
		String[] Path = arg[1].split("/");
		// String s=arg[1];
		// System.out.println(Path[Path.length-1]);
		// int n=arg[1].indexOf(Path[Path.length-1]);
		// System.out.println(n);
		arg[1] = arg[1].substring(0, arg[1].indexOf(Path[Path.length - 1]));
		// System.out.println(arg[1]);
		Bash auxbash=new Bash(bash.getUser(),bash.getWorkingDir());
		auxbash.copy(bash);
		cd go = new cd();
		int n=0;
		if(arg[1].equals("")==false){
			n = go.execute(arg, auxbash, comanda);
		}
		if (n == 0) {
			Director dir = new Director(Path[Path.length - 1], bash.getUser(),
					auxbash.getWorkingDir());
			//System.out.println(dir);
			if (auxbash.getWorkingDir().hasFile(dir.getName()) != null) {
				if (auxbash.getWorkingDir().haswPermision(auxbash.getUser())) {
					if(auxbash.getWorkingDir().hasFile(dir.getName()).isfile==false)
					{
						if(((Director) auxbash.getWorkingDir().hasFile(dir.getName())).getFiles().isEmpty())
						{
							if(((Director)auxbash.getWorkingDir()).isAbove(auxbash.getWorkingDir().hasFile(dir.getName()))==true){
								auxbash.getWorkingDir().listaFisiere.remove(auxbash.getWorkingDir().hasFile(dir.getName()));
							}
							else{
								System.out.println("-13: " + comanda
										+ ": Cannot delete parent or current directory");
								return -13;
							}
						}
						else{
							System.out.println("-14: " + comanda
									+ ": Non empty directory");
							return -14;
						}
					}
					else{
						System.out.println("-3: " + comanda
								+ ": Not a directory");
						return -1;
					}
				} else {
					System.out.println("-5: " + comanda
							+ ": No rights to write");
					return -5;
				}
			} else {
				System.out.println("-2: " + comanda + ": No such directory");
				return -12;
			}
		}
		return 0;
	}

}
