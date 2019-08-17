import org.junit.Assert;
import org.junit.Test;

public class PokerCompareTest {

    public static PokerCompare compare = new PokerCompare();

    @Test
    public void should_compare_correct_when_given_two_chars(){
        String pokers1 = "KC";
        String pokers2 = "3C";

        int result = compare.compare(pokers1,pokers2);

        Assert.assertEquals(result,1);
    }

    @Test
    public void should_compare_correct_when_given_two_highcards(){
        String pokers1 = "2H4D5S9CQD";
        String pokers2 = "2C3D5S9CKD";

        int result = compare.compare(pokers1,pokers2);

        Assert.assertEquals(result,-1);
    }

    @Test
    public void should_pair_win_when_given_highcard_and_pair(){
        String pokers1 = "2H2D5S9CQD";
        String pokers2 = "2C3D5S9CKD";

        int result = compare.compare(pokers1,pokers2);

        Assert.assertEquals(result,1);
    }

    @Test
    public void should_bigPair_win_when_given_two_pairs(){
        String pokers1 = "2H2D5S9CKD";
        String pokers2 = "3C3D5S9CTD";

        int result = compare.compare(pokers1,pokers2);

        Assert.assertEquals(result,-1);
    }
}
