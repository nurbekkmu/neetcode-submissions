class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            List<String> list = new ArrayList<>();
            if (map.containsKey(key)) {
                list = map.get(key);
            } 
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
