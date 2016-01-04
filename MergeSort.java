package mergesort;
/**
 *
 * @author DIV
 */
public class MergeSort {
    public static int[] Merge(int[] lArray, int[] rArray, int[] iArray) {
        int left = lArray.length;
        int right = rArray.length;
        int resultantIndex = 0, leftIndex = 0, rightIndex = 0;
        while (leftIndex < left && rightIndex < right) {
            if (lArray[leftIndex] <= rArray[rightIndex]) {
                iArray[resultantIndex++] = lArray[leftIndex++];
            } else {
                iArray[resultantIndex++] = rArray[rightIndex++];
            }
        }
        while (leftIndex < left) {
            iArray[resultantIndex++] = lArray[leftIndex++];
        }
        while (rightIndex < right) {
            iArray[resultantIndex++] = rArray[rightIndex++];
        }
        return iArray;
    }

    public static int[] Sort(int[] iArray) {
        int mid, left, right;
        int length = iArray.length;
        if (length < 2) {
            return iArray;
        } else {  
            mid   = Math.floorDiv(length, 2);
            left = mid;
            right = (length - mid);
            int[] leftsubarray = new int[left];
            int[] rightsubarray = new int[right];
            for (int i = 0; i <= (mid - 1); i++) {
                leftsubarray[i] = iArray[i];
            }
            for (int i = mid; i <= (length - 1); i++) {
                rightsubarray[i - mid] = iArray[i];
            }
            Sort(leftsubarray);
            Sort(rightsubarray);
            iArray = Merge(leftsubarray, rightsubarray, iArray);
        }
        return iArray;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] inputArray = {900, 123, 765, 145, 9, 100, 189999};
        System.out.println("UnSorted Array:");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }
        inputArray = Sort(inputArray);
        System.out.println("Sorted Array:");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }
    }
}
