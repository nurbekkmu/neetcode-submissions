class MyLinkedList {

    private Node head;
    private Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        if (index < 0) return -1;
        Node current = head;
        while (current != null && index-- > 0) {
            current = current.next;
        }
        return (current != null) ? current.value : -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) return;
        if (index == 0) { addAtHead(val); return; }

        Node current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (count < index) return; // index > length
        if (current == null) {
            addAtTail(val);
            return;
        }

        Node node = new Node(val);
        node.next = current;
        node.prev = current.prev;
        current.prev.next = node; // current.prev can't be null here since index != 0
        current.prev = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0) return;

        Node current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (current == null) return;

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int val) {
            this.value = val;
        }
    }
}