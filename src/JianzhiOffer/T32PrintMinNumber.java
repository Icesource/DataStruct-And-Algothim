package JianzhiOffer;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2020/11/18 14:02
 * @modified By：
 */
public class T32PrintMinNumber {
    
    /**
     * 这是牛客网解法
     * 只是看一下解析，比较关键的一句话 所以在这里自定义一个比较大小的函数，比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。 ，突然大悟。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)return "";
        for(int i=0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                int sum1 = Integer.valueOf(numbers[i]+""+numbers[j]);
                int sum2 = Integer.valueOf(numbers[j]+""+numbers[i]);
                if(sum1 > sum2){
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        String str = new String("");
        for(int i=0; i < numbers.length; i++)
            str = str + numbers[i];
        return str;
    }
}
