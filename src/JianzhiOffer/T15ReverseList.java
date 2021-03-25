package JianzhiOffer;

import JianzhiOffer.DataSturct.ListNode;

import java.util.Stack;

public class T15ReverseList {

    // 这种写法挺蠢的，不仅开辟了额外的存储空间，其实用数组就可以解决没必要用栈
    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while (!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        return ans.next;
    }

    public ListNode ReverseList2(ListNode head){
        if(head ==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int testCase[] = {1,2,3,4,5};
        ListNode head = new ListNode(testCase[0]);
        ListNode temp = head;
        for(int i=1;i<testCase.length;i++){
            temp.next = new ListNode(testCase[i]);
            temp = temp.next;
        }
        T15ReverseList reverseList = new T15ReverseList();
        System.out.println(reverseList.ReverseList2(head).val);
    }
}
