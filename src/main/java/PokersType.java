public enum PokersType {
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7);

    private int type;

    PokersType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
