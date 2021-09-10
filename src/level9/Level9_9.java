package level9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  4153. 직각삼각형
 *      과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
 */
public class Level9_9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            List<Integer> list = new ArrayList<>();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if(a == 0 && b == 0 && c == 0) {
                break;
            }

            list.add(a);
            list.add(b);
            list.add(c);

            List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());

            if(Math.pow(sortedList.get(0), 2) + Math.pow(sortedList.get(1), 2) == Math.pow(sortedList.get(2), 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
