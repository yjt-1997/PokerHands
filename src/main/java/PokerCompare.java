import java.util.List;

public class PokerCompare {

    public Integer compare(String pokers1, String pokers2) {
        PokerHands pokerHands1 = new PokerHands(pokers1);
        PokerHands pokerHands2 = new PokerHands(pokers2);

        List<Integer> nums1 = pokerHands1.getNums();
        List<Integer> nums2 = pokerHands2.getNums();

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
