package leetcode;

import leetcode.inter.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

public class T341NestedIterator implements Iterator {

    List<Integer> integerList;
    int position = 0;

    public T341NestedIterator(List<NestedInteger> nestedList) {
        integerList = new ArrayList<>();
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return integerList.get(position++);
    }

    @Override
    public boolean hasNext() {
        return integerList.size() > position;
    }

    private void dfs(List<NestedInteger> nestedList) {
        if(nestedList != null){
            for (int i = 0; i < nestedList.size(); i++) {
                NestedInteger nestedInteger = nestedList.get(i);
                if (nestedInteger.isInteger()) {
                    integerList.add(nestedInteger.getInteger());
                }else{
                    dfs(nestedInteger.getList());
                }
            }
        }
    }

}
