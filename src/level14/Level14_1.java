package level14;

import java.util.Scanner;

/**
 *  15649. N과 M (1)
 *      자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *          - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 *
 *      첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 *      한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 *      수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class Level14_1 {
    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //출력 배열의 크기
        arr = new int[m];

        //노드 방문 유무
        visit = new boolean[n];

        dfs(n, m, 0);
    }

    public static void dfs(int n, int m, int depth) {
        //재귀 깊이가 m과 같아지면 탐색과정에서 담았던 배열을 출력
        if(depth == m) {
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++) {
            //해당 노드 값을 방문하지 않았다면,
            if(visit[i] == false) {
                visit[i] = true;                //해당 노드를 방문상태로 변경
                arr[depth] = i + 1;             //해당 깊이를 index로 하여 i+1 값 저장
                dfs(n, m, depth + 1);     //다음 자식 노드 방문을 위해 depth 를 1씩 증가시키면서 재귀 호출

                //자식노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
    }
}
