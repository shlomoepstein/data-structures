import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
// import java.util.Scanner;

class BubbleSort {
    public static int[][] intBubbleSort (int[] input) {
        int[] array = input.clone();
        int comparisons = 0,
            assignments = 0;

        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    assignments += 3;
                }
                comparisons++;
            }
        }

        return new int[][] {array, {comparisons, assignments}};
    }

    public static String[] stringBubbleSort (String[] input) {
        String[] array = input.clone();

        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}

class SelectionSort {
    public static int[][] intSelectionSort (int[] input) {
        int[] array = input.clone();
        int comparisons = 0,
            assignments = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            assignments++;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;

                    assignments++;
                }
                comparisons++;
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;

            assignments += 3;
        }

        return new int[][] {array, {comparisons, assignments}};
    }

    public static String[] stringSelectionSort (String[] input) {
        String[] array = input.clone();

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }

            String temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        return array;
    }
}

class InsertionSort {
    public static int[][] intInsertionSort (int[] input) {
        int[] array = input.clone();
        int comparisons = 0,
            assignments = 0;

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            assignments++;

            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];

                    assignments++;
                    comparisons++;
                    j--;
            }
            comparisons++;

            array[j + 1] = key;

            assignments++;
        }

        return new int[][] {array, {comparisons, assignments}};
    }

    public static String[] stringInsertionSort (String[] input) {
        String[] array = input.clone();

        for (int i = 1; i < array.length; i++) {
            String key = array[i];

            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

        return array;
    }
}

class MergeSort {
    public static int[][] intMergeSort (int[] input) {
        if (input.length == 1) {
            return new int[][] {input, {0, 0}};
        }

        int mid = input.length / 2;
        int[] left = new int[mid];
        int[] right = new int[input.length - mid];
        int[] sorted = new int[input.length];
        int comparisons = 0,
            assignments = 0;

        for (int i = 0; i < mid; i++) {
            left[i] = input[i];

            assignments++;
        }
        for (int i = mid; i < input.length; i++) {
            right[i - mid] = input[i];

            assignments++;
        }

        int[][] leftResults = intMergeSort(left);
        left = leftResults[0];
        comparisons += leftResults[1][0];
        assignments += leftResults[1][1];
        int[][] rightResults = intMergeSort(right);
        right = rightResults[0];
        comparisons += rightResults[1][0];
        assignments += rightResults[1][1];

        int i = 0,
            j = 0,
            k = 0;

        while (j < mid && k < input.length - mid) {
            if (left[j] > right[k]) {
                sorted[i] = right[k];
                i++;
                k++;

                comparisons++;
                assignments++;
            } else {
                sorted[i] = left[j];
                i++;
                j++;

                comparisons++;
                assignments++;
            }
        }

        while (j < mid) {
            sorted[i] = left[j];
            i++;
            j++;

            assignments++;
        }

        while (k < input.length - mid) {
            sorted[i] = right[k];
            i++;
            k++;

            assignments++;
        }

        return new int[][] {sorted, {comparisons, assignments}};
    }

    public static String[] stringMergeSort (String[] input) {
        String[] array = input.clone();

        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;

        String[] left = Arrays.copyOfRange(array, 0, mid);
        String[] right = Arrays.copyOfRange(array, mid, array.length);

        left = stringMergeSort(left);
        right = stringMergeSort(right);

        int i = 0, j = 0, k = 0;

        while (j < mid && k < array.length - mid) {
            if (left[j].compareTo(right[k]) > 0) {
                array[i++] = right[k++];
            } else {
                array[i++] = left[j++];
            }
        }

        while (j < mid) {
            array[i++] = left[j++];
        }

        while (k < array.length - mid) {
            array[i++] = right[k++];
        }

        return array;
    }
}

class QuickSort {
    public static int[][] intQuickSort (int[] input) {
        int[] array = input.clone();
        int[] stats = intSort(array, 0, array.length);

        return new int[][] {array, stats};
    }

    private static int[] intSort (int[] array, int start, int end) {
        if (end - start <= 1) {
            return new int[] {0, 0};
        }

        int pivot = start,
            left = start;

        int comparisons = 0,
            assignments = 0;

        for (int i = start + 1; i < end; i++) {
            if (array[i] < array[pivot]) {
                left++;

                int temp = array[left];
                array[left] = array[i];
                array[i] = temp;

                assignments += 3;
            }
            comparisons++;
        }

        int temp = array[start];
        array[start] = array[left];
        array[left] = temp;

        assignments += 3;

        int[] stats;

        stats = intSort(array, start, left);
        comparisons += stats[0];
        assignments += stats[1];
        stats = intSort(array, left + 1, end);
        comparisons += stats[0];
        assignments += stats[1];

        return new int[] {comparisons, assignments};
    }

    public static String[] stringQuickSort (String[] input) {
        String[] array = input.clone();

        stringSort(array, 0, array.length);

        return array;
    }

    private static void stringSort (String[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        
        int pivot = start;
        int left = start;

        for (int i = start + 1; i < end; i++) {
            if (array[i].compareTo(array[pivot]) < 0) {
                left++;

                String temp = array[left];
                array[left] = array[i];
                array[i] = temp;
            }
        }

        String temp = array[start];
        array[start] = array[left];
        array[left] = temp;

        stringSort(array, start, left);
        stringSort(array, left + 1, end);
    }
}

class SequentialSearch {
    public static int[] intSequentialSearch (int[] array, int value) {
        int comparisons = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                comparisons++;
                return new int[] {i, comparisons};
            }
            comparisons++;
        }

