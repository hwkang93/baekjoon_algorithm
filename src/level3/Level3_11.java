package level3;

import java.util.Scanner;

/**
 *  10871. 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
 */
public class Level3_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] a = new int[n];
        for(int i = 0; i< n; i++) {
            a[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++) {
            if(a[i] < x) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
