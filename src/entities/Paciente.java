package entities;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
	public String nome;
	public int idade;
	public List<Vacina> vacinasTomadas;

	public Paciente(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		this.vacinasTomadas = new ArrayList<>();
	}

	public void adicionarVacina(Vacina vacina) {
		vacinasTomadas.add(vacina);
	}

	public List<Vacina> getVacinasTomadas() {
		return vacinasTomadas;
	}

	public int calcularTotalDosesTomadas() {
		int totalDosesTomadas = 0;
		for (Vacina vacina : vacinasTomadas) {
			totalDosesTomadas += vacina.getDosesTomadas();
		}
		return totalDosesTomadas;
	}

	// Método para calcular e retornar a quantidade total de doses faltantes para o
	// paciente
	public int calcularTotalDosesFaltantes() {
		int totalDosesFaltantes = 0;
		for (Vacina vacina : vacinasTomadas) {
			totalDosesFaltantes += vacina.getDosesFaltantes();
		}
		return totalDosesFaltantes;
	}

	// Método para obter a lista de vacinas que o paciente precisa tomar
	public List<Vacina> getVacinasFaltantes() {
		List<Vacina> vacinasFaltantes = new ArrayList<>();
		for (Vacina vacina : vacinasTomadas) {
			if (vacina.getDosesFaltantes() > 0) {
				vacinasFaltantes.add(vacina);
			}
		}
		return vacinasFaltantes;
	}
}