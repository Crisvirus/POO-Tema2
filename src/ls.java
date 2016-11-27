
public class ls implements Command {

	public int execute(String[] arg, Bash bash, String comanda) {
		String[] Path = arg[1].split("/");
		// String s=arg[1];
		// System.out.println(Path[Path.length-1]);
		// int n=arg[1].indexOf(Path[Path.length-1]);
		// System.out.println(n);
		arg[1] = arg[1].substring(0, arg[1].indexOf(Path[Path.length - 1]));
		// System.out.println(arg[1]);
		Bash auxbash=new Bash(bash.getUser(),bash.getWorkingDir());
		auxbash.copy(bash);
		cd go = new cd();
		int n=0;
		if(arg[1].equals("")==false){
			n = go.execute(arg, auxbash, comanda);
		}
		if (n == 0) {
			if(Path[Path.length - 1].equals(".")==false){
				Fisier file = new Fisier(Path[Path.length - 1], bash.getUser(),
						auxbash.getWorkingDir());
				if (auxbash.getWorkingDir().hasFile(file.getName()) != null) {
					if(auxbash.getWorkingDir().hasFile(file.getName()).hasrPermision(bash.getUser())){
						if(auxbash.getWorkingDir().hasFile(file.getName()).isfile)
						{
							auxbash.getWorkingDir().hasFile(file.getName()).print();
						}
						else{
							for (Fisier f : ((Director) auxbash.getWorkingDir().hasFile(file.getName())).getFiles()) {
								f.print();
							}
						}
					}
					else{
						System.out.println("-4: " + comanda + ": No rights to read");
						return -4;
					}
					
				}
				else{
					System.out.println("-12: " + comanda + ": No such file or directory");
					return -12;
				}
			}
			else{
				if(auxbash.getWorkingDir().hasrPermision(bash.getUser())){
					for (Fisier f : auxbash.getWorkingDir().getFiles() ){
						f.print();
					}
				}
				else{
					System.out.println("-4: " + comanda + ": No rights to read");
					return -4;
				}
				
			}
			
			
		}
		
		
		
		
		
		return 0;
	}

}
