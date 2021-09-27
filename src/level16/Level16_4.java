package level16;

import java.util.Scanner;

/**
 *  1541. 잃어버린 괄호
 *
 *      세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
 *      그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 *      괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 *
 *      첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
 *      그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
 *      입력으로 주어지는 식의 길이는 50보다 작거나 같다.
 *
 *      첫째 줄에 정답을 출력한다.
 */
public class Level16_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String[] splitMinus = a.split("-");

        //0번째는 무조건 양수 (가장 처음과 마지막 문자는 숫자라고 했으므로) -> 0일 수도 있음
        int sum = Integer.MAX_VALUE;

        for(int i=0; i<splitMinus.length; i++) {
            int temp = 0;
            String[] splitPlus = splitMinus[i].split("\\+");

            //-와 - 사이에 있는 값 모두 더하기
            for(int j=0; j<splitPlus.length; j++) {
                int parts = Integer.parseInt(splitPlus[j]);
                temp += parts;
            }
            if(sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
