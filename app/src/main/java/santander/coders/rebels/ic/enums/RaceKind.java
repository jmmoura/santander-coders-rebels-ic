package santander.coders.rebels.ic.enums;

public enum RaceKind {
    GREE("Gree"),
    HUMAN("Humano"),
    RAKATA("Rakata");

    private String description;

    RaceKind(String description) {this.description = description;}

    public String getDescription() { return description; }
}
