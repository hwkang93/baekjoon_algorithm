package level12;

import java.util.*;

/**
 *  1427. 소트인사이드
 *      배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 *
 *      첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 *
 *      첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */
public class Level12_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String s = String.valueOf(n);
        List<Character> list = new ArrayList<>();

        for(char c : s.toCharArray()) {
            list.add(c);
        }

        Collections.sort(list, Comparator.reverseOrder());

        final StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);

        System.out.println(sb);
    }
}
