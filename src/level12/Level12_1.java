package level12;

public class Level12_1 {
    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        //selectionSort(arr);
        //bubbleSort(arr);
        insertionSort(arr);
    }

    public static void selectionSort(int[] arr) {
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

    public static void bubbleSort(int[] arr) {
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



    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
