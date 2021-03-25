package leetcode;

import java.util.Stack;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2021/3/5 10:33
 * @modified By：
 */
public class T232MyQueue {
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    /** Initialize your data structure here. */
    public T232MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}
