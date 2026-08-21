class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num: nums) {
            if (seen.contains(num)) {
                return true;
            } else {
                seen.add(num);
            }
        }

        return false;
    }
}

/*
class Solution {
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
*/

/*
Time -> O(nlogn), Space -> O(n) or O(1)
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
*/