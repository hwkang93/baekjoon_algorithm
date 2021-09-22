package level14;

import java.util.Scanner;

/**
 *  15651. N과 M (3)
 *      자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *          - 1부터 N까지 자연수 중에서 M개를 고른 수열
 *          - 같은 수를 여러 번 골라도 된다.
 *
 *      첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
 *
 *      한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 *
 *      수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class Level14_3 {

    public static int[] node;
    public static int n, m;

    //System.out.println 으로 출력하니까 시간초과 됐음.
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        node = new int[m];

        dfs(0);
        System.out.println(stringBuilder);
    }

    public static void dfs(int depth) {
        if(m == depth) {
            for(int i=0; i< node.length; i++) {
                stringBuilder.append(node[i] + " ");
            }

            stringBuilder.append("\n");
            return;
        }

        for(int i=0; i < n; i++) {
            node[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
