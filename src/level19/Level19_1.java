package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Level19_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            switch (stringTokenizer.nextToken()) {
                case "push" :
                    queue.offer(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "pop" :
                    int poll = queue.poll();
            }
        }
    }
}
