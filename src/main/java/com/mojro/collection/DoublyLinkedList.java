package com.mojro.collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* This class tries to implement the heterogeneous doubly linkedlist which have some of the
 * functions like add(),remove(),print(),reverseprint(),size() and etc.
 */
public class DoublyLinkedList<T> extends List {
    private static final Logger logger=LoggerFactory.getLogger(DoublyLinkedList.class);
    Node<T> head = null;

    /*
     * This class is to define the nodes which holds next and prev pointer and the
     * data
     * of the node.
     */
    private class Node<T> {
        Node<T> next;
        Node<T> prev;
        T data;

        Node(T data) {
            next = null;
            prev = null;
            this.data = data;
        }
    }

    /* This method will add the new node to the list. */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("null values cannot be entertained");
        }
        logger.info("Adding a node with data {}",data);
        Node<T> node = new Node(data);
        updateSize(1);
        if (head == null) {
            head = node;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            node.prev = temp;
            temp.next = node;
        }
    }

    /* This method used to add the element at the given index of the linkedlist*/
    public void addAtIndex(int index, T data) {
        logger.info("The element {} is adding at an index {}",data,index);
        if (index > getSize() || index < 0) {
            throw new IllegalStateException("Invalid Index");
        }
        if (data == null) {
            throw new IllegalArgumentException("null values cannot be entertained");
        }
        Node<T> node = new Node<>(data);
        updateSize(1);
        if (index == 0) {
            head.prev = node;
            node.next = head;
            head = node;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        node.prev = temp;
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
    }

    /* This below method is used to check whether the parameter is present in the
    * list or not. */
    public boolean isPresent(T data) {
        if (data == null) {
            throw new IllegalArgumentException("null values cannot be entertained");
        }
        logger.info("Checking the element {} is there or not",data);
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    /* This method will remove the node which is present at the given index. */
    public void remove(int index) {
        if (head == null || head.next == null) {
            throw new IllegalStateException("No nodes are present to delete");
        }
        if (index < 0 || index >= getSize()) {
            throw new IllegalStateException("Invalid index");
        }
        logger.info("Removing the element from index {}",index);
        updateSize(-1);
        if (index == 0) {
            head = head.next;
            return;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next.next.prev = temp;
        temp.next = temp.next.next;

    }

    /*This method will return the value of the node at the index.*/
    public T get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalStateException("Invalid index");
        }
        logger.info("Returning the element at the index {}",index);
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /* This method helps us to print the data of every node */
    public void print() {
        if (head == null) {
            throw new IllegalStateException("No elements are present");
        }
        logger.info("Printing the elements of DLL");
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /*
     * As it is the doubly linked list, we can also traverse in reverse order,
     * which exactly what this specific method does.
     */
    public void ReversePrint() {
        Node<T> temp = head;
        logger.info("Printing in the reverse order to ensure the double link of the list");
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}
