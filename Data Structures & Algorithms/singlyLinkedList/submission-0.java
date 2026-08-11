class LinkedList {

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {

    }

    public int get(int index) {
        Node current = head;
        while (current != null && index-- > 0) {
            current = current.next;
        }
        return current != null ? current.value : -1;
    }

    public void insertHead(int val) {
         Node node = new Node(val);
         node.next = head;
         head = node;
         if (tail == null) {
         tail = node;
     }
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(int index) {
    if (head == null) return false;
    
    if (index == 0) {
        head = head.next;
        if (head == null) tail = null;  // List became empty
        return true;
    }
    
    Node current = head;
    while (current.next != null && --index > 0) {
        current = current.next;
    }
    
    if (current.next == null) return false;  // Index out of bounds
    
    if (current.next == tail) {
        tail = current;  // Removing the tail node
    }
    current.next = current.next.next;
    return true;
}

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }
        return list;
    }
}
