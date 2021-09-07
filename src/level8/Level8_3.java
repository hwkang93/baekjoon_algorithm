package level8;

import java.util.Scanner;

/**
 *  1193. 분수찾기
 *      무한히 큰 배열에 다음과 같이 분수들이 적혀 있다.
 *          1/1 1/2 1/3 1/4 1/5 ...
 *          2/1 2/2 2/3 2/4 ...
 *          3/1 3/2 3/3 ...
 *          4/1 4/2 ...
 *          5/1 ...
 *      이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
 *      X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 */
public class Level8_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int num = 1;        //줄 바꾸는 구분자. 첫째줄부터 시작해서 1로 초기화함
        int count = 0;      //면 번째 까지 왔는지
        int top = 0;        //분자값
        int bottom = 0;     //분모값

        while (x != count) {
            for(int i = 0; i < num; i++) {
                //n이 짝수이면 분자는 순행 분모는 역행
                if(num % 2 == 0) {
                    top = i + 1;
                    bottom = num - i;
                }
                //n이 홀수이면 분자는 역행 분모는 순행
                else {
                    top = num - i;
                    bottom = i + 1;
                }

                count ++;
                if(count == x) {
                    break;
                }
            }

            num++;
        }

        System.out.println(top + "/" + bottom);
    }
}
