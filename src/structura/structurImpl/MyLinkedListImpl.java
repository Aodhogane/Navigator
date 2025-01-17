package structura.structurImpl;

import structura.LinkedList;
import structura.MyIterator;

import java.util.Objects;

public class MyLinkedListImpl<T> implements LinkedList<T> {

    private Node<T> head, tail;
    private int size;

    private static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data){
            this.data = data;
        }
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T get(int index){
        Node<T> current = head;
        for (int i=0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void remove(T value) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, value)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
