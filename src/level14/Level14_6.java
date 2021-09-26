package level14;

import java.util.Scanner;

public class Level14_6 {
    public static int[][] arr = new int[9][9];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        sdoku(0, 0);
    }

    public static void sdoku(int row, int col) {
        if(col == 9) {
            sdoku(row+1, 0);
            return;
        }

        //row == 9 -> 모든 경우 순회 완료 ( 마지막으로 조회헤애 할 row, col -> (8, 8) )
        if(row == 9) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    stringBuilder.append(arr[i][j]).append(' ');
                }
                stringBuilder.append('\n');
            }

            System.out.println(stringBuilder);
            System.exit(0);
        }

        //arr[row][col] == 0 -> 값을 1~9까지 중 하나를 채워넣어야 함.
        if(arr[row][col] == 0) {
            for(int i=1; i<=9; i++) {
                if(check(i, row, col)) {
                    arr[row][col] = i;
                    sdoku(row, col+1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        //마지막 칸까지 확인 후 다음 줄 첫번째 칸으로 이동
        sdoku(row, col+1);
    }

    public static boolean check(int value, int row, int col) {
        //가로에 value 값이 있는 경우 false
        for(int i=0; i<9; i++) {
            if(value == arr[row][i]) {
                return false;
            }
        }

        //세로에 value 값이 있는 경우 false
        for(int i=0; i<9; i++) {
            if(value == arr[i][col]) {
                return false;
            }
        }

        //value가 포함된 위치의 3x3 에 value 값이 있는 경우 false
        /*
            0,1,2 -> 0
            3,4,5 -> 3
            6,7,8 -> 6
         */
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;

        for(int i = rowStart; i < rowStart + 3; i++) {
            for(int j = colStart; j < colStart + 3; j++) {
                if(value == arr[i][j]) {
                    return false;
                }
            }
        }

        //그 외의 경우 true
        return true;
    }
}
