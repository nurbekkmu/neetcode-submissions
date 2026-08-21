class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] storage = new int[26];
        for (int i = 0; i < s.length(); i++) {
            storage[s.charAt(i) - 'a']++;
            storage[t.charAt(i) - 'a']--;
        }

        for (int store: storage) {
            if (store != 0) {
                return false;
            }
        }

        return true;
    }
}
