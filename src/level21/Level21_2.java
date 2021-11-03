package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Level21_2 {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);


    }
    //1,2,3,3,3,4,5     3   left : 0 right : 7
    //1,2,2,2,3,4,5     3   left : 0 right : 7
    public static int rightIndex(int[] arr, int target) {

        return 0;
    }

    public static int leftIndex(int[] arr, int target) {


        return 0;
    }
}
