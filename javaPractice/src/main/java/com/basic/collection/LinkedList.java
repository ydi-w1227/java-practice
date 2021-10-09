package com.basic.collection;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Iterator;
/**
 * Class for implementing linked list methods
 *
 * @author Yongdi Wang
 *
 */

public class LinkedList<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Class for implementing node in linked list
     */
      static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }

        /**
         * Print out node info.
         *
         * @return void
         */
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }

        /**
         * Get data
         *
         * @return data
         */
        public T getData() {
            return data;
        }

        /**
         * Get data of previous node
         *
         * @return previous Node's data
         */
        public Node<T> getPrev() {
            return prev;
        }

        /**
         * Get data of next node
         *
         * @return next Node's data
         */
        public Node<T> getNext() {
            return next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

    /**
     * Check if linked list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    /**
     * Add Node node at the last linked list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Get node at the index
     *
     * @param index
     * @return the node at index
     */
    public Optional<Node<T>> getNode(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Invalid Index");
        }
        if (index + 1 > getSize()) {
            throw new IndexOutOfBoundsException("Index Exceed List Length");
        }
        Node<T> current = head;
        // while not reach to end of the list
        while (current != null) {
            if (index == 0) {
                break;
            }
            current = current.next;
            index--;
        }
        return Optional.ofNullable(current);
    }

    /**
     * Get middle node of the linked list
     *
     * @return middle node of the list if the size is odd, further middle node of the list if the size is even.
     * i.e. length = 3, 0->1->2, middle node index = 1.
     *      length = 4, 0->1->2->3, middle node index = 2.
     */
    public Optional<Node<T>> getMiddle() {
        Node<T> fast = head;
        Node<T> slow = head;
        // if list is empty then return head => null
        // if not, then return head => middle node
        // when fast points to null (finish the list) or points to last node of the list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return Optional.ofNullable(slow);
    }

    /**
     * Add Node node at the tail of the linked list.
     *
     * <p>Use {@link #addLast(Object data)} to add at the last linked list.
     *
     * @param data to add at the last of the list
     * @return true if added successfully
     */
    public Boolean addLast(T data) {
        Node<T> node = new Node(data);
        if(isEmpty()) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        size++; // increase size of linked list
        return true;
    }

    /**
     * * Remove last node from linked list
     *
     * @return tail node of the list
     */

//    public Optional<Node> removeLast() {
//        if(head.next != null) {
//            Node newLastNode = tail.prev;
//            newLastNode.next = null; // remove
//            tail.prev = null; // remove
//            tail = newLastNode; // update tail pointer
//        } else {
//            emptyList();
//        }
//        size--;
//        return Optional.ofNullable(tail);
//    }

    /**
     * Add Node node at the start of the linked list.
     *
     * <p>Use {@link #addStart(Node node)} to add at the last linked list.
     *
     * @param node to add at the start of the list
     * @return true if added successfully
     */
//    public Boolean addStart(Node node) {
//        if(isEmpty()){
//            firstNode(node);
//        } else {
//            // head points to later node, add node before the node that head pointer points to
//            node.next = head;
//            node.prev = null;
//            head.prev = node;
//            head = node; // update head pointer
//        }
//        size++;
//        return true;
//    }

    /**
     * Remove node from start of the linked list
     *
     * @return head of the list
     */
