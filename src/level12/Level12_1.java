package level12;

import java.util.Scanner;

/**
 *  2750. 수 정렬하기
 *      N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다.
 *      이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 *      첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class Level12_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        //선택 정렬로 해보기
        for(int i=0; i<arr.length; i++) {
            int min = 1001;
            int index = 0;
            for(int j=i; j<arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }

            changeIndex(arr, index, i);
        }

        print(arr);
    }

    public static void changeIndex(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
