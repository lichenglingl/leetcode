import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdlichenglin on 2015/9/23.
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows <= 1) {
            return  s;
        }

        List<StringBuilder> sbList = new ArrayList<StringBuilder>(numRows);
        for (int n = 0; n < numRows; n++) {
            sbList.add(new StringBuilder());
        }

        if (numRows == 2) {
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    sbList.get(0).append(s.charAt(i));
                } else {
                    sbList.get(1).append(s.charAt(i));
                }
            }
        } else {
            int curRow = -1;
            int change = 0;
            for (int i = 0; i < s.length(); i++) {
                if (curRow <= 0) {
                    change = 1;
                }
                if (curRow >= numRows-1) {
                    change = -1;
                }

                curRow += change;
                sbList.get(curRow).append(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbList) {
            result.append(sb);
        }

        return result.toString();
    }

    public static void main (String[] args){
        ZigZagConversion s = new ZigZagConversion();

        long start = System.currentTimeMillis();

        String result = s.convert("ABCDEFGHI", 4);

        System.out.println("cost:" + (System.currentTimeMillis() - start) + " ms.");
        System.out.println("result:" + result);
    }

}