//    public Optional<Node> removeStart() {
//        if(head.next != null) {
//            Node newFirstNode = head.next;
//            head.next = null; // remove
//            newFirstNode.prev = null; // remove
//            head = newFirstNode; // update first
//        } else {
//            emptyList();
//        }
//        size--;
//        return Optional.ofNullable(head);
//    }

    /**
     * Add Node node at the index (i th) of linked list.
     *
     * @param data to add
     * @param index to insert in list
     */
    public void add(T data, int index) {
        int length = getSize();
        Node<T> node = new Node(data);

        if (index < 0) {
            throw new IllegalArgumentException("Invalid Index");
        }
        // give index more than length
        if (index > length) {
            throw new IndexOutOfBoundsException("Index Exceed List Length");
        }
        // Empty list
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            Node<T> current = head;

            while (index > 0) {
                current = current.next;
                index--;
            }
            // if current doesnt point to any node, add last
            if (current == null) {
                node.prev = tail;
                node.next = null;
                tail = node;
            } else {
                // index between 0 and size, not include index == size (add last)
                if ( current.prev != null) { // not the first node
                    //setup with previous node
                    current.prev.next = node;
                    node.prev = current.prev;
                } else { // first node
                    head = node;
                    node.prev = null;
                }
                // set up with the node after
                node.next = current;
                current.prev = node;
            }
        }
        size++;
    }

    /**
     *
     * @param index to remove
     * @return the element previously at the specified position (deleted one)
     */
//    public Optional<Node> remove(int index) {
//        int length = getSize();
//        Node deletedNode = null;
//        if(isEmpty()){
//            System.out.println("No elements in list");
//        } else if (index < 0) {
//            System.out.println("Invalid index");
//        } else {
//            if (index == 0) {
//                deletedNode = head;
//                // add first
//                removeStart();
//            } else if (index == length) {
//                deletedNode = tail;
//                // add last
//                removeLast();
//            } else {
//                Node deletePoint = head;
//                // find element at index
//                while (index > 0) {
//                    deletePoint = deletePoint.next;
//                    if (deletePoint == null) {
//                        System.out.println("Invalid index: exceed the length");
//                        break;
//                    }
//                    index--;
//                }
//                Node previous = deletePoint.prev;
//                deletedNode = deletePoint;
//                // set up previous and next node
//                previous.next = deletePoint.next;
//                deletePoint.next.prev = previous;
//                // remove
//                deletePoint.prev = null;
//                deletePoint.next = null;
//            }
//        }
//        return Optional.ofNullable(deletedNode);
//    }

    /**
     *
     * Add Node node at the index (i th) of linked list.
     *
     * <p>Use {@link #add(Node node, int index)} to add at the last linked list.
     *
     * @param node to add
     * @param index to insert
     * @return true if add successfully.
     */
//    public void optimizedAdd(Node node, int index) {
//        int length = getSize();
//        System.out.println("index is: " +  index);
//        System.out.println("length is: " +  length);
//
//        if(isEmpty()){
//            firstNode(node);
//            size++;
//        } else if (index < 0) {
//            System.out.println("Invalid index");
//        } else {
//            if (index == 0) {
//                // add first
//                addStart(node);
//            } else if (index == length) {
//                // add last
//                addLast(node);
//            } else if (index + 1 > length){
//                // if index larger than the whole list
//                System.out.println("Invalid index: exceed the length");
//            } else {
//                // if index between 0 and size, then find the position
//                int middleIndex = length / 2;
//                Boolean firstHalf = (index < middleIndex) ? true : false;
//                Node insertPoint = (firstHalf) ? head : tail;
//                int step = (firstHalf) ? index : length - index - 1;
//                while(step > 0) {
//                    insertPoint = (firstHalf) ? insertPoint.next : insertPoint.prev;
//                    step--;
//                }
//                Node pointBefore = insertPoint.prev;
//                //setup with previous node
//                pointBefore.next = node;
//                node.prev = pointBefore;
//                // set up with the node after
//                node.next = insertPoint;
//                insertPoint.prev = node;
//                size++;
//            }
//        }
//    }

}



class ListIterator<T> implements Iterator<T> {
    // if Node is not inner class, can be Node<T>
    // if Node is inner class, then LinkedList<T>.Node<T>
    // or make it static inner class, then can be LinkedList.Node<T>
    // maybe because T in Node doesnt dependent on LinkedList's T
    LinkedList.Node<T> current;

    public ListIterator(LinkedList<T> list) {
        current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current.getNext() != null;
    }

    public boolean hasPrev() {
        return current.getPrev() != null;
    }

    @Override
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    public T prev() {
        T data = current.getData();
        current = current.getPrev();
        return data;
    }
};

