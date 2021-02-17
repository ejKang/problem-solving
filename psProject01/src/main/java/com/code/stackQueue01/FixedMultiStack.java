package com.code.stackQueue01;

public class FixedMultiStack {
    
    private int numberOfStacks = 3; 
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackCapacity * numberOfStacks];
        sizes = new int[numberOfStacks];
        
    }


    public static void main(String[] args) {
        
    }
}
