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
            }
            else if (index== this.size){
                insertAtLast(node);
            }
            else {
                for (int i = 0; i < index; i++) {
                    temp= temp.getNext();
                }
                    temp.getPrevious().setNext(node);
                    node.setNext(temp);
                    node.setPrevious(temp.getPrevious());
                    temp.setPrevious(node);
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

    private void insertAtLast(Node node){
        Node last= head;

        for(int i=0; i<this.size-1; i++){
            last= last.getNext();
        }
        last.setNext(node);
        node.setPrevious(last);
        node.setNext(null);
    }

    public int get(int index){
        if(index< 0 || index>= size){
            throw new IndexOutOfBoundsException();
        }
        Node temp= head;

        for(int i=0; i<index; i++){
            temp= temp.getNext();
        }

        return temp.getData();
    }
}
