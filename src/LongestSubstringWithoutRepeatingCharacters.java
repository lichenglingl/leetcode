/**
 * Created by cdlichenglin on 2015/9/23.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 1;
        int start = 0;
        int[] cache = new int[256];

        int len = s.length();
        for (int i = 0; i < len; i++) {
            int lastIndex = cache[s.charAt(i)] - 1;
            // char show again
            if (lastIndex >= start) {
                int length = i - start;
                max = length > max ? length : max;
                start = lastIndex + 1;
                // end fast
                if (len - start <= max) {
                    return max;
                }
            }

            cache[s.charAt(i)] = i + 1;
        }

        max = max >= (len - start) ? max : (len - start);
        return max;
    }

    public static void main (String[] args){
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();

        long start = System.currentTimeMillis();

        int result = s.lengthOfLongestSubstring("ads cfsdsdw");

        System.out.println("cost:" + (System.currentTimeMillis() - start) + " ms.");
        System.out.println("result:" + result);
    }
}
