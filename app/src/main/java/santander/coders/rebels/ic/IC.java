package santander.coders.rebels.ic;

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

    public void addRebel(Rebel rebel) {
        Random generator = new Random();

        int index = generator.nextInt(2);
        if (index == 1) {
            rebels.add(rebel);
        }
    }

    public void printRebels() throws FileNotFoundException, UnsupportedEncodingException {
        @Cleanup PrintWriter writer = new PrintWriter("rebels.txt", "UTF-8");
        writer.println("Aliança Rebelde");

        for (Rebel rebel :
                rebels) {
            writer.println();
            writer.println("Nome: " + rebel.getName());
            writer.println("Idade: " + rebel.getAge());
            writer.println("Raça: " + rebel.getRace());
        }
    }
}
