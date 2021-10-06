package level17;

import java.util.Scanner;

/**
 *  11050. 이항 계수 1
 *      자연수 N과 정수 K가 주어졌을 때 이항 계수 binomial(N, K) 를 구하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 N과 K가 주어진다.( 1 <= N <= 10 , 0 <= K <= N)
 *
 *      binomial(N, K)를 출력한다.
 */
public class Level17_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(binomial(n, k));
    }

    //수의 범위가 작기 때문에 일반 재귀법으로 풀이
    public static int binomial(int n, int k) {
        if(k == 0 || n == k) {
            return 1;
        }

        return binomial(n-1, k-1) + binomial(n-1, k);
    }
}
