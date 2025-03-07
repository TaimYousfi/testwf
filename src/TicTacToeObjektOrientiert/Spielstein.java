package TicTacToeObjektOrientiert;

public enum Spielstein {
    LEER, X, O;

    public Spielstein next() {
        return this == X ? O : X;
    }
}
