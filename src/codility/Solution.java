package codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ykb on 2018-12-13.
 */
public class Solution {

    public static void main(String args[]) {
        int K = 2;
        int[] C = {5, 5, 5, 5, 5, 5, 1, 5, 1, 5, 1, 1};
        int[] D = {1, 1, 1, 5, 1, 5, 5};
        int diff = 0, result = 0;

        Map<Integer, Integer> C_M = new HashMap<>();
        Map<Integer, Integer> D_M = new HashMap<>();

        for(int c : C) {
            if(C_M.get(c) == null) {
                C_M.put(c, 1);
            } else {
                C_M.put(c, C_M.get(c) + 1);
            }
        }

        for(int d : D) {
            if(D_M.get(d) == null) {
                D_M.put(d, 1);
            } else {
                D_M.put(d, D_M.get(d) + 1);
            }
        }

        for(Integer c : C_M.keySet()) {
            result += Math.abs(C_M.get(c) / 2);
        }

        for(Integer d : D_M.keySet()) {
            if(K > 0) {
                if(C_M.get(d) != null) {
                    if(C_M.get(d) % 2 == 1) {
                        K--;
                        C_M.put(d, C_M.get(d) + 1);
                        D_M.put(d, D_M.get(d) - 1);
                        result++;
                    }
                }
            } else {
                break;
            }
        }

        if(K >= 2) {
            for(Integer d : D_M.keySet()) {
                if(K >= 2) {
                    diff = Math.abs(D_M.get(d) / 2) > Math.abs(K / 2) ? Math.abs(K / 2) : Math.abs(D_M.get(d) / 2);
                    result += diff;
                    K = K - diff;
                }
            }
        }

        System.out.println(result);
    }
}
