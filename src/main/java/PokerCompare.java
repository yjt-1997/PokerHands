import java.util.List;

public class PokerCompare {

    public Integer compare(String pokers1, String pokers2) {
        PokerHands pokerHands1 = new PokerHands(pokers1);
        PokerHands pokerHands2 = new PokerHands(pokers2);

        List<Integer> nums1 = pokerHands1.getNums();
        List<Integer> nums2 = pokerHands2.getNums();

        if (pokerHands1.getPokerType() != pokerHands2.getPokerType()) {
            return pokerHands1.getPokerType() - pokerHands2.getPokerType() > 0 ? 1 : -1;
        }
        switch (pokerHands1.getPokerType()) {
            case 2:
                int result = compareList(pokerHands1.getRepeatedNum(), pokerHands2.getRepeatedNum());
                nums1.remove(pokerHands1.getRepeatedNum().get(0));
                nums2.remove(pokerHands2.getRepeatedNum().get(0));
                return result == 0 ? compareList(nums1, nums2) : result;
        }
        return compareList(nums1, nums2);
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
