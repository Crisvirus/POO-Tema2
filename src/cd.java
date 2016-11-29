public class cd implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		// Comanda cd este comanda care ne muta in directorul cerut
		String[] Path = arg[1].split("/");
		if (arg[1].charAt(0) == '/') {
			// Cale absoluta
			String e;
			Director cale = bash.getroot();
			for (int i = 1; i < Path.length; ++i) {
				e = Path[i];
				if (e.equals("..")) {
					cale = cale.getParent();
				} else {
					if (e.equals(".") == false) {
						if (cale.hasFile(e) != null) {
							if (cale.hasFile(e).isfile == false) {
								if (cale.hasFile(e).hasxPermision(
										bash.getUser())) {
									cale = (Director) cale.hasFile(e);
								} else {
									System.out.println("-6: " + comanda
											+ ": No rights to execute");
									return -6;
								}

							} else {
								System.out.println("-3: " + comanda
										+ ": Not a directory");
								return -3;
							}

						} else {
							System.out.println("-2: " + comanda
									+ ": No such directory");
							return -2;
						}
					}

				}
			}
			bash.setWorkingDir(cale);
		} else {
			// Cale relativa
			String e;
			Director cale = bash.getWorkingDir();
			for (int i = 0; i < Path.length; ++i) {
				e = Path[i];
				if (e.equals("..")) {
					cale = cale.getParent();
				} else {
					if (e.equals(".") == false) {
						if (cale.hasFile(e) != null) {
							if (cale.hasFile(e).isfile == false) {
								if (cale.hasFile(e).hasxPermision(
										bash.getUser())) {
									cale = (Director) cale.hasFile(e);
								} else {
									System.out.println("-6: " + comanda
											+ ": No rights to execute");
									return -6;
								}
							} else {
								System.out.println("-3: " + comanda
										+ ": Not a directory");
								return -3;
							}

						} else {
							System.out.println("-2: " + comanda
									+ ": No such directory");
							return -2;
						}
					}

				}
			}
			bash.setWorkingDir(cale);
		}
		return 0;

	}

}
