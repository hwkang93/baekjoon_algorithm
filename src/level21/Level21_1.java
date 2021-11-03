package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  1920. 수 찾기
 *      N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 *
 *      첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
 *      다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
 *      모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 *
 *      M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 */
public class Level21_1 {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int a[] = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int check = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(find(a, check)).append('\n');
        }

        System.out.println(stringBuilder);
    }

    public static int find(int[] arr,  int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = ( left + right ) / 2;

            if (target > arr[mid]) {
                left = mid + 1;
            }
            else if(target < arr[mid]) {
                right = mid - 1;
            }
            else {
                return 1;
            }
        }

        return 0;
    }
}
