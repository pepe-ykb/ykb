package eastsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ykb on 2018-12-15.
 */
public class Test2 {


    public static void main(String args[]) {
        String S = "ACCAABBC";
        List<Character> arr = new ArrayList<>();
        String result = "";

        for(int i = 0; i < S.length(); i++) {
            arr.add(S.charAt(i));
        }

        for(int i = 0; i < arr.size() - 1; i++) {
            result += arr.get(i);
        }
        System.out.println(result);
//        cal(arr);
    }

    public static void cal(List<Character> arr) {
        for(int i = 0; i < arr.size(); i++) {
            if(i+1 == arr.size()) {
                break;
            }
            if(arr.get(i) == arr.get(i + 1)) {
                arr.remove(i);
                arr.remove(i);
                cal(arr);
                break;
            }
        }

        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " - ");
        }
    }
}
