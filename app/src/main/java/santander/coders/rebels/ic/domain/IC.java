package santander.coders.rebels.ic.domain;

import lombok.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public class IC {
    private List<Rebel> rebels = new ArrayList<>();

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
