class Node {
    int data;
    Node prev;
    Node next;

    Node (int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    Node (int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    DoublyLinkedList () {
        head = null;
        tail = null;
    }

    public void insert (int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            return;
        }

        tail.next = new Node(data);
        tail.next.prev = tail;
        tail = tail.next;
    }
}
