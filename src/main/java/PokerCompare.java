import java.util.List;

public class PokerCompare {

    private final int HIGH_CARD = 1;
    private final int PAIR = 2;
    private final int TWO_PAIRS = 3;
    private final int THREE_OF_A_KIND = 4;
    private final int STRAIGHT = 5;
    private final int FLUSH = 6;
    private final int FULL_HOUSE = 7;
    private final int FOUR_OF_A_KIND = 8;
    private final int STRAIGHT_FLUSH = 9;

    public Integer compare(String pokers1, String pokers2) {
        PokerHands pokerHands1 = new PokerHands(pokers1);
        PokerHands pokerHands2 = new PokerHands(pokers2);

        List<Integer> nums1 = pokerHands1.getNums();
        List<Integer> nums2 = pokerHands2.getNums();

        if (pokerHands1.calculateType() != pokerHands2.calculateType()) {
            return pokerHands1.calculateType() > pokerHands2.calculateType() ? 1 : -1;
        }
        switch (pokerHands1.calculateType()) {
            case PAIR:
            case TWO_PAIRS:
            case THREE_OF_A_KIND:
            case FOUR_OF_A_KIND: {
                int result = compareList(pokerHands1.getRepeatedNum(), pokerHands2.getRepeatedNum());
                removeRepeatedFromList(nums1, pokerHands1.getRepeatedNum());
                removeRepeatedFromList(nums2, pokerHands2.getRepeatedNum());
                return result == 0 ? compareList(nums1, nums2) : result;
            }
            case HIGH_CARD:
            case STRAIGHT:
            case FLUSH:
            case STRAIGHT_FLUSH: {
                return compareList(nums1, nums2);
            }
            case FULL_HOUSE: {
                int threeOfP1 = pokerHands1.getCountEqual(3);
                int threeOfP2 = pokerHands2.getCountEqual(3);
                if (threeOfP1 == threeOfP2) {
                    int twoOfP1 = pokerHands1.getCountEqual(2);
                    int twoOfP2 = pokerHands2.getCountEqual(2);
                    if (twoOfP1 == twoOfP2) {
                        return 0;
                    }
                    return twoOfP1 > twoOfP2 ? 1 : -1;
                }
                return threeOfP1 > threeOfP2 ? 1 : -1;
            }
            default:
                return null;
        }
    }

    public void removeRepeatedFromList(List<Integer> origin, List<Integer> repeated) {
        for (int i = 0; i < repeated.size(); i++) {
            for (int j = origin.size() - 1; j >= 0; j--) {
                if (origin.get(j).equals(repeated.get(i))) {
                    origin.remove(j);
                }
            }
        }
    }

    public int compareList(List<Integer> nums1, List<Integer> nums2) {
        for (int i = 0; i < nums1.size(); i++) {
            if (nums1.get(i) == null) {
                break;
            }
            if (nums1.get(i).equals(nums2.get(i))) ;
            else {
                return nums1.get(i) - nums2.get(i) > 0 ? 1 : -1;
            }
        }
        return 0;
    }

}
