import java.lang.Math;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {

    Node start, head;

    LinkedList() {
        this.head = null;
        this.start = null;
    }

    LinkedList(int data) {
        this.head = new Node(data);
        this.start = this.head;
    }

    public void addData(int data) {
        Node new_node = new Node(data);
        if(this.head != null) {
            this.head.next = new_node;
            this.head = new_node;
        }
        else {
            this.head = new Node(data);
            this.start = this.head;
        }
    }

    public void addCommonNode(Node new_node) {
        if(this.head != null) {
            this.head.next = new_node;
            this.head = new_node;  
        }
        else {
            this.head = new_node;
            this.start = this.head;
        }
    }

    public int getSize() {
        int count = 0;
        Node current = this.start;
        while(current != null) {
            current = current.next;
            count += 1;
        }
        return count;
    }

}

public class FindIntersection {

    public static int findIntersection (LinkedList headA, LinkedList headB) {

        int count1 = headA.getSize();
        int count2 = headB.getSize();

        int offset = Math.abs(count1-count2);
        Node current1 = headA.start;
        Node current2 = headB.start;

        if(count2 > count1) {
            while(offset > 0) {
                current2 = current2.next;
                offset -= 1;
            }
        }
        else {
            while(offset > 0) {
                current1 = current1.next;
                offset -= 1;
            }
        }
        while (current1 != null && current2 != null) {
            if(current1 == current2) {
                return current1.data;
            }
            else {
                current1 = current1.next;
                current2 = current2.next;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        LinkedList listA = new LinkedList(5);
        LinkedList listB = new LinkedList();

        listA.addData(31);
        listA.addData(13);
        listA.addData(88);

        Node new_node1 = new Node(3);
        Node new_node2 = new Node(17);
        Node new_node3 = new Node(10);
        Node new_node4 = new Node(7);

        // list A is 5->31->13->88->3->17->20->14
        listA.addCommonNode(new_node1);
        listA.addCommonNode(new_node2);
        listA.addCommonNode(new_node3);
        listA.addCommonNode(new_node4);
        
        // list B is 3->17->20->14
        listB.addCommonNode(new_node1);
        listB.addCommonNode(new_node2);
        listB.addCommonNode(new_node3);
        listB.addCommonNode(new_node4);

        // intersection starts at 3 (31 is not the same node, though both have linked list have elements with value 31)
        System.out.println("The data of the first common element is : " + findIntersection(listA, listB));
    }
}