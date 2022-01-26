/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package santander.coders.rebels.ic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IC ic = new IC();

        System.out.println("Bem-vindo à Inteligência Central dos Rebeldes!");
        System.out.println("Insira as inforações dos aspirantes a novos Rebeldes.");
        while (true) {
            System.out.println("Informe o nome: ");
            String name = scanner.nextLine();

            System.out.println("Informe a idade: ");
            int age = scanner.nextInt();

            System.out.println("Informe a raça: ");
            for (RaceKind raceKind : RaceKind.values()) {
                System.out.printf("%d - %s%n", raceKind.ordinal(), raceKind);
            }
            int raceKind = scanner.nextInt();

            while (raceKind < 0 || raceKind >= RaceKind.values().length) {
                System.out.println("Raça inválida!");
                System.out.println("Informe a raça: ");
                for (RaceKind raceKind : RaceKind.values()) {
                    System.out.printf("%d - %s%n", raceKind.ordinal(), raceKind);
                }
            }

            Rebel rebel = new Rebel(name, age, RaceKind.values()[raceKind]);



        }

    }
}
