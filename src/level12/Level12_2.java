package level12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *  2751. 수 정렬하기 2
 *      N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
 *      이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 *      첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class Level12_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();

        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i)).append('\n');
        }

        System.out.println(stringBuilder);
    }
}
