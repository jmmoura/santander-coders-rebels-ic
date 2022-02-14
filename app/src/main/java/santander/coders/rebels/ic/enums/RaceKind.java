package santander.coders.rebels.ic.enums;

public enum RaceKind {
    HUMAN("Humano"),
    GREE("Gree"),
    RAKATA("Rakata");

    private String description;

    RaceKind(String description) {this.description = description;}

    public String getDescription() { return description; }
}
