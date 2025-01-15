package com.mojro.collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;

// Custom implementation of a HashMap
public class HashMap<K, V> {
    private static final Logger logger=LoggerFactory.getLogger(HashMap.class);
    // Node to represent each key-value pair
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>>[] buckets;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size;

    // Constructor
    public HashMap() {
        logger.info("Creating the hashmap");
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Hash function
    private int getBucketIndex(K key) {
        logger.info("Getting the index to map the value.");
        int hashCode = (key == null) ? 0 : key.hashCode();
        return Math.abs(hashCode % buckets.length);
    }

    // Put a key-value pair into the map
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        logger.info("Adding pair to the hashmap");
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if the key already exists
        for (Node<K, V> node : buckets[index]) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                node.value = value;
                return;
            }
        }

        // Add new node if key does not exist
        buckets[index].add(new Node<>(key, value));
        size++;

    }

    // Get the value associated with a key
    public V get(K key) {
        logger.info("Returning the value associated with the key {}",key);
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Node<K, V> node : buckets[index]) {
                if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                    return node.value;
                }
            }
        }
        return null;
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            Node<K, V> targetNode = null;
            logger.info("Removing the pair from the hashmap");
            for (Node<K, V> node : buckets[index]) {
                if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                    targetNode = node;
                    break;
                }
            }
            if (targetNode != null) {
                buckets[index].remove(targetNode);
                size--;
            }
        }
    }

    // Check if the map contains a key
    public boolean containsKey(K key) {
        logger.info("Checking whether the key:{} is present or not",key);
        return get(key) != null;
    }

    // Get the number of key-value pairs
    public int size() {
        logger.info("Returning the size of the hashmap.");
        return size;
    }
}