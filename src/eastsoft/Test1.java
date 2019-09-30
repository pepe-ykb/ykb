package eastsoft;

/**
 * Created by ykb on 2018-12-15.
 */
public class Test1 {

    public static String makeTime(int start, int end, String t, int[] arr, int limit, boolean isStop ) {

        for(int index = start; index < end; index++) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == index) {
                    t += arr[i];
                    arr[i] = -1;
                    break;
                }
            }

            if(t.length() == limit) {
                break;
            }
        }

        if(t.length() == limit - 1) {
            return "NOT POSSIBLE";
        }

        return t;
    }

    public static String solution(int A, int B, int C, int D, int E, int F) {
        int[] arr = {A, B, C, D, E, F};
        String h = "", m = "", s = "";
        int temp = 0;
        boolean isStop = false;

        h = makeTime(0, 3, h, arr, 1, isStop);
        if(h.startsWith("NOT")) {
            isStop = true;
        }

        m = makeTime(0, 6, m, arr, 1, isStop);
        if(m.startsWith("NOT")) {
            isStop = true;
        }

        s = makeTime(0, 6, s, arr, 1, isStop);
        if(s.startsWith("NOT")) {
            isStop = true;
        }

        if(h.equals("2")) {
            temp = 4;
        } else {
            temp = 10;
        }
        h = makeTime(0, temp, h, arr, 2, isStop);
        if(h.startsWith("NOT")) {
            isStop = true;
        }

        m = makeTime(0, 10, m, arr, 2, isStop);
        if(m.startsWith("NOT")) {
            isStop = true;
        }
        s = makeTime(0, 10, s, arr, 2, isStop);
        if(s.startsWith("NOT")) {
            isStop = true;
        }

        if(isStop) {
            return "NOT POSSIBLE";
        } else {
            return h + " : " + m + " : " + s;
        }
    }

    public static void main(String args[]) {
        int A = 1;
        int B = 8;
        int C = 3;
        int D = 2;
        int E = 6;
        int F = 4;

        System.out.println(solution(A,B,C,D,E,F));
    }
}
