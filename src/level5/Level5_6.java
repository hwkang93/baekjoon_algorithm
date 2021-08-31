package level5;

import java.util.Scanner;

public class Level5_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = scanner.next();

            int score = 1;
            int sum = 0;
            for(int j=0; j < arr[i].length(); j++) {
                char a = arr[i].charAt(j);

                if("O".equals(String.valueOf(a))) {
                    sum += score;
                    score += 1;
                } else {
                    score = 1;
                }
            }
            System.out.println(sum);
        }
    }
}
