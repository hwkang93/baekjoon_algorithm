package level5;

import java.util.Scanner;

/**
 *  2577. 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 *      예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고,
 *      계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 */
public class Level5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int n = a * b * c;
        //n의 자리수
        int length = (int)(Math.log10(n) +1);
        //0~10까지 자리 수 값 들어갈 배열
        int[] results = new int[10];

        for(int i=0; i<length; i++) {
            //  (n % 10^(k+1)) / 10^k : 정수 n의 k의 자리 숫자 구하기.
            int result = (n % (int)Math.pow(10, (i+1))) / (int)Math.pow(10, i);
            results[result] += 1;
        }

        for(int i=0; i<results.length; i++) {
            System.out.println(results[i]);
        }

    }
}
