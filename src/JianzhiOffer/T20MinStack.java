package JianzhiOffer;

import java.util.Stack;

public class T20MinStack {

    Stack<Integer> normal = new Stack();
    Stack<Integer> minval = new Stack();

    public void push(int node) {
        normal.push(node);
        if(minval.isEmpty()){
            minval.push(node);
        }else{
            int curMinVal = minval.peek();
            if(node<curMinVal) minval.push(node);
            else minval.push(curMinVal);
        }
    }

    public void pop() {
        if(normal.isEmpty()) return;
        normal.pop();
        minval.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return minval.peek();
    }
}
