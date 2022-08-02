package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String[] seansons = new String[4];
        seansons[0]="winter";
        seansons[1]="spring";
        seansons[2]="summer";
        seansons[3]="autumn";

        return seansons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] numbers = new int[length];
        for(int i=1;i<=length;i++)
            numbers[i-1]=i;

        return numbers;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int n = arr.length, sum=0;
        for(int i=0;i<n;i++)
            sum+=arr[i];

        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int n = arr.length;
        for(int i=0;i<n;i++)
            if(arr[i]==number) {
                return i;
            }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        int n = arr.length;
        String[] reverseArr = new String[n];

        for(int i=n-1,j=0;i>=0;i--,j++)
            reverseArr[j]=arr[i];

        return reverseArr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int n = arr.length, k=0;
        for(int i=0;i<n;i++)
            if(arr[i]>0)
                k++;
        int[] posNumbers = new int[k];
        for(int i=0,j=-1;i<n;i++) {
           if(arr[i]>0) {
               j++;
               posNumbers[j]=arr[i];
           }
        }
        return posNumbers;
    }
    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */

    public static int[] sort(int[] array) {
        int n = array.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<i;j++){
                if(array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        return array;
    }
    public static int[][] sortRaggedArray(int[][] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++)
        for(int j=0;j<i;j++){
            if(arr[j].length > arr[j+1].length) {
                int[] temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }

        int[][] newarr = new int[n][];
        for(int i=0;i<n;i++)
            newarr[i]=sort(arr[i]);

        for(int i=0;i<n;i++) {
            int k = newarr[i].length;
            for(int j=0;j<k;j++)
                System.out.println(newarr[i][j]);
        }
        return newarr;
    }

    public static void main(String[] args) {
        int [][] arr= new int[][]{{3,1,2},{3,2}};
        sortRaggedArray(arr);
    }
}
