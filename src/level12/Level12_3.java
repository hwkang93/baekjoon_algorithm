package level12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  10989. 수 정렬하기 3
 *      N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
 *
 *      첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class Level12_3 {
    public static void main(String[] args) {
        //문제에서 카운팅 알고리즘을 사용하라고 해서 카운팅 알고리즘을 사용하도록 함.
        //주의사항 : 중복이 가능하다.
        int[] countingArr = new int[10001];

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int n = Integer.parseInt(br.readLine());

            for(int i=0; i < n; i++) {
                countingArr[Integer.parseInt(br.readLine())] ++;
            }

            br.close();

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<countingArr.length; i++) {
                while (countingArr[i] != 0) {
                    sb.append(i).append('\n');
                    countingArr[i]--;
                }
            }

            System.out.println(sb);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
