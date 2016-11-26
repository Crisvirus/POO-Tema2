public class Fisier {
	String name, content;
	byte permisiuni;
	User owner;
	boolean isfile;
	Director parinte;

	Fisier() {
		this.name = null;
		this.owner = null;
		this.parinte = null;
		this.permisiuni = 56;
		this.isfile = true;
		this.content = null;

	}

	Fisier(String name, User owner, Director parinte) {
		this.name = name;
		this.owner = owner;
		this.parinte = parinte;
		this.permisiuni = 56;
		this.isfile = true;
		this.content = null;
	}
	public void addPermisiuni(int x){
		this.permisiuni=(byte) (this.permisiuni | x);
	}
	public void setParent(Director dir){
		this.parinte=dir;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return this.name;
	}
	public void setPermisiuni(int x)
	{
		this.permisiuni=(byte) x;
	}
	@Override
	public String toString() {

		return this.name;
	}
	public void putContent(String content){
		this.content=content;
	}
	public String getContent(){
		return this.content;
	}

	public boolean hasxPermision(User util) {
		User root = new User("root");
		if (util.equals(root)) {
			return true;
		}
		if (util.equals(this.owner)) {
			return (this.permisiuni & 8) == 8;
		} else {
			return (this.permisiuni & 1) == 1;
		}
	}

	public boolean haswPermision(User util) {
		User root = new User("root");
		if (util.equals(root)) {
			return true;
		}
		if (util.equals(this.owner)) {
			return (this.permisiuni & 16) == 16;
		} else {
			return (this.permisiuni & 2) == 2;
		}
	}
	public boolean hasrPermision(User util) {
		User root = new User("root");
		if (util.equals(root)) {
			return true;
		}
		if (util.equals(this.owner)) {
			return (this.permisiuni & 32) == 32;
		} else {
			return (this.permisiuni & 4) == 4;
		}
	}

	public void printPermisiuni() {
		String p = "";
		if (this.isfile == true)
			p = p + "f";
		else
			p = p + "d";
		if ((this.permisiuni & 32) == 32)
			p = p + "r";
		else
			p = p + "-";
		if ((this.permisiuni & 16) == 16)
			p = p + "w";
		else
			p = p + "-";
		if ((this.permisiuni & 8) == 8)
			p = p + "x";
		else
			p = p + "-";
		if ((this.permisiuni & 4) == 4)
			p = p + "r";
		else
			p = p + "-";
		if ((this.permisiuni & 2) == 2)
			p = p + "w";
		else
			p = p + "-";
		if ((this.permisiuni & 1) == 1)
			p = p + "x";
		else
			p = p + "-";
		System.out.print(p);
	}
	public void print(){
		System.out.print(this.name+" ");
		this.printPermisiuni();
		System.out.println(" "+this.owner);
	}

}
