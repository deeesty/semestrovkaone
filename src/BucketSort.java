import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BucketSort {
    private static int iterations = 0;

    public static void main(String[] args) {
        int s = 100;
        int[] arr = generateRandomArray(s, 100000);

        System.out.println("Изначальный массив:");
        printArray(arr);

        long startTime = System.nanoTime();
        bucketSort(arr);
        long endTime = System.nanoTime();

        System.out.println("Отсортированный массив:");
        printArray(arr);

        System.out.println("Количество итераций: " + iterations);
        System.out.println("Время работы алгоритма: " + (endTime - startTime) + " nanoseconds");
        System.out.println(arr.length);
    }

    public static void bucketSort(int[] arr) {
        iterations = 0;
        int n = arr.length;
        int maxVal = getMaxValue(arr);

        List<Integer>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int value : arr) {
            iterations++;
            int bucketIndex = (value * n) / (maxVal + 1);
            buckets[bucketIndex].add(value);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    private static int getMaxValue(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > maxVal) {
                maxVal = value;
            }
        }
        return maxVal;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static int[] generateRandomArray(int size, int max) {
        Random random = new Random();
        return random.ints(size, 0, max).toArray();
    }

}
