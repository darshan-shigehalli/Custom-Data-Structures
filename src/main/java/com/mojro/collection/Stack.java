package com.mojro.collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* This method is used to implement the stack through linkedlist, it also has some of the 
 * stack functionalities like push(),pop(),Peek(),Print() and etc.
 */
public class Stack<T> {
    private static final Logger logger=LoggerFactory.getLogger(Stack.class);
    /*
     * This class is to create the node which consists of next pointer and data of the node
     */
    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> next;
    Node<T> head;
    int data;

    /* This method is used to push the data into the stack */
    public void push(T data) {
        logger.info("Adding the node with the data {}",data);
        Node<T> node = new Node<T>(data);
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    /* This method is used to pop the data from the top of the stack */
    public T pop() {
        if (head == null) {
            throw new IllegalStateException("The stack is empty");
        }
        T result = head.data;
        head = head.next;
        return result;
    }

    /* This method is used to print the topmost or most recent element */
    public T peek() {
        if (head == null) {
            throw new IllegalStateException("The stack is empty");
        }
        logger.info("Peeking the stack");
        return head.data;
    }

    /* This method will print all the elements of the stack */
    public void print() {
        if (head == null) {
            throw new IllegalArgumentException("There is nothing to be printed");
        }
        logger.info("Printing the elements");
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
