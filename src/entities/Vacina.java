package entities;

public class Vacina {
	public String nome;
	public int dosesTomadas;
	public int dosesTotais;

	public Vacina(String nome, int dosesTotais) {
		this.nome = nome;
		this.dosesTomadas = 0;
		this.dosesTotais = dosesTotais;
	}

	public void tomarDose(int dosesTomadas) {
		this.dosesTomadas += dosesTomadas;
	}

	public int getDosesFaltantes() {
		return Math.max(0, dosesTotais - dosesTomadas);
	}

	public int getDosesTomadas() {
		return dosesTomadas;
	}
}