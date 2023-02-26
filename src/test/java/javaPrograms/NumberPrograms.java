package javaPrograms;

import org.testng.annotations.Test;

public class NumberPrograms {
    @Test
    public static void HigeshetInThreeNumber() {
        int a = 10;
        int b = 94;
        int c = 8;

        if (a > b && a > c) {
            System.out.println("a is highest number");
        } else if (b > c && b > a) {
            System.out.println("b is higest");
        } else {
            System.out.println("c is highest");
        }
    }

    @Test
    public static void PrimeNoBwTwoNumber() {
        int i = 0;
        int num = 0;
        String primeNumbers = "";

        for (i = 1; i <= 100; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to 100 are :");
        System.out.println(primeNumbers);
    }

    @Test
    public static void SwapTwoNumberWithoutThirdVariable() {
        int a = 10;
        int b = 5;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public static void reverseNumber() {
        int n = 12345, rev = 0;
        while (n != 0) {
            int r = n % 10;
            n = n / 10;
            rev = rev * 10 + r;
        }
        System.out.println("Reversed = " + rev);
    }

    @Test
    public static void numberManupulation() {

        int a = 12;
        int b = 34;
        //int output = 1324;

        String s1 = String.valueOf(a);
        char c1[] = s1.toCharArray();

        String s2 = String.valueOf(b);
        char c2[] = s2.toCharArray();

        String num=c1[0]+""+c2[0]+""+c1[1]+""+c2[1];
        Integer.parseInt(num);
        System.out.println(num);
    }

    @Test
    public static void primeNumber() {
        int num = 37;
        int count = 0;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.print("This is a Prime Number");
        } else {
            System.out.print("This is not a Prime Number");
        }
    }

    @Test
    public static void FibonnociSeries() {

        int count = 7, num1 = 0, num2 = 1;
        System.out.print("Fibonacci Series of " + count + " numbers:");

        for (int i = 1; i <= count; ++i) {
            System.out.print(num1 + " ");

            /*
             * On each iteration, we are assigning second number to the first number and
             * assigning the sum of last two numbers to the second number
             */
            int sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
        }
    }
}
