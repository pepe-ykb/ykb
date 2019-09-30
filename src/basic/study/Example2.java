package basic.study;

/**
 * programmers.co.kr
 * 코딩테스트 연습 > 정렬 > 가장 큰 수
 */
public class Example2 {

    public static void main(String[] args) {
//        int[] numbers = {6,10,2};
//        int[] numbers = {3,30,34,5,9};
        int[] numbers = {1,30,34,99,9};
        String result = solution(numbers);
        System.out.print(result);
    }

    public static String solution(int[] numbers) {
        int temp = 0;
        int front = 0;
        int back = 0;
        String answer = "";
        for(int k = numbers.length; k>0; k--) {
            for (int j=0; j<k-1; j++) {
                front = String.valueOf(numbers[j]).charAt(String.valueOf(numbers[j]).length() - 1);
                back = String.valueOf(numbers[j+1]).charAt(String.valueOf(numbers[j+1]).length() - 1);
                if(front < back) {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < numbers.length; i++) {
            answer += String.valueOf(numbers[i]);
        }

        return answer;
    }
}
