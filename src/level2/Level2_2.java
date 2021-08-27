package level2;

import java.util.Scanner;

/**
 *  9498. 시험 점수를 입력받아 90~100점은 A, 80~89점은 B, 70~79점은 C, 60~69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
 */
public class Level2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();

        String grade = score > 89 ? "A" : score > 79 ? "B" : score > 69 ? "C" : score > 59 ? "D" : "F";
        System.out.println(grade);
    }
}
