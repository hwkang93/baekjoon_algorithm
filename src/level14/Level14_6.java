package level14;

import java.util.Scanner;

/**
 *  2580. 스도쿠
 *      스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다.
 *      이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데,
 *      게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.
 *      나머지 빈 칸을 채우는 방식은 다음과 같다.
 *          - 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
 *          - 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
 *      게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.
 *
 *      아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다.
 *      스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.
 *
 *      모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.
 *      스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
 */
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
