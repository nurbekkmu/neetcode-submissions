class Solution {
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        n--;
        while (n-- > 0) {
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }
}
