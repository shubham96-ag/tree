package StackProblems;

public class StackMain {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(78);
        customStack.push(12);
        customStack.push(33);
        customStack.push(45);
        customStack.push(34);
        customStack.push(35);
        customStack.push(67);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.peek());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
