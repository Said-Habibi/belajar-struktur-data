package Tugas10;
import Tugas10.*;
public class Main {
    public static void main(String[] args) {
        AStack stack = new AStack();
        // stack.push("A");
        // stack.push("B");
        // stack.push("C");
        // stack.push("D");
        stack.push("K");
        stack.push("A");
        stack.push("K");
        stack.push("A");
        stack.push("K");
        // System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("============");
        LStack stack2 = new LStack();
        stack2.push("A");
        stack2.push("B");
        stack2.push("C");
        stack2.push("D");
        System.out.println(stack2.peek());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());
    }
}