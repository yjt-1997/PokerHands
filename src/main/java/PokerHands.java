import java.util.*;

public class PokerHands {

    private String pokerHands;
    private List<Integer> nums = new LinkedList<>();
    private Set<String> colors = new HashSet<>();

    public PokerHands(String pokerHands) {
        char[] chars = pokerHands.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                nums.add(getNum(chars[i]));
            } else {
                colors.add(String.valueOf(chars[i]));
            }
        }
        Collections.sort(nums);
        Collections.reverse(nums);
    }

    public static Integer getNum(char ch) {
        switch (ch) {
            case 'T':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return Integer.parseInt(String.valueOf(ch));
        }
    }

    public int getDuplicateLength() {
        return new HashSet<Integer>(nums).size();
    }

    public int getPokerType() {
        if (getDuplicateLength() == 4) {
            return PokersType.PAIR.getType();
        }
        return PokersType.HIGH_CARD.getType();
    }


    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }

    public Set<String> getColors() {
        return colors;
    }

    public void setColors(Set<String> colors) {
        this.colors = colors;
    }
}
