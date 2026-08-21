class Solution {
    //Time -> O(m*nlogn), Space -> O(m*n)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = Arrays.toString(c);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            } 
            map.get(key).add(str);
            
        }

        return new ArrayList<>(map.values());
    }
}

/*
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] count = new int[26];
            for (char c: str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            } 
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

class Solution {
    Time -> O(m*nlogn), Space -> O(m*n)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            } 
            map.get(key).add(str);
            
        }

        return new ArrayList<>(map.values());
    }
}
*/