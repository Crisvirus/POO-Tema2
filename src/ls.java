public class ls implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		String[] Path = arg[1].split("/");
		if(arg[1].equals("/")){
			if(bash.getWorkingDir().hasrPermision(bash.getUser())){
				for (Fisier f : (bash.getWorkingDir().getFiles())) {
					f.print();
				}
				return 0;
			}
			else{
				System.out.println("-4: " + comanda
						+ ": No rights to read");
				return -4;
			}
		}
		// String s=arg[1];
		// System.out.println(Path[Path.length-1]);
		// int n=arg[1].indexOf(Path[Path.length-1]);
		// System.out.println(n);
		// System.out.println(arg[1]);
		Bash auxbash = new Bash(bash.getUser(), bash.getWorkingDir());
		auxbash.copy(bash);
//		if (arg[1].equals("../")) {
//			auxbash.setWorkingDir(auxbash.getWorkingDir().getParent());
//		}
		cd go = new cd();
		arg[1] = arg[1].substring(0, arg[1].indexOf(Path[Path.length - 1]));
		int n = 0;
		if (arg[1].equals("") == false) {
			n = go.execute(arg, auxbash, comanda);
		}
		if (n == 0) {
			if (Path[Path.length - 1].equals(".") == false) {
				Fisier file = new Fisier(Path[Path.length - 1], bash.getUser(),
						auxbash.getWorkingDir());
				if (auxbash.getWorkingDir().hasFile(file.getName()) != null) {
					if(auxbash.getWorkingDir().hasFile(file.getName()).isfile==false && auxbash.getWorkingDir().hasFile(file.getName()).hasxPermision(bash.getUser())==false)
					{
						System.out.println("-6: " + comanda
								+ ": No rights to execute");
						return -6;
					}
					if (auxbash.getWorkingDir().hasFile(file.getName())
							.hasrPermision(bash.getUser())) {
						if (auxbash.getWorkingDir().hasFile(file.getName()).isfile) {
							auxbash.getWorkingDir().hasFile(file.getName())
									.print();
						} else {
							for (Fisier f : ((Director) auxbash.getWorkingDir()
									.hasFile(file.getName())).getFiles()) {
								f.print();
							}
						}
					} else {
						System.out.println("-4: " + comanda
								+ ": No rights to read");
						return -4;
					}

				} else {
					System.out.println("-12: " + comanda
							+ ": No such file or directory");
					return -12;
				}
			} else {
				if (auxbash.getWorkingDir().hasrPermision(bash.getUser())) {
					for (Fisier f : auxbash.getWorkingDir().getFiles()) {
						f.print();
					}
				} else {
					System.out
							.println("-4: " + comanda + ": No rights to read");
					return -4;
				}

			}

		}

		return 0;
	}

}
