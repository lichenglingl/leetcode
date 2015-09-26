/**
 * Created by cdlichenglin on 2015/9/26.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if (newResult / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main (String[] args){
        ReverseInteger s = new ReverseInteger();
        System.out.println("input:" + Integer.MAX_VALUE);
        long start = System.currentTimeMillis();

        int result = s.reverse(0);

        System.out.println("cost:" + (System.currentTimeMillis() - start) + " ms.");
        System.out.println("result:" + result);
    }

}
