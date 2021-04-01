package com.alphacoder.datastructure;

import lombok.Data;

@Data
public class Node {
    private int data;
    private Node next;
    private Node previous;
}
