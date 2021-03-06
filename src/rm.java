public class rm implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		if (arg[1].equals("-r") == false) {
			// Comanda rm este apelata fara parametrul -r
			String[] Path = arg[1].split("/");
			arg[1] = arg[1].substring(0, arg[1].indexOf(Path[Path.length - 1]));
			Bash auxbash = bash;
			cd go = new cd();
			int n = 0;
			if (arg[1].equals("") == false) {
				n = go.execute(arg, auxbash, comanda);
			}
			if (n == 0) {
				Fisier file = new Fisier(Path[Path.length - 1], bash.getUser(),
						auxbash.getWorkingDir());
				if (auxbash.getWorkingDir().hasFile(file.getName()) != null) {
					if (auxbash.getWorkingDir()
							.haswPermision(auxbash.getUser())) {
						if (auxbash.getWorkingDir().hasFile(file.getName()).isfile) {
							auxbash.getWorkingDir()
									.getFiles()
									.remove(auxbash.getWorkingDir().hasFile(
											file.getName()));
						} else {
							System.out.println("-1: " + comanda
									+ ": Is a directory");
							return -1;
						}
					} else {
						System.out.println("-5: " + comanda
								+ ": No rights to write");
						return -5;
					}
				} else {
					System.out.println("-11: " + comanda + ": No such file");
					return -12;
				}
			}
		} else {
			// Comanda rm este apelata cu parametrul -r
			if (arg[2].equals("/")) {
				System.out.println("-13: " + comanda
						+ ": Cannot delete parent or current directory");
				return -13;
			}
			if (arg[2].equals(".")) {
				System.out.println("-13: " + comanda
						+ ": Cannot delete parent or current directory");
				return -13;
			}
			if (arg[2].equals("..")) {
				System.out.println("-13: " + comanda
						+ ": Cannot delete parent or current directory");
				return -13;
			}
			String[] Path = arg[2].split("/");
			arg[2] = arg[2].substring(0, arg[2].indexOf(Path[Path.length - 1]));
			String[] aux = new String[2];
			aux[0] = arg[0];
			aux[1] = arg[2];
			Bash auxbash = new Bash(bash.getUser(), bash.getWorkingDir());
			auxbash.copy(bash);
			cd go = new cd();
			int n = 0;
			if (arg[2].equals("") == false) {
				n = go.execute(aux, auxbash, comanda);
			}
			if (n == 0) {
				Director dir = new Director(Path[Path.length - 1],
						bash.getUser(), auxbash.getWorkingDir());
				if (auxbash.getWorkingDir().hasFile(dir.getName()) != null) {
					if (auxbash.getWorkingDir().hasFile(dir.getName()).isfile == true) {
						aux[1] = arg[2] + Path[Path.length - 1];
						rm r = new rm();
						return r.execute(aux, auxbash, comanda);
					}
				}
				if (((Director) auxbash.getWorkingDir()).isAbove(auxbash
						.getWorkingDir().hasFile(dir.getName())) == true) {
					if (auxbash.getWorkingDir().hasFile(dir.getName()) != null) {
						if (auxbash.getWorkingDir().haswPermision(
								auxbash.getUser())) {
							auxbash.getWorkingDir()
									.getFiles()
									.remove(auxbash.getWorkingDir().hasFile(
											dir.getName()));
						} else {
							System.out.println("-5: " + comanda
									+ ": No rights to write");
							return -5;
						}
					} else {
						System.out.println("-12: " + comanda
								+ ": No such file or directory");
						return -12;
					}
				} else {
					System.out.println("-13: " + comanda
							+ ": Cannot delete parent or current directory");
					return -13;
				}

			}
		}

		return 0;
	}

}
