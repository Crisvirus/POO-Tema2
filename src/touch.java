public class touch implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		// Comanda touch foloseste comanda cd pentru a se muta in directorul
		// specificat in path, iar apoi creeaza fisierul cerut daca este permis
		String[] Path = arg[1].split("/");
		arg[1] = arg[1].substring(0, arg[1].indexOf(Path[Path.length - 1]));
		Bash auxbash = new Bash(bash.getUser(), bash.getWorkingDir());
		auxbash.copy(bash);
		cd go = new cd();
		int n = 0;
		if (arg[1].equals("") == false) {
			n = go.execute(arg, auxbash, comanda);
		}
		if (n == 0) {
			Fisier file = new Fisier(Path[Path.length - 1], bash.getUser(),
					auxbash.getWorkingDir());
			if (auxbash.getWorkingDir().haswPermision(bash.getUser())) {
				if (auxbash.getWorkingDir().hasFile(file.getName()) == null) {
					auxbash.getWorkingDir().addFile(file);
					bash.getUser().addOwned(file);
				} else {
					if (auxbash.getWorkingDir().hasFile(file.getName()).isfile == true) {
						System.out.println("-7: " + comanda
								+ ": File already exists");
						return -3;
					} else {
						System.out.println("-1: " + comanda
								+ ": Is a directory");
						return -1;
					}
				}
			} else {
				System.out.println("-5: " + comanda + ": No rights to write");
				return -5;
			}
		}
		return 0;
	}

}
