class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String operation: operations) {
            if ("C".equals(operation)) {
                stack.pop();
            }
            else if ("D".equals(operation)) {
                stack.push(stack.peek() * 2);
            } 
            else if ("+".equals(operation)) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            } 
            else {
                stack.push(Integer.parseInt(operation));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}