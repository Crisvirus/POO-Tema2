
public class CommandFactory {

	void newCommand(String comanda,Bash bash){
		String[] arg=comanda.split(" ");
		Command c;
		if(arg[0].equals("adduser")){
			c=new addUser();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("chuser")){
			c=new chuser();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("deluser")){
			c=new deluser();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("cd")){
			c=new cd();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("mkdir")){
			c=new mkdir();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("ls")){
			c=new ls();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("chmod")){
			c=new chmod();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("touch")){
			c=new touch();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("writetofile")){
			c=new writetofile();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("cat")){
			c=new cat();
			c.execute(arg, bash, comanda);
		}
		if(arg[0].equals("rmdir")){
			c=new rmdir();
			c.execute(arg, bash, comanda);
		}
	}

}
