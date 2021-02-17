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

    public void push(int stackNum, int value) {

    }

    public int pop(int stackNum) {


        return 0;
    }

    public int peek (int stackNum) {

        return 0;
    }

    public boolean isEmpty(int stackNum) {

        return true;
    }
    public boolean isFull(int stackNum) {

        return true;
    }

    private int indexOfTop(int stackNum) {
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
