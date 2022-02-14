package santander.coders.rebels.ic.controller;

import lombok.*;
import santander.coders.rebels.ic.domain.Rebel;
import santander.coders.rebels.ic.enums.RaceKind;
import santander.coders.rebels.ic.view.ICView;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Data
@NoArgsConstructor
public class IC {
    private ICView icView = new ICView();
    private List<Rebel> rebels = new LinkedList<>();

    public Rebel askNewRebel() {
        String name = icView.askName();
        int age = icView.askAge();
        RaceKind raceKind = icView.askRaceKind();

        return new Rebel(name, age, raceKind);
    }

    public String askPrintOrder() {
        String printOrder;
        do {
            printOrder = icView.askPrintOrder();
        } while (printOrder == null);

        return printOrder;
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
                writer.println("Raça: " + rebel.getRace().getDescription());
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
            System.out.println("Raça: " + rebel.getRace().getDescription());
        }
    }
}
