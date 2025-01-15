package com.mojro.collection;
import com.mojro.collection.*;

public class Main {
    public static void main(String[] args) {

//         HashMap<String, Integer> map = new HashMap<>();
//         map.put("Alice", 30);
//         map.put("Bob", 25);
//         map.put("Charlie", 35);
//         System.out.println("Alice's age: " + map.get("Alice"));
//         System.out.println("Bob's age: " + map.get("Bob"));
//         System.out.println(map.get("Charlie"));

         CircularQueue q = new CircularQueue();
         q.enqueue(10);
         q.enqueue(20);
         q.enqueue(30);
         q.enqueue(40);
         q.enqueue(50);
         q.print();
         System.out.println(q.dequeue());
         q.print();
         q.dequeue();
         q.dequeue();
         q.dequeue();
         q.print();
         q.enqueue(90);
         q.enqueue(100);
         q.enqueue(110);
         q.enqueue(120);
         q.print();
         q.ArrayTraversal();

//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         System.out.println(list.getSize());
//         list.print();
//         list.remove(2);
//         list.print();
//         list.addAtIndex(7, 56);
//         list.print();
//         System.out.println(list.isPresent(20));
//         System.out.println(list.get(0));
//
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//
//        list.print();
//        try {
//            list.add(null);
//        } catch (Exception e) {
//            System.out.println("Exception occurred" + e);
//        }
//        finally{
//            System.out.println("heyy");
//        }
//        list.remove(1);
//        list.print();
//        System.out.println(list.getSize());
//        System.out.println(list.get(1));
//        System.out.println(list.isPresent(100));
//        list.addAtIndex(02, 56);
//        list.print();
//
//         DoublyLinkedList<String> list = new DoublyLinkedList<>();
//         list.add("dar1");
//         list.add("dar2");
//         list.add("dar3");
//         list.add("dar4");
//         list.add("dar5");
//         list.print();
//         list.remove(2);
//         list.print();
//         list.ReversePrint();
//         System.out.println(list.getSize());
//         System.out.println(list.isPresent("dar10"));
//         System.out.println(list.get(1));
//         list.addAtIndex(2, "dar");
//         list.print();
//
//         Stack<Integer> stackobj = new Stack<>();
//         stackobj.push(10);
//         stackobj.push(20);
//         stackobj.push(30);
//         stackobj.push(40);
//         stackobj.push(50);
//         stackobj.print();
//         System.out.println(stackobj.pop());
//         stackobj.print();
//         System.out.println(stackobj.peek());

    }
}