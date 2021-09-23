package level14;

import java.util.Scanner;

/**
 *  9663. N-Queen
 *      N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 *      N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 N이 주어진다. (1 ≤ N < 15)
 *
 *      첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 */
public class Level14_5 {
    public static int n;
    public static int[] arr;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];

        nQueen(0);

        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if(n == depth) {
            count ++;
            return;
        }

        for(int i=0; i<n; i++) {
            arr[depth] = i;

            if(check(depth)) {
                nQueen(depth +1);
            }
        }
    }

    public static boolean check(int col) {
        for(int i = 0; i < col; i++) {
            //세로가 같은 경우
            if(arr[i] == arr[col]) {
                return false;
            }

            //대각선이 같은 경우
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
