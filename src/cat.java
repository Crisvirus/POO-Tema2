public class cat implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		// Comanda cat afiseaza la stdout continutul unui fisier
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
			if (auxbash.getWorkingDir().hasFile(file.getName()) != null) {
				if (auxbash.getWorkingDir().hasFile(file.getName()).isfile) {
					if (auxbash.getWorkingDir().hasFile(file.getName())
							.hasrPermision(auxbash.getUser())) {
						System.out.println(auxbash.getWorkingDir()
								.hasFile(file.getName()).getContent());
					} else {
						System.out.println("-4: " + comanda
								+ ": No rights to read");
						return -5;
					}
				} else {
					System.out.println("-1: " + comanda + ": Is a directory");
					return -1;
				}

			} else {
				System.out.println("-11: " + comanda + ": No such file");
				return -12;
			}
		}
		return 0;
	}

}
