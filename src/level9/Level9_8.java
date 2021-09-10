package level9;

import java.util.Scanner;

/**
 *  3009. 네 번째 점
 *      세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
 */
public class Level9_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] a = {in.nextInt(), in.nextInt()};
        int[] b = {in.nextInt(), in.nextInt()};
        int[] c = {in.nextInt(), in.nextInt()};


/*
        int dx = dy = 0;
        if(a[0] == b[0]) {
            dx = c[0];
        } else if(a[0] == c[0]) {
            dx = b[0];
        } else {
            dx = a[0];
        }

        if(a[0] == b[1]) {
            dy = c[1];
        } else if(a[1] == c[1]) {
            dy = b[1];
        } else {
            dy = a[1];
        }
*/
        int dx = (a[0] == b[0] ? c[0] : a[0] == c[0] ? b[0] : a[0]);
        int dy = (a[1] == b[1] ? c[1] : a[1] == c[1] ? b[1] : a[1]);
        System.out.println(dx + " " + dy);
    }
}
