
public class addUser implements Command {

	public int execute(String[] arg,Bash bash,String comanda) {
		if(bash.getUserCurent().equals("root")){
			//System.out.println("Executa add user");
			User util=new User(arg[1]);
			if(bash.getUtilizatori().contains(util)==false)
			{
				Director dir=new Director(arg[1],util,bash.getWorkingDir());
				util.setHome(dir);
				//bash.setUserCurent(util);
				bash.addUser(util);
				bash.getWorkingDir().addFile(dir);
				util.addOwned(dir);
				//bash.setWorkingDir(dir);
			}
			else {
				System.out.println("-9: "+comanda+": User already exists");
				return -9;
			}

		}
		else {
			System.out.println("-10: "+comanda+": No rights to change user status");
			return -10;
		}
	return 0;	
	}

}
