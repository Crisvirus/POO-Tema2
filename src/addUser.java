public class addUser implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		// Comanda addUser creeaza un nou utilizator si un director cu acelasi
		// nume in /
		if (bash.getUserCurent().equals("root")) {
			User util = new User(arg[1]);
			if (bash.getUtilizatori().contains(util) == false) {
				Director dir = new Director(arg[1], util, bash.getroot());
				util.setHome(dir);
				bash.addUser(util);
				bash.getroot().addFile(dir);
				util.addOwned(dir);
			} else {
				System.out.println("-9: " + comanda + ": User already exists");
				return -9;
			}

		} else {
			System.out.println("-10: " + comanda
					+ ": No rights to change user status");
			return -10;
		}
		return 0;
	}

}
