package com.alphacoder.datastructure;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LinkedList {
    private Node head;
    private int size;

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return this.size;
    }

    public void insert(int element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = new Node();
        node.setData(element);
        Node temp = head;

        if (head == null) {
            head = node;
            node.setPrevious(null);
            node.setNext(null);
        } else {
            if (index == 0) {
                insertAtIndexZero(node);
            } else {
                for (int i = 0; i < index; i++) {
                    temp= temp.getNext();
                }

                if(index== size){
                    insertAtLast(node, temp);
                }else{
                    temp.getPrevious().setNext(node);
                    node.setNext(temp);
                    node.setPrevious(temp.getPrevious());
                    temp.setPrevious(node);
                }
            }

        }
        this.size++;
    }

    private void insertAtIndexZero(Node node) {
        node.setNext(this.head);
        node.setPrevious(null);
        this.head.setPrevious(node);
        this.head = node;
    }

    private void insertAtLast(Node node, Node last){
        last.setNext(node);
        node.setPrevious(last);
        node.setNext(null);
    }
}
