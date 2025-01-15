package com.mojro.collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* This class is used to implement the queue using an array which also facilitates us with 
 * functionalities like add(),remove(),size(),print() and etc.Speciality of this implementation is
 * if the array is full of elements but also due to dequeuing some of the first few places may be 
 * empty, those places are also used for storing the elements.When no space is left then only 
 * it throws the error.
 */

public class CircularQueue {
    private static final Logger logger=LoggerFactory.getLogger(CircularQueue.class);
    int[] arr = new int[5];
    int rear = -1, front = -1;
    int size = 0;

    /* This method will help us to add the new node to the list. */
    public void enqueue(int data) {
        logger.info("The element {} is adding",data);
        if ((rear + 1) % arr.length == front) {
            throw new IllegalStateException("Queue is full");
        }
        if (size == 0) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % arr.length;
        }
        arr[rear] = data;
        size++;
    }

    /* This method is used to remove the node from the front part of queue. */
    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int result = arr[front];
        if (size == 1) {
            front = rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }
        logger.info("The element {} is being removed",result);
        size--;
        return result;
    }

    /* This method is used to print the data of all nodes */
    public void print() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        logger.info("Printing the elements");
        int num = front;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[num] + " ");
            num = (num + 1) % arr.length;
        }
        System.out.println();
    }

    /* This method is used to verify if the initial few spaces are used are not. */
    public void ArrayTraversal() {
        logger.info("traversing array for checking the circular queue implementation");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
