package JianzhiOffer;

import JianzhiOffer.DataSturct.ListNode;

import java.util.HashSet;
import java.util.List;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2020/12/21 23:13
 * @modified By：
 */
public class T36FindFirstCommonNode {
    
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return null;
        HashSet<Integer> temp = new HashSet<>();
        ListNode a = pHead1;
        ListNode b = pHead2;
        ListNode res = null;
        while (a!=null){
            if(a.val==b.val){
                res = a;
                break;
            }else{
                temp.add(a.val);
            }
            a = a.next;
        }
        while (b!=null){
            if(temp.contains(b.val)){
                res = b;
                break;
            }else{
                b = b.next;
            }
        }
        return res;
        
    }
    
}
