package codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ykb on 2018-12-14.
 */
public class Solution2 {

    public static void main(String args[]) {
        int[] A = {2, 1, 1, 2, 3, 1};
        Map<Integer, Integer> keys = new HashMap<>();
        for(int a : A) {
            if(keys.get(a) != null) {
                keys.put(a, keys.get(a) + 1);
            } else {
                keys.put(a, 1);
            }
        }
        System.out.print(keys.size());
    }
}
