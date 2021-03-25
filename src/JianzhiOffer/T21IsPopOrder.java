package JianzhiOffer;

import java.util.Stack;

public class T21IsPopOrder {

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        T21IsPopOrder isPopOrder = new T21IsPopOrder();
        System.out.println(isPopOrder.IsPopOrder(a, b));

    }

}
