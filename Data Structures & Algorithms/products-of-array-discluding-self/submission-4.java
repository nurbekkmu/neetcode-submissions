class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }

        return nums;
    }
} 

/*
class Solution {
    Time -> O(n^2), Space -> O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            res[i] = product;
        }
        return res;
    }
} 
*/
