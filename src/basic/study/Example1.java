package basic.study;

/**
 * programmers.co.kr
 * 코딩테스트 연습 > 정렬 > K 번째수
 */
public class Example1 {

    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] result = solution(array, commands);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] _array;
        int size = 0;
        int index = 0, cnt = 0, _cnt = 0;
        int temp = 0;

        for(int i = 0; i < commands.length; i++) {
            size = commands[i][1] - commands[i][0];
            _array = new int[size + 1];
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                _array[cnt++] = array[j];
            }

            for(int k = _array.length; k>0; k--) {
                //
                for (int j=0; j<k-1; j++) {
                    index++;
                    if(_array[j] > _array[j+1]) {
                        temp = _array[j];
                        _array[j] = _array[j+1];
                        _array[j+1] = temp;
                    }
                }
            }

            answer[_cnt++] = _array[commands[i][2] - 1];
            cnt = 0;
            index = 0;
        }

        return answer;
    }
}
