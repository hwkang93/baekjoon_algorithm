package level2;

import java.util.Scanner;

/**
 *  14681. 점(X,Y)가 있을 때 해당 점의 사분면 번호 (1,2,3,4 중 하나) 를 출력하라.
 */
public class Level2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x > 0 && y > 0) {
            System.out.println("1");
        }
        else if (x < 0 && y > 0) {
            System.out.println("2");
        }
        else if (x < 0 && y < 0) {
            System.out.println("3");
        } else {
            System.out.println("4");
        }
    }
}
