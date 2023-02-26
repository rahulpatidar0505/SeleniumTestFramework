package javaPrograms;

import java.util.Arrays;

public class Test {

    public static void main(String [] arg){
        int a[] = {1, 2, 0, 2, 5, 0, 6, 3};
        int n = a.length;

// Initialize two pointers, one for non-zero elements and another for zeros
        int i = 0;
        int j = 0;

// Traverse the array with non-zero pointer i
        while (i < n) {
            if (a[i] != 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
            i++;
        }

// Sort the non-zero elements in non-descending order
        Arrays.sort(a, j, n);

// Print the output array
        for (int k = 0; k < n; k++) {
            System.out.print(a[k] + " ");
        }

    }
}
