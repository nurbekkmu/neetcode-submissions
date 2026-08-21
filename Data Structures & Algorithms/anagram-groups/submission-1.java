class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list: map.values()) {
            res.add(list);
        }

        return res;
    }
}
