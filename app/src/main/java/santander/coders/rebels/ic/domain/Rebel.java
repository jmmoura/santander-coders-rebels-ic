package santander.coders.rebels.ic.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import santander.coders.rebels.ic.enums.RaceKind;

@Data
@AllArgsConstructor
public class Rebel {
    @NotNull(message = "Nome não pode ser nulo!")
    @NotBlank(message = "Nome não pode ser vazio!")
    private String name;

    @Min(value = 18, message = "A idade mínima é 18 anos!")
    @Max(value = 60, message = "A idade máxima é 60 anos!")
    private int age;

    private RaceKind race;
}
