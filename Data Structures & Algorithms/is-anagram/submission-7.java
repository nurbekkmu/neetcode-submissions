class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] storage = new int[200];
        for (int i = 0; i < s.length(); i++) {
            storage[s.charAt(i)]++;
            storage[t.charAt(i)]--;
        }

        for (int store: storage) {
            if (store != 0) {
                return false;
            }
        }

        return true;
    }
}
