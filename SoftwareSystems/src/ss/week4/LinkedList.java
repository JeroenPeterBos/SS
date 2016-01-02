package ss.week4;

import java.util.List;

public class LinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node first;

    //@ ensures \result.size == 0;
    public LinkedList () {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    //@ ensures this.size == \old(size) - 1;
    public void remove(Element element) {
        Node n = findBefore(element);
        if(n == null){
        	first = first.next;
        	size--;
        	return;
        }
        n.next = n.next.next;
        size--;
    }

    public Node findBefore(Element element) {
    	Node p = first;
        while(p.next != null){
        	if(p.next.getElement().equals(element)){
        		return p;
        	}
        	p = p.next;
        }
        return null;
    }

    //@ requires 0 <= index && index < this.size();
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
    
    public static void main(String[] args){
    	LinkedList<Object> list = new LinkedList<>();

        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        list.add(0, object1);
        list.add(1, object2);
        list.add(2, object3);
        
        System.out.println(list.findBefore(object2));
    }
}
