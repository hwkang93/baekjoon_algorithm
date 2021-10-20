package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

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

            if(deque.size() != n) {
                stringBuilder.append("error").append("\n");
                continue;
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
            } catch (NoSuchElementException e) {
                stringBuilder.append("error").append("\n");
            }

            //결과
            stringBuilder.append("[");
            if(isReversed) {
                for(int j = 0; j < deque.size(); j++) {
                    stringBuilder.append(deque.pollLast()).append(",");
                }
            }
            else {
                for(int j = 0; j < deque.size(); j++) {
                    stringBuilder.append(deque.pollFirst()).append(",");
                }
            }

            if(!deque.isEmpty()) {
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            }

            stringBuilder.append("]").append("\n");
        }

        System.out.println(stringBuilder);
    }
}
