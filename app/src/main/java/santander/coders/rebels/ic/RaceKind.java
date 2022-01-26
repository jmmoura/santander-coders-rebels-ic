package santander.coders.rebels.ic;

public enum RaceKind {
    HUMAN,
    GREE,
    RAKATA;

    @Override
    public String toString() {
        String raceKind = "";
        switch (this) {
            case HUMAN:
                raceKind = "Humano";
                break;
            case GREE:
                raceKind = "Gree";
                break;
            case RAKATA:
                raceKind = "Rakata";
                break;
        }

        return raceKind;
    }
}
