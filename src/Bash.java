import java.util.LinkedList;


public class Bash {
	LinkedList<User> utilizatori;
	User userCurent;
	Director workingDir;
	Director root;
	Bash(User utilizator,Director dir)
	{
		this.userCurent=utilizator;
		this.workingDir=dir;
		this.utilizatori=new LinkedList<User>();
		this.utilizatori.add(utilizator);
		
	}
	public User getUser(){
		return this.userCurent;
	}
	public User isUser(String name)
	{
		User util=new User(name);
		if(utilizatori.contains(util))
		{
			int n= utilizatori.indexOf(util);
			return utilizatori.get(n);
		}
		else return null;
	}
	public void removeUser(String name){
		utilizatori.remove(this.isUser(name));
		
	}
	public void setroot(Director root){
		this.root=root;
	}
	public LinkedList<User> getUtilizatori() {
		return utilizatori;
	}
	public void addUser(User utilizator) {
		this.utilizatori.add(utilizator);
	}
	public String getUserCurent() {
		return userCurent.getName();
	}
	public void setUserCurent(User userCurent) {
		this.userCurent = userCurent;
	}
	public Director getWorkingDir() {
		return workingDir;
	}
	public Director getroot() {
		return root;
	}
	public void setWorkingDir(Director workingDir) {
		this.workingDir = workingDir;
	}
	


}
