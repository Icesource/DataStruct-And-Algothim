package JianzhiOffer;

import JianzhiOffer.DataSturct.ListNode;

public class T14FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode temp = head;
        for(int i=0;i<k;i++){
            if(temp!=null){
                temp = temp.next;
            }else{
                return null;
            }
        }
        while (temp!=null){
            head = head.next;
            temp = temp.next;
        }
        return head;
    }
}
