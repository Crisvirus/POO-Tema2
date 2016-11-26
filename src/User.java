import java.util.LinkedList;


public class User {
	String name;
	Director home;
	LinkedList<Fisier> ownedfiles;
	User(String name)
	{
		this.name=name;
		this.home=null;
		this.ownedfiles=new LinkedList<Fisier>();
	}
	public void addOwned(Fisier file){
		ownedfiles.add(file);
	}
	public LinkedList<Fisier> getOwned(){
		return ownedfiles;
	}
	void setHome(Director home){
		this.home=home;
	}
	String getName(){
		return this.name;
	}
	Director getHome(){
		return this.home;
	}
	@Override
	public boolean equals(Object obj) {
		
		return this.name.equals(((User)obj).getName());
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
