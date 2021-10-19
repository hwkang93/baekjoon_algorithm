package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 *  10866. 덱
 *      정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *      명령은 총 여덟 가지이다.
 *          - push_front X: 정수 X를 덱의 앞에 넣는다.
 *          - push_back X: 정수 X를 덱의 뒤에 넣는다.
 *          - pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *          - pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *          - size: 덱에 들어있는 정수의 개수를 출력한다.
 *          - empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 *          - front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *          - back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 *      첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 *      주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 *
 *      출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */
public class Level19_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer;

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            switch (stringTokenizer.nextToken()) {
                case "push_front" :
                    int frontX = Integer.parseInt(stringTokenizer.nextToken());
                    deque.addFirst(frontX);

                    break;
                case "push_back" :
                    int backX = Integer.parseInt(stringTokenizer.nextToken());
                    deque.addLast(backX);

                    break;
                case "pop_front" :
                    Integer popFront = deque.pollFirst();
                    if(popFront == null) {
                        popFront = -1;
                    }
                    stringBuilder.append(popFront).append('\n');

                    break;
                case "pop_back" :
                    Integer popBack = deque.pollLast();
                    if(popBack == null) {
                        popBack = -1;
                    }
                    stringBuilder.append(popBack).append('\n');

                    break;
                case "size" :
                    stringBuilder.append(deque.size()).append('\n');

                    break;
                case "empty" :
                    int empty = deque.isEmpty() ? 1 : 0;
                    stringBuilder.append(empty).append('\n');

                    break;
                case "front" :
                    int front = -1;
                    try {
                        front = deque.getFirst();
                    } catch (NoSuchElementException e) {
                        front = -1;
                    }
                    stringBuilder.append(front).append('\n');

                    break;
                case "back" :
                    int last = -1;
                    try {
                        last = deque.getLast();
                    } catch (NoSuchElementException e) {
                        last = -1;
                    }
                    stringBuilder.append(last).append('\n');

                    break;
            }
        }

        System.out.println(stringBuilder);
    }
}
