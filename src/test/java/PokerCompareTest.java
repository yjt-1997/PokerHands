import org.junit.Assert;
import org.junit.Test;

public class PokerCompareTest {

    public static PokerCompare compare = new PokerCompare();

    @Test
    public void should_compare_correct_when_given_two_chars() {
        String pokers1 = "3C";
        String pokers2 = "KC";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_compare_correct_when_given_two_highcards() {
        String pokers1 = "2H4D5S9CQD";
        String pokers2 = "2C3D5S9CKD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_same_when_given_two_same_highcards() {
        String pokers1 = "2H4D5S9CQD";
        String pokers2 = "2H4D5S9CQD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.THE_SAME.getResult());
    }

    @Test
    public void should_pair_win_when_given_highcard_and_pair() {
        String pokers1 = "2C3D5S9CKD";
        String pokers2 = "2H2D5S9CQD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigPair_win_when_given_two_pairs() {
        String pokers1 = "2H2D5S9CKD";
        String pokers2 = "3C3D5S9CTD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_twoPairs_win_when_given_aPair_and_twoPairs() {
        String pokers1 = "2H2D5S9CKD";
        String pokers2 = "3C3D5S5CTD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigTwoPairs_win_when_given_two_twoPairs() {
        String pokers1 = "2H2D5S5CKD";
        String pokers2 = "3C3D5S5CTD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_three_win_when_given_twoPairs_and_three() {
        String pokers1 = "2H2D5SKCKD";
        String pokers2 = "3C3D3S5CTD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigThree_win_when_given_two_three() {
        String pokers1 = "2H2D2SQCKD";
        String pokers2 = "3C3D3S5CTD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigThree_win_when_given_two_sameThreeButDifferentSingle() {
        String pokers1 = "3C3D3S5C9D";
        String pokers2 = "3C3D3S5CTD";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_straight_win_when_given_three_and_straight() {
        String pokers1 = "2H2D2SQCKD";
        String pokers2 = "3C4D5S6C7D";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigStraight_win_when_given_two_straight() {
        String pokers1 = "2H3D4S5C6D";
        String pokers2 = "3C4D5S6C7D";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_flush_win_when_given_straight_and_flush() {
        String pokers1 = "3C4D5S6C7D";
        String pokers2 = "2H3H5H9HKH";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigFlush_win_when_given_twoFlush() {
        String pokers1 = "2H3H5H8HKH";
        String pokers2 = "2H3H5H9HKH";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_fullHouse_win_when_given_flush_and_fullHouse() {
        String pokers1 = "2H3H5H8HKH";
        String pokers2 = "3H3D5S5C3D";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigFullHouse_win_when_given_twoFullHouse() {
        String pokers1 = "2H2D6S6C2D";
        String pokers2 = "3H3D5S5C3D";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_big_pair_win_when_given_twoFullHouse_sameThree() {
        String pokers1 = "3H3D5S5C3D";
        String pokers2 = "3H3D6S6C3D";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_four_win_when_given_fullHouse_and_four() {
        String pokers1 = "3H3D5S5C3D";
        String pokers2 = "2H2D2S4C2D";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigFour_win_when_given_twoFour() {
        String pokers1 = "2H2D2S8C2D";
        String pokers2 = "3H3D3S5C3D";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigSingle_win_when_given_twoFour_sameFour_differentSingle() {
        String pokers1 = "3H3D3S4C3D";
        String pokers2 = "3H3D3S5C3D";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_straightFlush_win_when_given_four_and_straightFlush() {
        String pokers1 = "2H2D2S8C2D";
        String pokers2 = "2H3H4H5H6H";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }

    @Test
    public void should_bigStraightFlush_win_when_given_two_straightFlush() {
        String pokers1 = "2H3H4H5H6H";
        String pokers2 = "3H4H5H6H7H";

        int result = compare.compare(pokers1, pokers2);

        Assert.assertEquals(result, CompareResult.PLAYER2_WIN.getResult());
    }
}
