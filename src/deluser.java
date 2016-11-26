import java.util.LinkedList;


public class deluser implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		if(bash.getUserCurent().equals("root")){
			//System.out.println("Executa add user");
			if(bash.isUser(arg[1])!=null)
			{
				//bash.isUser(arg[1]).getHome().setOwner(bash.getUtilizatori().get(1));
				LinkedList<Fisier> owned=bash.isUser(arg[1]).getOwned();
				for (Fisier fisier : owned) {
					fisier.setOwner(bash.getUtilizatori().get(1));
					bash.getUtilizatori().get(1).addOwned(fisier);
					
				}
				bash.removeUser(arg[1]);
			}
			else {
				System.out.println("-8: "+comanda+": User does not exist");
				return -8;
			}

		}
		else {
			System.out.println("-10: "+comanda+": No rights to change user status");
			return -10;
		}
		return 0;

	}
}

