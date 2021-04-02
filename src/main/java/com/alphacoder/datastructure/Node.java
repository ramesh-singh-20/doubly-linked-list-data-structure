package com.alphacoder.datastructure;

import lombok.Data;
import lombok.ToString;

//Added toString annotation to resolve StackOverFlow Exception
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Node {
    private int data;
    private Node next;
    private Node previous;
}
