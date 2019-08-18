public enum CompareResult {
    PLAYER1_WIN(1),
    THE_SAME(0),
    PLAYER2_WIN(-1);

    private int result;

    CompareResult(int type) {
        this.result = type;
    }

    public int getResult() {
        return result;
    }

}
