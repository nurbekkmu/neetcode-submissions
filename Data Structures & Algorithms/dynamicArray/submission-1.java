class DynamicArray {

    private int[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (len == capacity) {
            this.resize();
        }

        arr[len] = n;
        len++;
    }

    public int popback() {
        int element = this.arr[len - 1];
        this.arr[len - 1] = 0;
        len--;
        return element;
    }

    private void resize() {
        this.capacity = 2 * this.capacity;
        int[] newArr = new int[capacity];

        for (int i = 0; i < len; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return this.len;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
