package javaPrograms;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPrograms {

    @Test()
    public static void CommonElementInGivenArray() {
        int[] a = {3, 7, 2, 3, 1, 44, 31, 7, 44};

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) { // checking in same array, so will start from next number
                if (a[i] == a[j]) {
                    System.out.println(a[i]);
                }
            }
        }
    }

    @Test()
    public void CommonElementInTwoArrays() {
        int[] a = {3, 7, 2, 9, 1, 44, 31};
        int[] b = {7, 8, 1, 10, 44};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) { // checking in 2 arrays, so will start from 0
                if (a[i] == b[j]) {
                    System.out.println(a[i]);
                }
            }
        }
    }

    @Test()
    public static void RemoveDuplicateFromArray() {
        int[] a = {2, 4, 6, 2, 77, 4};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] != a[j]) {
                    if (!list.contains(a[i])) {
                        list.add(a[i]);
                    }
                }
            }
        }
        System.out.println(list);
    }

    @Test()
    public static void LargestInArray() {
        int[] a = {4, 25, 7, 25, 41, 23, 25, 42, 42};

        int largest = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                largest = a[i];
            }
        }
        System.out.println(largest);
    }

    @Test()
    public static void SmallestInArray() {
        int[] a = {40, 25, 7, 25, 41, 23, 25, 42, 42};

        int smallest = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                smallest = a[i];
            }
        }
        System.out.println(smallest);
    }

    @Test()
    public static void SortArray() {
        int[] a = {3, 7, 2, 9, 1, 44, 31};

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            System.out.println(a[i]);
        }
    }
    @Test()
    public static void SortArrayReverseOrder() {
        int[] a = {3, 7, 2, 9, 1, 44, 31};

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            System.out.println(a[i]);
        }
    }

    @Test
    public static void SecondHighestInGivenArray() {
        int[] a = {3, 7, 2, 9, 1, 44, 31};

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

        }
        //smallest
        System.out.println(a[a.length - (a.length - 1)]);

        // highest element in given array
        System.out.println(a[a.length - 1]);

        // 2nd highest element in given array
        System.out.println(a[a.length - 2]);
    }

    @Test
    public static void findMissingNumberInSequenceArray() {
        int[] a = {4, 5, 6, 8, 9};
        Arrays.sort(a); //1st sort array

        int firstNumber = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] == (firstNumber + 1)) { // addition of "number+1" is next number in sequential array
                firstNumber = a[i];
            } else {
                System.out.println("missing = " + (firstNumber + 1));
                break;
            }
        }
    }

    @Test
    public static void sumOfNumberInArray() {
        int a[] = {2, 4, 56, 9};
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        System.out.println(sum);
    }

    @Test
    public static void DifferBy7() {
        int[] a = {5, 1, 8, 9};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if ((a[i] - a[j]) == 7) {
                    System.out.println("Match Found !!");
                    System.out.println("X= " + a[i]);
                    System.out.println("Y= " + a[j]);
                }
            }
        }
    }

    @Test
    public static void CompareTwoArray() {
        int array1[] = {1, 2, 3, 4};
        int array2[] = {1, 2, 3};

        if (array1.length != array2.length) {
            System.out.println("The arrays are not equal.");
        } else {
            boolean arraysAreEqual = true;
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    arraysAreEqual = false;
                    break;
                }
            }
            if (arraysAreEqual) {
                System.out.println("The arrays are equal.");
            } else {
                System.out.println("The arrays are not equal.");
            }
        }
    }

    @Test
    public static void CompareTwoArray2ndWay() {
        int array1[] = {1, 2, 3, 4};
        int array2[] = {1, 2, 3};

        if (Arrays.equals(array1, array2)) {
            System.out.println("The arrays are equal.");
        } else {
            System.out.println("The arrays are not equal.");
        }

    }

    @Test
    public static void CheckElementofstringisnumber() {
        String[] array = { "abc", "123", "xyz", "2" };

        for (String element : array) {
            try {
                int number = Integer.parseInt(element);
                System.out.println(number + " is a valid integer.");
            } catch (NumberFormatException e) {
                System.out.println(element + " is not a valid integer.");
            }
        }
    }

    @Test
    public static void isDivisibleBy() {
        int a[] = {1, 2, 3, 5, 15, 18};

        for (int i = 0; i < a.length; i++) {
            if(a[i]%(3*5)==0){
                System.out.println(a[i]+" number is divided by both 3 and 5");
            } else if (a[i]%3==0) {
                System.out.println(a[i]+" number is divided by 3 only");
            } else if (a[i]%5==0) {
                System.out.println(a[i]+" number is divided by 5 only");
            }
            else
                System.out.println(a[i]+" number is not divided by any");
        }

    }
}