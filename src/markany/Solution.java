package markany;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ykb on 2019-09-26.
 */
public class Solution {

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 1, 4, 2};
        int answer = 2;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int temp;

        for(int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) == null) {
                map.put(arr[i], i);
            } else {
//                map.put(arr[i], i- map.get(arr[i]));
                temp = i- map.get(arr[i]);
                if(min > temp) {
                    min = temp;
                }
                map.put(arr[i], i);
            }
        }

        if(min == Integer.MAX_VALUE) {
//            return -1;
        } else {
//            return min;
        }
//
//        List<Integer> list = new ArrayList<>();
//        int prevNum = -1;
//        for(int i = 0; i < arr.length; i++) {
//            if(prevNum != arr[i]) {
//                list.add(arr[i]);
//                prevNum = arr[i];
//            }
//        }
//
//        answer = new int[list.size()];
//
//        for(int i = 0; i < list.size(); i++) {
//            answer[i] = list.get(i);
//        }

        System.out.print("dfdf");
    }

}
