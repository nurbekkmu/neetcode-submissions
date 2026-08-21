class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num: map.keySet()) {
            buckets[map.get(num)].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for (int num: buckets[i]) {
                res[index++] = num;
                if (index == k) return res;
            }
        }
        return res;
    }
}

/*
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[][] frequency = new int[map.size()][2];
        int index = 0;
        for (Integer key: map.keySet()) {
            frequency[index][0] = key;
            frequency[index++][1] = map.get(key);
        }

        Arrays.sort(frequency, (a, b) -> b[1] - a[1]);
        for (int i = 0; i < k; i++) {
            res[i] = frequency[i][0];
        }
        return res;
    }
}
*/
