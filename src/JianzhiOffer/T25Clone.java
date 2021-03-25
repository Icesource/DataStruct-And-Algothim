package JianzhiOffer;

import JianzhiOffer.DataSturct.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class T25Clone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)return null;
        RandomListNode newHead = null;
        RandomListNode p = pHead;
        RandomListNode q = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(p != null){
            if(newHead == null){
                newHead = new RandomListNode(pHead.label);
                q = newHead;
                map.put(pHead, newHead);
            }else{
                if(p.next!= null && map.containsKey(p.next))
                    q.next = map.get(p.next);
                else{
                    if(p.next!= null){
                        RandomListNode temp = new RandomListNode(p.next.label);
                        map.put(p.next, temp);
                        q.next = temp;
                    }
                }
                if(p.random != null && map.containsKey(p.random))
                    q.random = map.get(p.random);
                else{
                    if(p.random != null){
                        RandomListNode temp = new RandomListNode(p.random.label);
                        map.put(p.random, temp);
                        q.random = temp;
                    }
                }
                p = p.next;
                q = q.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(1);
        root.next = new RandomListNode(2);
        root.next.next = new RandomListNode(3);
        root.next.next.next = new RandomListNode(4);
        root.random = root.next.next.next;
        root.next.random = root.next.next;

        T25Clone clone = new T25Clone();
        clone.Clone(root);
    }
}
