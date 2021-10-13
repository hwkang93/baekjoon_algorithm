package level18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level18_1 {
    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<n; i++) {

            String line = bufferedReader.readLine();
            String[] str = line.split(" ");
            switch (str[0]) {
                case "push" :
                    stack.push(Integer.parseInt(str[1]));
                    break;
                case "pop" :
                    stringBuilder.append(stack.pop()).append('\n');
                    break;
                case "size" :
                    stringBuilder.append(stack.size()).append('\n');
                    break;
                case "empty" :
                    stringBuilder.append(stack.empty()).append('\n');
                    break;
                case "top" :
                    stringBuilder.append(stack.top()).append('\n');
                    break;

            }
        }

        System.out.println(stringBuilder);
    }

    static class Stack {
        private int[] arr = new int[10000];
        private int size = 0;

        public void push(int x) {
            arr[size] = x;

            size += 1;
        }

        public int pop() {
            if(size == 0) {
                return -1;
            }

            int result = arr[size-1];
            arr[size-1] = 0;
            size -= 1;

            return result;
        }

        public int size() {

            return size;
        }

        public int empty() {
            return size == 0? 1 : 0;
        }

        public int top() {
            if(size == 0) {
                return -1;
            }

            return arr[size-1];
        }
    }
}
