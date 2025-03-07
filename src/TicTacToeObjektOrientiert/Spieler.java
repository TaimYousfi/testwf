package TicTacToeObjektOrientiert;

public class Spieler {
    private final String name;
    private Spielstein stein;

    public Spieler(String name, Spielstein stein) {
        this.name = name;
        this.stein = stein;
    }

    public String getName() {
        return name;
    }

    public Spielstein getStein() {
        return stein;
    }
}
