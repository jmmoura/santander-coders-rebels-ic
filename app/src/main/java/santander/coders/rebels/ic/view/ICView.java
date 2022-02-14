package santander.coders.rebels.ic.view;

import santander.coders.rebels.ic.enums.RaceKind;

import java.util.Scanner;

public class ICView {
    private final Scanner scanner = new Scanner(System.in);

    public String askName() {
        try {
            System.out.println("Informe o nome: ");
            return scanner.nextLine();
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return "";
    }

    public int askAge() {
        try {
            System.out.println("Informe a idade: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            return age;
        } catch (Exception e) {
            System.err.println("Erro: a idade deve ser um inteiro válido!");
        }
        scanner.nextLine();
        return -1;
    }

    public RaceKind askRaceKind() {
        try {
            System.out.println("Informe a raça: ");
            for (RaceKind item : RaceKind.values()) {
                System.out.printf("%d - %s%n", item.ordinal(), item.getDescription());
            }
            int raceKindIndex = scanner.nextInt();
            scanner.nextLine();

            return RaceKind.values()[raceKindIndex];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro: índice da raça inválido!");
        } catch (Exception e) {
            System.err.println("Erro: o índice da raça deve ser um inteiro válido!");
        }
        scanner.nextLine();
        return null;
    }

    public String askPrintOrder() {
        String[] options = {"Nome", "Idade", "Raça"};
        System.out.println("Como você deseja ordenar os Rebeldes?");
        try {
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d - %s%n", i, options[i]);
            }
            int optionIndex = scanner.nextInt();
            scanner.nextLine();

            return options[optionIndex];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro: opção inválida!");
        } catch (Exception e) {
            System.err.println("Erro: a opção deve ser um inteiro válido!");
        }
        scanner.nextLine();
        return null;
    }
}
