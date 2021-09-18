# 정렬 알고리즘

### 선택 정렬(Selection Sort)

가장 작은 것을 선택해서 제일 앞으로 보내는 알고리즘

가장 작은 값을 앞에서부터 채워가는 방식

시간 복잡도 O(N^2)

```java
class Main {
    public void selectionSort(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            int min = 9999;
            int index = 0;

            for(int j=i; j<arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;

        }

        print(arr);
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
```

### 버블 정렬(Bubble Sort)

바로 뒤에 있는 값과 비교해서 더 작은 값을 앞으로 보내는 알고리즘

가장 큰 값을 뒤에서부터 채워가는 방식

시간 복잡도 O(N^2)

```java
class Main {
    public void bubbleSort(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        print(arr);
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
```

### 삽입 정렬(Insertion Sort)

노드를 뒤의 값들과 비교해가며 해당 노드를 적절한 위치에 삽입하는 알고리즘

데이터가 이미 거의 정렬된 상태에 한해서는 어떤 알고리즘보다도 빠르다.

시간 복잡도 O(N^2)

```java
class Main {
    public static void insertionSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int j=i;
            while (j >= 0 && arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j--;
            }
        }
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
```

### 카운팅 정렬(Counting Sort)

counting 배열을 하나 만들고 정렬할 배열의 값들을 counting 배열의 인덱스로 추가하는 방식

다른 정렬과는 다르게 배열의 다른 값과 비교하지 않는다.

```java
public class Level12_3 {
  public static void main(String[] args) {
    int[] arr = {5, 2, 1, 6, 3, 7, 9, 8, 4};
    //범위 : 수의 범위 만큼
    int[] countArr = new int[10001];
    int[] resultArr = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      countArr[arr[i]] += 1;
    }

    for (int i = 1; i < countArr.length - 1; i++) {
      countArr[i] += countArr[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      int value = arr[i];
      countArr[value]--;
      resultArr[countArr[value]] = value;
    }

    for (int i = 0; i < resultArr.length; i++) {
      System.out.println(resultArr[i]);
    }
  }
}

```

### JAVA 에서 제공하는 정렬 함수들이 사용하고 있는 알고리즘

- Arrays.sort() 는 **dual-pivot Quicksort** 알고리즘을 사용한다.
  - 평균 시간복잡도 : O(n long n)
  - 최악의 경우 : O(n^2)
- Collections.sort() 는 Timsort를 사용한다.
  - Timsort 는 합병 및 삽입 정렬을 사용한다.
  - Timsort 처럼 두 가지 알고리즘이 섞여 있는 정렬 알고리즘을 **hybrid sorting algorithm** 이라고 한다.
  - hybrid sorting algorithm 은 안정 정렬(stable sort)이기 때문에 hybrid stable sorting algorithm 이라고도 한다.
- 합병 정렬(Merge Sort)의 경우 최선, 최악 모두 O(n log n) 의 시간복잡도를 가진다.
- 삽입 정렬(Insertion sort)의 경우 최선은 O(n), 최악의 경우는 O(n^2)의 시간복잡도를 가진다.



### 참고 블로그
[동빈나 블로그](https://m.blog.naver.com/ndb796/)

[st-lab 블로그](https://st-lab.tistory.com/106)