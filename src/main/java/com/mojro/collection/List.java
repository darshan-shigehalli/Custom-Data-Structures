package com.mojro.collection;

/* This class is the parent class of all list type data structures and it consists of common 
 * methods which are used in all data structures.
 */
public class List {
    private int size;

    public int getSize() {
        /* This method is used to get the number of elements in list */
        return size;
    }

    public void updateSize(int data) {
        /* This method is set the number of elements */
        this.size = this.size + data;
    }

}
