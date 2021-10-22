package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/*
오류 케이스
[입력]
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
R
0
[]

[출력]
[2,1]
error
[1,2,3,58]
[]

[올바른 답]
[2,1]
error
[1,2,3,5,8]
[]

 */
public class Level19_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int t = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < t; i ++) {
            String p = bufferedReader.readLine();
            int n = Integer.parseInt(bufferedReader.readLine());
            Deque<Integer> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(),"[,]");

            while (st.hasMoreElements()) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false;
            try {
                for (char c : p.toCharArray()) {
                    if(c == 'R') {
                        isReversed = isReversed ? false : true;
                        continue;
                    }

                    if(isReversed) {
                        deque.removeLast();
                    }
                    else {
                        deque.removeFirst();
                    }
                }

                //결과
                stringBuilder.append("[");
                if(isReversed) {
                    while (!deque.isEmpty()) {
                        stringBuilder.append(deque.pollLast()).append(",");
                    }
                }
                else {
                    while (!deque.isEmpty()) {
                        stringBuilder.append(deque.pollFirst()).append(",");
                    }
                }
                if(stringBuilder.lastIndexOf(",") > -1) {
                    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
                }

                stringBuilder.append("]").append("\n");
            } catch (NoSuchElementException e) {
                stringBuilder.append("error").append("\n");
            }

        }

        System.out.println(stringBuilder);
    }
}
