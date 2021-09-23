package level12;

import java.util.*;

public class Level12_4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<n; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);

        //산술평균 : N개의 수들의 합을 N으로 나눈 값
        int sum = list.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();
        double avg = (double) sum/(double) list.size();

        //산술평균 출력
        System.out.println(Math.round(avg));

        //중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        //       5개면 0,1,2,3,4 -> 2번째 -> 5/2
        int centerValue = list.get(list.size()/2);

        //중앙값 출력
        System.out.println(centerValue);

        //최빈값 : N개의 수들 중 가장 많이 나타나는 값
        //만약 최빈값이 여러개인 경우 가장 두번째로 가장 작은 값을 출력해야 함.
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i : list) {
            if(map.get(i) == null) {
                map.put(i, 1);
            } else {
                int value = map.get(i);
                map.put(i, value += 1);
            }
        }

        //Value 값 기준으로 객체 정렬
        List<Map.Entry<Integer, Integer>> sortedValueList = new LinkedList<>(map.entrySet());

        Collections.sort(sortedValueList, ((o1, o2) -> o2.getValue() - o1.getValue()));

        //Value 0번째 값과 1번째 값이 같은 경우 1번째 값 출력
        //(최빈값이 여러개인 경우 두번째로 작은 값을 출력해야 하기 때문에)
        //최빈값 출력
        if(sortedValueList.size() == 1) {
            System.out.println(sortedValueList.get(0).getKey());
        }
        else if(sortedValueList.get(0).getValue() == sortedValueList.get(1).getValue()) {
            System.out.println(sortedValueList.get(1).getKey());
        //Value 0번째 값과 1번째 값이 다른 경우 0번째 값 출력
        }
        else {
            System.out.println(sortedValueList.get(0).getKey());
        }



        //범위 : N개의 수들 중 최댓값과 최솟값의 차이
        int minValue = list.get(0);
        int maxValue = list.get(list.size()-1);

        //범위 출력
        System.out.println(maxValue - minValue);
    }
}
