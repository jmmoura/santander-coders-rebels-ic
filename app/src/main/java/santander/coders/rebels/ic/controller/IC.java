package santander.coders.rebels.ic.controller;

import lombok.*;
import santander.coders.rebels.ic.domain.Rebel;
import santander.coders.rebels.ic.enums.RaceKind;
import santander.coders.rebels.ic.utils.Utils;
import santander.coders.rebels.ic.view.ICView;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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

    public String askOrderOption() {
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

    public void sortRebels(String orderOption) {
        List<Rebel> rebelList = rebels;
        Rebel[] rebelsArray = rebelList.toArray(new Rebel[rebelList.size()]);
        Rebel[] rebelArrayOrdered;
        switch (orderOption) {
            case "Nome":
                rebelArrayOrdered = Utils.selectionSortByName(rebelsArray);
                rebels = Arrays.asList(rebelArrayOrdered);
                break;
            case "Idade":
                rebelArrayOrdered = Utils.selectionSortByAge(rebelsArray);
                rebels = Arrays.asList(rebelArrayOrdered);
                break;
            case "Raça":
                rebelArrayOrdered = Utils.selectionSortByRaceKind(rebelsArray);
                rebels = Arrays.asList(rebelArrayOrdered);
                break;
        }
    }

    public void printRebelsToFile() {
        try {
            @Cleanup PrintWriter writer = new PrintWriter("rebels.txt", StandardCharsets.UTF_8);
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
        } catch (IOException e) {
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
