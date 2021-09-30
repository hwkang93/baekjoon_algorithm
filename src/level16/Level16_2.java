package level16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  1931. 회의실 배정
 *      한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
 *      각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 *      단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 *      회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 *
 *      첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
 *      둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 *      시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.
 *
 *      첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 */
public class Level16_2 {
    static int n;
    static int[][] arr;
    static int max= Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        max = Integer.MIN_VALUE;

        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());	// 시작시간
            arr[i][1] = Integer.parseInt(st.nextToken());	// 종료시간
        }

        for(int i = 0; i < n; i++) {
            if(max < arr[i][1]) {
                max = arr[i][1];
            }
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        check();
    }

    public static void check() {
        int count = 0;
        int endTime = 0;
        for(int i = 0; i < n; i++) {
            if(endTime <= arr[i][0]) {
                endTime = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
