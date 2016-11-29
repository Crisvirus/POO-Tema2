public class chuser implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		// Comanda chuser schimba user-ul curent si ne muta in directorul home
		// al acestuia
		if (bash.isUser(arg[1]) != null) {
			bash.setUserCurent(bash.isUser(arg[1]));
			bash.setWorkingDir(bash.isUser(arg[1]).getHome());
		} else {
			System.out.println("-8: " + comanda + ": User does not exist");
			return -8;
		}
		return 0;

	}

}
