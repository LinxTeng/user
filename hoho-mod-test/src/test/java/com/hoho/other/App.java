package com.hoho.other;

import java.text.DateFormat;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // TreeSet<String> aa = new TreeSet<>();
        // aa.add("abc2");
        // aa.add("abc5");
        // aa.add("abc4");
        // Iterator<String> iterator = aa.iterator();
        // while (iterator.hasNext()) {
        // String string = (String) iterator.next();
        // System.out.println(string);
        // }

        HashSet<String> aa = new HashSet<>();
        aa.add("abc2");
        aa.add("abc5");
        aa.add("abc4");

        Iterator<String> iterator = aa.iterator();
        while (iterator.hasNext()) {
            String string = (String) iterator.next();
            System.out.println(string);
        }

        // LinkedBlockingDeque<String> queue = new LinkedBlockingDeque();
        // queue.push("a");
        // queue.push("b");
        // queue.push("c");
        // System.out.println(queue.pop());
        // System.out.println(queue.pop());
        // queue.push("d");
        // System.out.println(queue.pop());

        // Stack<String> stack = new Stack<>();
        // stack.push("a");
        // stack.push("b");
        // stack.push("c");
        //
        // stack.pop();
        //
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // queue.push("d");
        // System.out.println(stack.pop());

        // PriorityQueue<String> pqueue = new PriorityQueue<>();
        // pqueue.add("4");
        // pqueue.add("2");
        // pqueue.add("3");
        //
        // Iterator<String> iterator2 = pqueue.iterator();
        // while (iterator2.hasNext()) {
        // String string = (String) iterator2.next();
        // System.out.println(string);
        // }
        //
        // Map<String, Object> map = new LinkedHashMap<>();

        // ArrayList<String> list = new ArrayList<>();
        // list.add("63");
        // list.add("64");
        // Iterator<String> iterator = list.iterator();
        // while (iterator.hasNext()) {
        // // list.remove(1);// 报concurrentModificationException
        // String string = (String) iterator.next();
        // // iterator.remove();
        // System.out.println(string);
        //
        // }
        // System.out.println(list);
        // HashMap<String, Object> map = new HashMap<>();
        // map.put("bb", "aa");
        // map.put("aa", "aa");
        //
        // Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
        // while (iterator.hasNext()) {
        // Map.Entry<java.lang.String, java.lang.Object> entry = (Map.Entry<java.lang.String,
        // java.lang.Object>) iterator.next();
        // System.out.println(entry.getValue());
        // }

        // HashSet<String> set = new HashSet<>();
        // set.add("aa");
        // set.add("aa");
        // Iterator<String> iterator = set.iterator();
        // while (iterator.hasNext()) {
        // String string = (String) iterator.next();
        // System.out.println(string);
        // }

        ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {

            @Override
            protected DateFormat initialValue() {
                // TODO Auto-generated method stub
                return super.initialValue();
            }

        };

    }
}
