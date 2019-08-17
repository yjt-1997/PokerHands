import java.util.*;

public class PokerHands {

    private String pokerHands;
    private List<Integer> nums = new ArrayList<>();
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

    public Map getDuplicateMap() {
        Map<Integer, Integer> numsMap = new HashMap<>();
        nums.forEach(num -> {
            if (!numsMap.containsKey(num)) {
                numsMap.put(num, 1);
            } else {
                Integer count = numsMap.get(num) + 1;
                numsMap.put(num, count);
            }
        });
        return numsMap;
    }

    public List<Integer> getRepeatedNum() {
        List<Integer> repeatedNums = new ArrayList<>();
        Map<Integer, Integer> numsMap = getDuplicateMap();
        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            if (entry.getValue() > 1) {
                repeatedNums.add(entry.getKey());
            }
        }
        Collections.sort(repeatedNums);
        Collections.reverse(repeatedNums);
        return repeatedNums;
    }

    public int getPokerType() {
        Map<Integer, Integer> numsMap = getDuplicateMap();
        switch (numsMap.size()) {
            case 3:
                    return getRepeatedNum().size() == 2 ? PokersType.TWO_PAIRS.getType() : PokersType.THREE_OF_A_KIND.getType();
            case 4:
                return PokersType.PAIR.getType();
            case 5:
//                return PokersType.HIGH_CARD.getType();
            default:
                return PokersType.HIGH_CARD.getType();
        }
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
