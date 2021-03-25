package JianzhiOffer;

import JianzhiOffer.DataSturct.ListNode;

public class T16Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        temp.next = list1==null ? list2:list1;
        return ans.next;
    }

    public static void main(String[] args) {
        int testCase[] = {1,3,7,11,15};
        ListNode head = new ListNode(testCase[0]);
        ListNode temp = head;
        for(int i=1;i<testCase.length;i++){
            temp.next = new ListNode(testCase[i]);
            temp = temp.next;
        }

        int testCase2[] = {1,2,3,4,5};
        ListNode head2 = new ListNode(testCase[0]);
        ListNode temp2 = head2;
        for(int i=1;i<testCase.length;i++){
            temp2.next = new ListNode(testCase2[i]);
            temp2 = temp2.next;
        }
        T16Merge merge = new T16Merge();
        merge.Merge(head,head2);
    }
}
