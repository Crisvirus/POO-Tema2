
public class touch implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		String[] Path = arg[1].split("/");
		// String s=arg[1];
		// System.out.println(Path[Path.length-1]);
		// int n=arg[1].indexOf(Path[Path.length-1]);
		// System.out.println(n);
		arg[1] = arg[1].substring(0, arg[1].indexOf(Path[Path.length - 1]));
		// System.out.println(arg[1]);
		Bash auxbash = bash;
		cd go = new cd();
		int n=0;
		if(arg[1].equals("")==false){
			n = go.execute(arg, auxbash, comanda);
		}
		if (n == 0) {
			Fisier file = new Fisier(Path[Path.length - 1], bash.getUser(),
					auxbash.getWorkingDir());
			if (auxbash.getWorkingDir().hasFile(file.getName()) == null) {
				if (auxbash.getWorkingDir().haswPermision(auxbash.getUser())) {
					auxbash.getWorkingDir().addFile(file);
					auxbash.getUser().addOwned(file);
				} else {
					System.out.println("-5: " + comanda
							+ ": No rights to write");
					return -5;
				}
			} else {
				if (auxbash.getWorkingDir().hasFile(file.getName()).isfile == true) {
					System.out
							.println("-7: " + comanda + ": File already exists");
					return -3;
				} else {
					System.out.println("-1: " + comanda + ": Is a directory");
					return -1;
				}
			}
		}

		// int n=
		return 0;
	}

}