import java.util.Arrays;
import java.util.Random;

class ArrayOperations {
    private int[] array;

    public ArrayOperations (int size) {
        array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000);
        }
    }

    public void insertElementAtIndex (int index, int element) {
        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = element;
        for (int i = index + 1; i <= array.length; i++) {
            newArray[i] = array[i - 1];
        }

        array = newArray;
    }

    public void appendElement (int element) {
        insertElementAtIndex(array.length, element);
    }

    public void insertAtHead (int element) {
        insertElementAtIndex(0, element);
    }

    public void deleteElementAtIndex (int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] newArray = new int[array.length - 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index; i < array.length - 1; i++) {
            newArray[i] = array[i + 1];
        }

        array = newArray;
    }

    public void deleteTail () {
        deleteElementAtIndex(array.length - 1);
    }

    public void deleteHead () {
        deleteElementAtIndex(0);
    }

    public void printArray () {
        System.out.println(Arrays.toString(array));
    }

    public static int[] mergeArrays (int[] arr1, int[] arr2) {
        int[] newArray = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            newArray[i] = arr1[i];
        }
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            newArray[i] = arr2[i - arr1.length];
        }

        return newArray;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayOperations testArray = new ArrayOperations(10);

        System.out.println("array = new ArrayOperations(10)");
        testArray.printArray();
        testArray.insertElementAtIndex(3, 69);
        System.out.println("\narray.insertElementAtIndex(3, 69)");
        testArray.printArray();
        testArray.appendElement(42);
        System.out.println("\narray.appendElement(42)");
        testArray.printArray();
        testArray.insertAtHead(256);
        System.out.println("\narray.insertAtHead(256)");
        testArray.printArray();
        testArray.deleteElementAtIndex(7);
        System.out.println("\narray.deleteElementAtIndex(7)");
        testArray.printArray();
        testArray.deleteTail();
        System.out.println("\narray.deleteTail()");
        testArray.printArray();
        testArray.deleteHead();
        System.out.println("\narray.deleteHead()");
        testArray.printArray();
        
        int[] mergedArray = ArrayOperations.mergeArrays(new int[] {1, 2, 3}, new int[] {4, 5, 6});
        System.out.println("\nArrayOperations.mergeArrays(new int[] {1, 2, 3}, new int[] {4, 5, 6})");
        System.out.println(Arrays.toString(mergedArray));
    }
}
