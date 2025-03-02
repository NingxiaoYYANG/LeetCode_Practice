import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanToInt = new HashMap<Character, Integer>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        int prevValue = romanToInt.get(s.charAt(0));

        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);

            int currValue = romanToInt.get(currChar);
            if (prevValue >= currValue) {
                res += prevValue;
            } else {
                res -= prevValue;
            }

            prevValue = currValue;
        }

        res += prevValue;

        return res;
    }
}