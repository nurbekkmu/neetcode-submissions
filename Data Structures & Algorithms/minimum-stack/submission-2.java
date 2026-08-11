class MinStack {

    private List<Integer> list = new ArrayList();

    public MinStack() {
        
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.remove(list.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int num: list) {
            min = Integer.min(num, min);
        }
        return min;
    }
}
