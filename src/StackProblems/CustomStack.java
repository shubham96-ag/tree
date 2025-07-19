package StackProblems;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;
//this ensures that the
    public CustomStack(){
        this(DEFAULT_SIZE); //calling the below constructor
    }
    public CustomStack(int size) {
        this.data = new int[size];
    }
    public boolean push(int n) throws StackException {
        if(isFull()){
            throw new StackException("Stack is full");
        }
        data[++ptr] = n;
        return true;
    }

    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot pop from an empty stack");
        }
        return data[ptr--];
    }

    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Stack is empty");
        }
        return data[ptr];
    }
    public boolean isFull(){
         return ptr==data.length-1;
    }
    public boolean isEmpty(){
        return ptr==-1;
    }

    public static void main(String[] args) {

    }
}
