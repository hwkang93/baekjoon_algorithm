package level8;

import java.util.Scanner;

/**
 *  2292. 벌집
 *  위의 그림과 같이 육각형으로 이루어진 벌집이 있다.
 *  그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
 *  숫자 N이 주어졌을 때,
 *  벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
 *  예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 */
public class Level8_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int move = 0;           //움직인 횟수
        int maxRoomNumber = 1;  //방 번호 최대값

        /*
            방의 모양이 6면체이므로
            1칸 이동 시 갈 수 있는 방 번호의 최대값은 6 * 0
            2칸 이동 시 갈 수 있는 방 번호의 최대값은 6 * 0 + 6 * 1
            3칸 이동 시 갈 수 있는 방 번호의 최대값은 6 * 0 + 6 * 1 + 6 * 2 ...
        */
        while (true) {
            maxRoomNumber += 6 * move;
            move ++;

            //방 최대값이 입력값보다 크면 스톱
            if(maxRoomNumber >= n) {
                break;
            }
        }

        System.out.println(move);
    }
}
