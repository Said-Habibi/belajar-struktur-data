package praktikum10;
import praktikum10.*;
public class Main {
    public static void main(String[] args) {
        AStack stack = new AStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}