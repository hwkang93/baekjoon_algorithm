package level5;

import java.util.Scanner;

/**
 *  8958. "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
 *      "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 *      OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 */
public class Level5_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = scanner.next();

            int score = 1;
            int sum = 0;
            for(int j=0; j < arr[i].length(); j++) {
                char a = arr[i].charAt(j);

                if("O".equals(String.valueOf(a))) {
                    sum += score;
                    score += 1;
                } else {
                    score = 1;
                }
            }
            System.out.println(sum);
        }
    }
}
