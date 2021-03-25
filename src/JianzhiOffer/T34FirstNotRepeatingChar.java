package JianzhiOffer;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2020/11/18 14:36
 * @modified By：
 */
public class T34FirstNotRepeatingChar {
    
    /**
     * 这是牛客网题解，用类似map的方式统计每个字符出现的次数，这里用了一个整形数组来代替map，更方便
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length() == 0)return -1;
        int[] count = new int[256];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for(int i=0; i < str.length();i++)
            count[str.charAt(i)]++;
        //其实这个第二步应该也是ka我的地方，没有在第一时间想到只要在遍历一遍数组并访问hash记录就可以了
        for(int i=0; i < str.length();i++)
            if(count[str.charAt(i)]==1)
                return i;
        return -1;
    }
}
