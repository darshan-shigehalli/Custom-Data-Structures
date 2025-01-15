package com.mojro.collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* This class is implementing the heterogeneous singly liked list. Add(),remove(),print(),
 * size() and etc functionalities are implemented.*/
public class LinkedList<T> extends List {
    private static final Logger logger=LoggerFactory.getLogger(LinkedList.class);
    private Node<T> head = null;

    /*
     * This class is to create the node which consists of next pointer and data of
     * the node
     */
    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /* Adds the new node to the list*/
    public void add(T data) {
        logger.info("Adding the node with the data {}",data);
        if (data == null) {
            throw new IllegalArgumentException("null values cannot be entertained");
        }
        Node<T> newNode = new Node<>(data);
        updateSize(1);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /* Returns the value of the node at the index given. */
    public T get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalStateException("Invalid index");
        }
        logger.info("returning the data at the index at index {}",index);
        Node<T> temp = head;
        // int count=-1;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /* This method is used to check whether the element is present ot not. */
    public boolean isPresent(T data) {
        if (data == null) {
            throw new IllegalArgumentException("null values cannot be entertained");
        }
        logger.info("checking whether the element with data {} is present or not",data);
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

    /* This method is used to add the element at the specified index. */
    public void addAtIndex(int index, T data) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalStateException("Invalid index");
        }
        if (data == null) {
            throw new IllegalArgumentException("null values cannot be entertained");
        }
        logger.info("Adding the node with the data {} at an index {}",data,index);
        Node<T> node = new Node<>(data);
        updateSize(1);
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    /* This method tries to print data of evey node. */
    public void print() {
        if (head == null) {
            throw new IllegalStateException("No elements are there to print");
        }
        logger.info("Printing the data in the list");
        Node<T> temp = head;
        System.out.print("The elements are: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /*
     * This particular method will remove the elements of the list based on the
     * index passed as an argument
     */
    public void remove(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalStateException("Invalid index");
        }
        logger.info("Removing the element at the index {}",index);
        updateSize(-1);
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
}
