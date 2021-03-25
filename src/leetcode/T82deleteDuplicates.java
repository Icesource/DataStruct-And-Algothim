package leetcode;

import JianzhiOffer.DataSturct.ListNode;

import java.util.List;

public class T82deleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode m = head;
        ListNode i = m.next, j = i.next;

        while (j!=null && i!=null){
            while (j == i) j = j.next;
            if (m == i) {
                m = j;
            } else {
                m.next = j;
            }
            i = m.next;
            j = i.next;
        }
        return m;
    }

}
