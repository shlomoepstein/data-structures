class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        next = null;
    }

    Node (int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    private Node head;

    LinkedList () {
        head = null;
    }

    public void insert (int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }

    public void display () {
        Node current = head;

        if (current != null) {
            System.out.print(current.data);
            current = current.next;
        }

        while (current != null) {
            System.out.print(", " + current.data);
            current = current.next;
        }

        System.out.println();
    }

    public void delete (int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean isEmpty () {
        return head == null;
    }
}

class LinkedListTest {
    public static void main(String[] args) {
        LinkedList newList = new LinkedList();

        System.out.println(newList.isEmpty());
        newList.insert(27);
        newList.insert(42);
        newList.insert(55);
        newList.insert(69);
        newList.insert(33);
        System.out.println(newList.isEmpty());
        newList.display();
        newList.delete(27);
        newList.display();
        newList.delete(33);
        newList.display();
        newList.delete(55);
        newList.display();
    }
}
