package com.alphacoder.datastructure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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

    public void delete(int index){
        if(index< 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        if(index== 0){
            if(null!= head.getNext()) {
                head.getNext().setPrevious(null);
            }
            head= head.getNext();
        }else if(index== this.size-1){
            deleteAtLastIndex();
        }else{
            Node temp= head;
            for(int i=0; i<index; i++){
                temp= temp.getNext();
            }
            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
        }
        size--;
    }

    private void deleteAtLastIndex(){
        Node temp= head;
        for(int i=0; i< this.size-1; i++){
            temp= temp.getNext();
        }
        temp.getPrevious().setNext(null);
    }

    public void update(int element, int index){
        if(index<0 || index>= this.size){
            throw new IndexOutOfBoundsException();
        }

        Node temp= head;

        for(int i=0; i<index; i++){
            temp= temp.getNext();
        }

        temp.setData(element);
    }

    public void print(){
        Node temp= head;
        System.out.println(" ");
        while(temp!= null){
            System.out.print(" ");
            System.out.print(temp.getData());
            temp= temp.getNext();
        }
    }

    public void printRecursively(Node head){
        if(head== null){
            return;
        }

        System.out.print(" ");
        System.out.print(head.getData());
        printRecursively(head.getNext());

    }

    public void printReverse(){
        System.out.println();
        if(head== null){
            return;
        }

        Node temp= head;

        while(temp.getNext()!= null){
            temp= temp.getNext();
        }

        while(temp!= null){
            System.out.print(" ");
            System.out.print(temp.getData());
            temp= temp.getPrevious();
        }
    }

    public void printReversRecursively(Node head){
        if(head== null){
            System.out.println();
            return;
        }

        printReversRecursively(head.getNext());
        System.out.print(" ");
        System.out.print(head.getData());

    }

    public void reverse(){
        Node current= this.head;
        Node previous= null;
        Node next= current.getNext();

        while(next!= null){
            current.setPrevious(next);
            current.setNext(previous);
            previous= current;
            current= next;
            next= next.getNext();
        }

        this.head= current;
        current.setPrevious(next);
        current.setNext(previous);
    }

    public Node reverseRecursively(Node node){
        if(node== null){
            return null;
        }

        Node temp= node.getNext();
        node.setNext(node.getPrevious());
        node.setPrevious(temp);

        if(node.getPrevious()== null){
            return node;
        }

        return reverseRecursively(node.getPrevious());
    }
}
