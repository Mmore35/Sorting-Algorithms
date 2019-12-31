package sortingalgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithms {
    
    public static void UseArray(int array[], String Arrayname) {
        
        Instant start = Instant.now();
        SCBubblesort(array.clone());
        Instant finish = Instant.now();
        System.out.printf("Short Circuit BS sort time is: %,d%n", Duration.between(start, finish).toMillis());
    }
    
    public static void SCBubblesort(int arr[]) {
        long count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        System.out.printf("The step count of SCBS is: %,d%n", (count / 1000));
    }//The SCBS is a bubble sort with an added break statement that activates one the array is sorted. Only useful when the thing being sorted is nearly completely sorted already.

    public static void Bubblesort(int arr[]) {
        long count = 0;
        for (int i = 1; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.printf("The step count of BS is: %,d%n", (count / 1000));
    }//The bubble sort is implemented and "Steps" are counted. The bubble sort is not very useful when compaired to other sorts because it does not fulfill a specific purpose like SCBS and is more straining than others. 

    public static void selectionSort(int[] arr) {
      //  long count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
              //  count++;
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
       // System.out.printf("The step count of Selection Sort is: %,d%n", (count / 1000));
    }//Impliments Selection sort, A fairly effecent sort when compaired with BS

    public static void InsertionSort(int[] array) {
        int key, i, WS;
      //  long count = 0;

        for (i = 1; i < array.length; i++) {
            WS = i - 1;
            key = array[i];
            while (WS >= 0 && array[WS] > key) {
               // count++;
                array[WS + 1] = array[WS];
                WS -= 1;
            }
            array[WS + 1] = key;
        }
        //System.out.printf("The step count of Insertion Sort is: %,d%n", (count / 1000));
    }//Insertion sort where var WS stands for Wrong Spot. WS=j. Impliments Insertion sort, A very effecent sort when compaired with BS and SS. 

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] l = new int[mid];
        int[] r = new int[array.length - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            r[i - mid] = array[i];
        }
        mergeSort(l);
        mergeSort(r);
        Merge(array, l, r, mid, array.length - mid);
    }

    public static void Merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            } else {
                array[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }//Calls a merge sort that uses a divide and conqure type sort

    public static void QuickSort(int[] arr, int low, int high) {
        
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

         int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
   
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            QuickSort(arr, low, j);
        }
        if (high > i) {
            QuickSort(arr, i, high);
        }
    }//Quick sort is usually the best all around sorting method.

    public static void swap(int array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }//only called by quicksort

    public static void main(String[] args) {

        System.out.println("Please enter the size of your file:");

        Scanner input = new Scanner(System.in);
        int listSize = input.nextInt();

        int[] array = new int[listSize];
        Random rand = new Random();

        for (int i = 0; i < listSize; i++) {
            array[i] = rand.nextInt(1000);
        }
        /**
         * Instant start = Instant.now(); Bubblesort(array.clone()); Instant
         * finish = Instant.now(); System.out.printf("Bubble sort time is:
         * %,d%n", Duration.between(start, finish).toMillis());
         *
         * start = Instant.now(); SCBubblesort(array.clone()); finish =
         * Instant.now(); System.out.printf("Short Circuit BS sort time is:
         * %,d%n", Duration.between(start, finish).toMillis());
         
        Instant start = Instant.now();
        selectionSort(array.clone());
        Instant finish = Instant.now();
        System.out.printf("Selection sort time is: %,d %n", Duration.between(start, finish).toMillis());
         
        start = Instant.now();
        InsertionSort(array.clone());
        finish = Instant.now();
        System.out.printf("Insertion sort time is: %,d%n", Duration.between(start, finish).toMillis());
*/
        Instant start = Instant.now();
        mergeSort(array.clone());
        Instant finish = Instant.now();
        System.out.printf("Merge sort time is: %,d%n", Duration.between(start, finish).toMillis());

        start = Instant.now();
        QuickSort(array.clone(), 0, array.length - 1);
        finish = Instant.now();
        System.out.printf("Quick sort time is: %,d%n", Duration.between(start, finish).toMillis());
    }// contains given data that will run the program and display times for every sort.

}
