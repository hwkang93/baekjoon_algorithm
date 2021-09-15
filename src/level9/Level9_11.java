package level9;

import java.util.Scanner;

/**
 *  1002. 터렛
 *      조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다.
 *      이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
 *      조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
 *      조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
 *      류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
 */
public class Level9_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int i=0; i<t; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int r1 = scanner.nextInt();

            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int r2 = scanner.nextInt();

            System.out.println(getCount(x1, y1, r1, x2, y2, r2));
        }
    }

    public static int getCount(int x1, int y1, int r1, int x2, int y2, int r2) {

        int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if(x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        else if(distance_pow > Math.pow(r1 + r2, 2)) {
            return 0;
        }
        else if(distance_pow < Math.pow(r2 - r1, 2)) {
            return 0;
        }
        else if(distance_pow == Math.pow(r2 - r1, 2)) {
            return 1;
        }
        else if(distance_pow == Math.pow(r1 + r2, 2)) {
            return 1;
        }
        else {
            return 2;
        }
    }
}
