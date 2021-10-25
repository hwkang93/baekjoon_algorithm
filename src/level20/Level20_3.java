package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1780. 종이의 개수
 *      N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다.
 *      우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
 *          1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
 *          2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
 *      이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
 *
 *      첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
 *
 *      첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
 */
public class Level20_3 {

    static int[][] arr;
    static int minusOneCount = 0;
    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        arr = new int[n][n];

        StringTokenizer stringTokenizer;

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            for(int j = 0; j < n; j ++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        find(0,0,n);

        System.out.println(minusOneCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    public static void find(int startX, int startY, int length) {
        int start = arr[startX][startY];

        if(length == 1) {
            addCount(start);
            return;
        }

        for(int i = startX; i < startX + length; i++) {
            for(int j = startY; j < startY + length; j++) {
                int newLength = length/3;
                if(start != arr[i][j]) {
                    find(startX, startY, newLength);                                                //1
                    find(startX + newLength, startY, newLength);                            //2
                    find(startX + (newLength*2), startY, newLength);                        //3

                    find(startX, startY + newLength, newLength);                            //4
                    find(startX + newLength, startY + newLength, newLength);        //5
                    find(startX + (newLength*2), startY + newLength, newLength);    //6

                    find(startX, startY + (newLength*2), newLength);                            //7
                    find(startX + newLength, startY + (newLength*2), newLength);        //8
                    find(startX + (newLength*2), startY + (newLength*2), newLength);    //9
                    return;
                }
            }
        }

        addCount(start);
    }

    public static void addCount(int start) {
        if (start == -1) {
            minusOneCount += 1;
        }
        else if (start == 0) {
            zeroCount += 1;
        }
        else {
            oneCount += 1;
        }
    }
}
