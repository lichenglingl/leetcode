import java.util.HashMap;
import java.util.Map;

/**
 * Created by cdlichenglin on 2015/9/23.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i + 1};
            }
            map.put(nums[i], i + 1);
        }
        return null;
    }

    public static void main (String[] args){
        TwoSum s = new TwoSum();

        long start = System.currentTimeMillis();

        int[] result = s.twoSum(new int[]{2, 2, 7, 8}, 9);

        System.out.println("cost:" + (System.currentTimeMillis() - start) + " ms.");
        System.out.println("result:" + result);
        for (int r : result) {
            System.out.println(r);
        }

    }

}
