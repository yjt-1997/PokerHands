public enum PokersType {
    HIGH_CARD(1),
    PAIR(2);

    private int type;

    PokersType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
