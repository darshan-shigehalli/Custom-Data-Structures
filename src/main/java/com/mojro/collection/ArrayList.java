package com.mojro.collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* This class is the implementation of the Arraylist where I have implemented adding,
 * removing and printing the elements.Also it has the length(),size() and get functionality.
 */

public class ArrayList<T> extends List {

    private T[] arr;
    private static final Logger logger=LoggerFactory.getLogger(ArrayList.class);
    /* This constructor will initialize the array to size 10. It first create the
    * array of Object type and then it will be casted to the T type.*/
    public ArrayList() {
        arr = (T[]) new Object[10];
        logger.info("The array is created");
    }

    /* This method is to add the elements to the list */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("null values cannot be entertained");
        }
        if (getSize() == arr.length - 1) {
            resize();
            logger.info("Resizing is happening");
        }
        arr[getSize()] = data;
        updateSize(1);
        logger.info("The element is added to the ArrayList");
    }

    /* This method is used to add the element at a specific index. */
    public void addAtIndex(int index, T data) {
        if (index > arr.length || index < 0) {
            throw new IllegalStateException("Invalid index");
        }
        if (data == null) {
            throw new IllegalArgumentException("null values cannot be entertained");
        }
        if (getSize() == arr.length) {
            resize();
            logger.info("Resizing is happening");
        }
        updateSize(1);
        for (int i = getSize() - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = data;
        logger.info("The array is added to the index");
    }

    /* This method will return the element based on the index passed. */
    public T get(int index) {
        if (index >= getSize() || index < 0) {
            throw new IllegalStateException("Invalid index");
        }
        logger.trace("The element is returned");
        return (T) arr[index];
    }

    /* This method checks whether the given parameter is present in the arraylist or not .*/
    public int isPresent(T data) {
        for (int i = 0; i < getSize(); i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    /* When the arraylist is full , array gets resized to it's double size. */
    public void resize() {
        logger.info("Resizing is about to happening");
        T[] temp = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    /* Removing the element from the list. */
    public void remove(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalStateException("size given is invalid");
        }

        for (int i = index; i <= getSize(); i++) {
            arr[i] = arr[i + 1];
        }
        updateSize(-1);
        logger.debug("The element is being removed");
    }

    /* Printing all the elements of arraylist */
    public void print() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(arr[i] + " ");
        }
        logger.trace("the elements are printing");
        System.out.println();
    }
}
