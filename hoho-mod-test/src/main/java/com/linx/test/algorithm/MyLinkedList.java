package com.linx.test.algorithm;

import org.omg.CORBA.Any;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyLinkedList<AnyType> implements  Iterable<AnyType>{
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    private MyLinkedList() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    // 删除
    private AnyType remove(Node<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    private static class Node<AnyType> {
        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }
        private AnyType data;
        private Node<AnyType> prev;
        private Node<AnyType> next;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return this.new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public AnyType next() {
            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedModCount++ ;
            okToRemove = false;
        }
    }

    public static void main(String[] args) {
        //构建一个list
        MyLinkedList<String> list = new MyLinkedList();
        //添加几个元素
        list.addBefore(list.endMarker, "AA");
        list.addBefore(list.endMarker, "BB");
        list.addBefore(list.endMarker, "CC");

        Iterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        // 删除两次
        iterator.remove();
        iterator.remove();
    }
}
