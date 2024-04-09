package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Paciente;
import entities.Vacina;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um paciente
        System.out.println("Informe o nome do paciente:");
        String nomePaciente = scanner.nextLine();

        System.out.println("Informe a idade do paciente:");
        int idadePaciente = scanner.nextInt();
        scanner.nextLine(); // Consumindo a quebra de linha

        Paciente paciente = new Paciente(nomePaciente, idadePaciente);

        // Criando uma lista de vacinas pré-definidas com doses
        List<Vacina> vacinas = new ArrayList<>();
        vacinas.add(new Vacina("COVID-19", (int) (Math.random() * 3) + 3)); // De 3 a 5 doses
        vacinas.add(new Vacina("Hepatite B", (int) (Math.random() * 3) + 3));
        vacinas.add(new Vacina("Tétano", (int) (Math.random() * 3) + 3));
        vacinas.add(new Vacina("Influenza", (int) (Math.random() * 3) + 3));

        // Solicitando as doses tomadas pelo paciente para cada vacina
        for (Vacina vacina : vacinas) {
            System.out.println("Quantas doses de " + vacina.nome + " o paciente tomou?");
            int dosesTomadas = scanner.nextInt();
            scanner.nextLine(); // Consumindo a quebra de linha
            vacina.tomarDose(dosesTomadas);
            paciente.adicionarVacina(vacina);
        }

        // Exibindo as vacinas tomadas e as que faltam
        System.out.println("Vacinas tomadas pelo paciente:");
        for (Vacina vacina : paciente.getVacinasTomadas()) {
            System.out.println("- " + vacina.nome + ": " + vacina.dosesTomadas + " doses");
        }

        System.out.println("Vacinas que faltam ser tomadas pelo paciente:");
        for (Vacina vacina : paciente.getVacinasFaltantes()) {
            System.out.println("- " + vacina.nome + ": " + vacina.getDosesFaltantes() + " doses");
        }

        // Exibindo a quantidade total de doses tomadas e faltantes pelo paciente
        int totalDosesTomadas = paciente.calcularTotalDosesTomadas();
        int totalDosesFaltantes = paciente.calcularTotalDosesFaltantes();
        System.out.println("Quantidade total de doses tomadas pelo paciente: " + totalDosesTomadas);
        System.out.println("Quantidade total de doses faltantes para o paciente: " + totalDosesFaltantes);

        scanner.close();
    }
}