class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        for (int i = 0;i < strs[0].length(); i++) {
            boolean valid = true;
            char curr_char = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1) {
                    valid = false;
                } else if (curr_char != strs[j].charAt(i)) {
                    valid = false;
                }
            }
            if (valid) {
                res += curr_char;
            } else {
                return res;
            }
        }

        return res;
    }
}