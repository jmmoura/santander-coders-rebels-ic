package santander.coders.rebels.ic.controller;

import lombok.*;
import santander.coders.rebels.ic.domain.Rebel;
import santander.coders.rebels.ic.enums.RaceKind;
import santander.coders.rebels.ic.exceptions.InvalidOrderOptionException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Data
@NoArgsConstructor
public class IC {
    private List<Rebel> rebels = new LinkedList<>();
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

    @SneakyThrows
    public String askPrintOrder() {
        String[] options = {"Nome", "Idade", "Raça"};
        System.out.println("Como você deseja ordenar os Rebeldes?");
        try {
            for (RaceKind item : RaceKind.values()) {
                System.out.printf("%d - %s%n", item.ordinal(), item.getDescription());
            }
            int optionIndex = scanner.nextInt();
            scanner.nextLine();

            if(optionIndex < 0 || optionIndex >= options.length) {
                throw new InvalidOrderOptionException("Erro: opção inválida!");
            }

            return options[optionIndex];
        } catch (Exception e) {
            System.err.println("Erro: a opção deve ser um inteiro válido!");
        }
        scanner.nextLine();
        return null;
    }

    public void askIngress(Rebel rebel) {
        Random generator = new Random();

        int acceptIngress = generator.nextInt(2);
        if (acceptIngress == 1) {
            rebels.add(rebel);
        }
    }

    public void printRebelsToFile() {
        try {
            @Cleanup PrintWriter writer = new PrintWriter("rebels.txt", "UTF-8");
            writer.println("Aliança Rebelde");

            if (rebels.size() == 0) {
                writer.println("Nenhum Rebelde foi aceito pela IC ainda.");
            }

            for (Rebel rebel :
                    rebels) {
                writer.println();
                writer.println("Nome: " + rebel.getName());
                writer.println("Idade: " + rebel.getAge());
                writer.println("Raça: " + rebel.getRace());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void printRebelsToConsole() {
        System.out.println("Aliança Rebelde");

        if (rebels.size() == 0) {
            System.out.println("Nenhum Rebelde foi aceito pela IC ainda.");
        }

        for (Rebel rebel :
                rebels) {
            System.out.println();
            System.out.println("Nome: " + rebel.getName());
            System.out.println("Idade: " + rebel.getAge());
            System.out.println("Raça: " + rebel.getRace());
        }
    }
}
