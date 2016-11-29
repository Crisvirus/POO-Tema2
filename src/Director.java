import java.util.LinkedList;

public class Director extends Fisier {
	// Clasa Director extinde clasa Fisier. Aceasta contine in plus fata de
	// Fisier o lista cu fisierele care se afla in director
	private LinkedList<Fisier> listaFisiere;

	Director(String name, User owner, Director parinte) {
		this.name = name;
		this.owner = owner;
		this.parinte = parinte;
		this.permisiuni = 56;
		this.isfile = false;
		this.content = null;
		this.listaFisiere = new LinkedList<Fisier>();

	}

	public Fisier hasFile(String name) {
		if (name.equals(".")) {
			return this;
		}
		if (name.equals("..")) {
			return this.parinte;
		}
		for (Fisier f : listaFisiere) {
			if (f.getName().equals(name)) {
				return f;
			}
		}
		return null;
	}

	public Director getParent() {
		return this.parinte;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public void addFile(Fisier file) {
		listaFisiere.add(file);
	}

	public LinkedList<Fisier> getFiles() {
		return listaFisiere;
	}

	public boolean isAbove(Fisier f) {
		if (this == (Director) f)
			return true;
		for (Fisier e : listaFisiere) {
			if (e.isfile == false) {
				if (((Director) e).isAbove(f))
					return true;
			}
		}
		return false;
	}

	public void printRecursiv(String s) {
		this.print();
		s = s + "\t";
		for (Fisier f : listaFisiere) {
			System.out.print(s);
			if (f.isfile == false) {
				((Director) f).printRecursiv(s);
			} else {
				f.print();
			}
		}

	}
}
