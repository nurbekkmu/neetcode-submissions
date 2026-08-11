class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = Map.of(
            ')', '(', 
            ']', '[', 
            '}', '{'
        );
        
        for (char c : s.toCharArray()) {
            // If it's a closing bracket, check for match; if opening, push
            if (bracketMap.containsKey(c) && (stack.isEmpty() || stack.pop() != bracketMap.get(c))) {
                return false;
            } else if (!bracketMap.containsKey(c)) {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}