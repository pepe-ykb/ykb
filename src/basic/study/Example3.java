package basic.study;

/**
 * programmers.co.kr
 * 코딩테스트 연습 > 정렬 > 가장 큰 수
 */
public class Example3 {

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int result = solution(numbers, target);
        System.out.print(result);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int sum = 0;
        int j = 0;

        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        if(sum > target) {
            sum = 0;
            for(int k = 0; k < numbers.length; k++) {
                for(int i = 0; i < numbers.length; i++) {
                    if(i == j) {
                        sum += numbers[i] * -1;
                    } else {
                        sum += numbers[i];
                    }
                }
                j++;
                if(sum == target) {
                    answer++;
                }
                sum = 0;
            }
        } else if(sum == target){
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}
