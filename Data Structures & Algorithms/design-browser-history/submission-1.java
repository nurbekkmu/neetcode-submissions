class BrowserHistory {

    private Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        node.prev = current;
        current.next = node;
        current = node;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && current.prev != null) {
            current = current.prev;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && current.next != null) {
            current = current.next;
        }
        return current.url;
    }

    private class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */