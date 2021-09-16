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

### 참고 블로그
[동빈나 블로그](https://m.blog.naver.com/ndb796/)