package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  1021. 회전하는 큐
 *      지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
 *      지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
 *          1. 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
 *          2. 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
 *          3. 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
 *      큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.)
 *      이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다. N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.
 *      둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다. 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.
 *
 *      첫째 줄에 문제의 정답을 출력한다.
 */
public class Level19_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.parseInt(stringTokenizer.nextToken());      //큐의 크기
        int m = Integer.parseInt(stringTokenizer.nextToken());      //뽑아내려고 하는 수의 개수

        int[] index = new int[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for(int i = 0; i < m; i++) {
            index[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            deque.offer(i);
        }

        //결과값
        int count = 0;
        /*
            예)
                10 3
                2 9 5 일 경우 (예제입력 2)

                큐 : 1,2,3,4,5,6,7,8,9,10
                찾아야 할 인덱스 : 2,9,5

                타겟 : 2
                2번 연산 실행 : (2) 3 4 5 6 7 8 9 10 1 -> count = 1
                1번 연산 실행 : 3 4 5 6 7 8 9 10 1

                타겟 : 9
                3번 연산 실행 : 1 3 4 5 6 7 8 (9) 10   -> count = 2
                3번 연산 실행 : 10 1 3 4 5 6 7 8 (9)   -> count = 3
                3번 연산 실행 : (9) 10 1 3 4 5 6 7 8   -> count = 4
                1번 연산 실행 : 10 1 3 4 5 6 7 8

                타겟 : 5
                2번 연산 실행 : 1 3 4 (5) 6 7 8 10     -> count = 5
                2번 연산 실행 : 3 4 (5) 6 7 8 10 1     -> count = 6
                2번 연산 실행 : 4 (5) 6 7 8 10 1 3     -> count = 7
                2번 연산 실행 : (5) 6 7 8 10 1 3 4     -> count = 8
                1번 연산 실행 : 6 7 8 10 1 3 4

         */
        for(int i = 0; i < index.length; i++) {
            int targetIndex = deque.indexOf(index[i]);                                  //index 가 큐의 몇 번째에 있는지 확인
            int halfIndex = deque.size() % 2 == 0 ? deque.size()/2-1 : deque.size()/2;  //큐의 중간값 확인(짝수, 홀수 구분)

            //인덱스가 큐의 맨 첫번째 값에 위치할 때까지 반복
            while (deque.getFirst() != index[i]) {
                if(targetIndex <= halfIndex) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                }
                else {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                }

                count++;

            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}
