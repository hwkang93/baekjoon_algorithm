package level9;

import java.util.Scanner;

/**
 *  1085. 직사각형에서의 탈출
 *      한수는 지금 (x, y)에 있다.
 *      직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
 *      직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 */
public class Level9_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int width = x < w-x ? x : w-x;
        int height = y < h-y ? y : h-y;

        if(width > height) {
            System.out.println(height);
        } else {
            System.out.println(width);
        }
    }
}
