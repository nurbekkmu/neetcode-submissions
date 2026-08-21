class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        return false;
    }
}

/*
class Solution {
    Time -> O(n), Space -> O(n)
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

*/
