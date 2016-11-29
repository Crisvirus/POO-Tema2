public class rmdir implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		// Comada rmdir sterge un director
		if (arg[1].equals(".")) {
			// Tratarea cazului special in care se cere stergerea directorului
			// curent
			System.out.println("-13: " + comanda
					+ ": Cannot delete parent or current directory");
			return -13;
		}
		if (arg[1].equals("..")) {
			// Tratarea cazului special in care se cere stergerea parintelui
			// directorului curent
			System.out.println("-13: " + comanda
					+ ": Cannot delete parent or current directory");
			return -13;
		}
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
			Director dir = new Director(Path[Path.length - 1], bash.getUser(),
					auxbash.getWorkingDir());
			if (auxbash.getWorkingDir().hasFile(dir.getName()) != null) {
				if (Path[Path.length - 1].equals("..")) {
					System.out.println("-13: " + comanda
							+ ": Cannot delete parent or current directory");
					return -13;
				}
				if (auxbash.getWorkingDir().haswPermision(auxbash.getUser())) {
					if (auxbash.getWorkingDir().hasFile(dir.getName()).isfile == false) {
						if (((Director) auxbash.getWorkingDir().hasFile(
								dir.getName())).getFiles().isEmpty()) {
							if (((Director) auxbash.getWorkingDir())
									.isAbove(auxbash.getWorkingDir().hasFile(
											dir.getName())) == true) {
								auxbash.getWorkingDir()
										.getFiles()
										.remove(auxbash.getWorkingDir()
												.hasFile(dir.getName()));
							} else {
								System.out
										.println("-13: "
												+ comanda
												+ ": Cannot delete parent or current directory");
								return -13;
							}
						} else {
							System.out.println("-14: " + comanda
									+ ": Non empty directory");
							return -14;
						}
					} else {
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
