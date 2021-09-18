package level12;

import java.util.*;

public class Level12_4 {
    public static void main(String[] args) {
        int[] arr = {1,3,8,-2,2};

        List<Integer> list = new ArrayList<>();

        for(int i : arr) {
            list.add(i);
        }

        Collections.sort(list);

        //산술평균 : N개의 수들의 합을 N으로 나눈 값
        int sum = list.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("합 : " + sum);

        //중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        //       5개면 0,1,2,3,4 -> 2번째 -> 5/2
        int centerValue = list.get(list.size()/2);
        System.out.println("중앙값 : " + centerValue);

        //최빈값 : N개의 수들 중 가장 많이 나타나는 값
        //만약 최빈값이 여러개인 경우 가장 두번째로 가장 작은 값을 출력해야 함.
        int result = 0;
        int resultCount = 0;

        int count = 1;
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) == list.get(i+1)) {
                count ++;
            } else {

            }
        }


        //범위 : N개의 수들 중 최댓값과 최솟값의 차이
        int minValue = list.get(0);
        int maxValue = list.get(list.size()-1);

        System.out.println("범위 : " + (maxValue - minValue));
    }
}