        return new int[] {-1, comparisons};
    }

    public static int stringSequentialSearch (String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }
}

class BinarySearch {
    public static int[] intBinarySearch (int[] array, int value) {
        int start = 0,
            end = array.length,
            comparisons = 0;

        while (start < end) {
            int mid = (start + end) / 2;

            if (array[mid] == value) {
                comparisons++;
                return new int[] {mid, comparisons};
            } else if (array[mid] < value) {
                comparisons++;
                start = mid + 1;
            } else {
                comparisons++;
                end = mid;
            }
        }

        return new int[] {-1, comparisons};
    }

    public static int stringBinarySearch (String[] array, String value) {
        int start = 0,
            end = array.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (array[mid].compareTo(value) == 0) {
                return mid;
            } else if (array[mid].compareTo(value) < 0) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return -1;
    }
}

class TestIntSort {
    interface SortFunction {
        int[][] sort (int[] array);
    }

    public static void testSort (int[] array, SortFunction sortFunction) {
        int[][] results = sortFunction.sort(array);
        int[] sorted = results[0];
        int[] stats = results[1];

        System.out.println(Arrays.toString(sorted));
        System.out.println(array.length + " elements: " +
                           stats[0] + " comparisons, " +
                           stats[1] + " assignments, " +
                           (stats[0] + stats[1]) + " total");
    }

    public static void main (String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter space-separated integers (press Enter to end input):");
        // int[] intArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        // scanner.close();

        int size = args.length > 0 ? Integer.parseInt(args[0]) : 35;
        int bound = args.length > 1 ? Integer.parseInt(args[1]) : 1000;
        int[] array = ThreadLocalRandom.current().ints(size, 0, bound).toArray();
        
        System.out.println("Unsorted array");
        System.out.println(Arrays.toString(array));
        
        System.out.println("\nBubble sort");
        testSort(array, BubbleSort::intBubbleSort);
        System.out.println("\nSelection sort");
        testSort(array, SelectionSort::intSelectionSort);
        System.out.println("\nInsertion sort");
        testSort(array, InsertionSort::intInsertionSort);
        System.out.println("\nMerge sort");
        testSort(array, MergeSort::intMergeSort);
        System.out.println("\nQuicksort");
        testSort(array, QuickSort::intQuickSort);
    }
}

class TestIntSearch {
    interface SearchFunction {
        int[] search (int[] array, int value);
    }

    public static void testSearch (int[] array, int value, SearchFunction searchFunction) {
        int[] results = searchFunction.search(array, value);

        if (results[0] == -1) {
            System.out.println("Did not find " + value + " in " +
                               results[1] + " comparisons");
        } else {
            System.out.println("Found " + value + " at index " + results[0] +
                               " in " + results[1] + " comparisons");      
        }
    }

    public static void main (String[] args) {
        int size = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        int bound = args.length > 1 ? Integer.parseInt(args[1]) : 500;
        int[] array = ThreadLocalRandom.current().ints(size, 0, bound).toArray();
        int[] sorted = MergeSort.intMergeSort(array)[0];
        int value = ThreadLocalRandom.current().nextInt(bound);

        System.out.println("Searching a sorted array of " + size + " elements");
        System.out.println("\nSequential search");
        testSearch(sorted, value, SequentialSearch::intSequentialSearch);
        System.out.println("\nBinary search");
        testSearch(sorted, value, BinarySearch::intBinarySearch);
    }
}

class TestStringSort {
    interface SortFunction {
        String[] sort (String[] array);
    }

    static void testSort (String[] array, SortFunction sortFunction) {
        String[] sorted = sortFunction.sort(array);
        System.out.println(Arrays.toString(sorted));
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("no file entered");
            return;
        }

        ArrayList<String> arrayList = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return;
        }

        String[] array = arrayList.toArray(String[]::new);

        System.out.println("Unsorted array");
        System.out.println(Arrays.toString(array));

        System.out.println("\nBubble sort");
        testSort(array, BubbleSort::stringBubbleSort);
        System.out.println("\nSelection sort");
        testSort(array, SelectionSort::stringSelectionSort);
        System.out.println("\nInsertion sort");
        testSort(array, InsertionSort::stringInsertionSort);
        System.out.println("\nMerge sort");
        testSort(array, MergeSort::stringMergeSort);
        System.out.println("\nQuicksort");
        testSort(array, QuickSort::stringQuickSort);
    }
}

class TestStringSearch {
    interface SearchFunction {
        int search (String[] array, String value);
    }

    public static void testSearch (String[] array, String value, SearchFunction searchFunction) {
        int index = searchFunction.search(array, value);

        if (index == -1) {
            System.out.println("Did not find " + value);
        } else {
            System.out.println("Found " + value + " at index " + index);      
        }
    }

    public static void main (String[] args) {
        if (args.length == 0) {
            System.out.println("no file entered");
            return;
        }

        ArrayList<String> arrayList = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return;
        }

        String[] array = arrayList.toArray(String[]::new);

        String[] sorted = MergeSort.stringMergeSort(array);
        String value = sorted[ThreadLocalRandom.current().nextInt(sorted.length)];

        System.out.println("Searching a sorted array of " + sorted.length + " elements");
        System.out.println("\nSequential search");
        testSearch(sorted, value, SequentialSearch::stringSequentialSearch);
        System.out.println("\nBinary search");
        testSearch(sorted, value, BinarySearch::stringBinarySearch);
    }
}
