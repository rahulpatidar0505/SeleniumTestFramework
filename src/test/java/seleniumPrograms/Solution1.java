package seleniumPrograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int firstNumber=A[0];
        for (int i = 0; i < A.length; i++) {
            if(A[i]==firstNumber+1){
                firstNumber = A[i];
            }
            if(A[i]<=0){
                firstNumber = 0;
            }
        }

        return firstNumber+1;
    };

    public static int[] rotateArray(int[] arr, int k) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int newIndex = (i + k) % arr.length;
            result[newIndex] = arr[i];
        }
        return result;
    }

    public static int countDistinct(int[] arr) {
        Set<Integer> distinct = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            distinct.add(arr[i]);
        }
        return distinct.size();
    }

    public int maximal_product_of_any_triplet(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int maxProduct = A[N-1] * A[N-2] * A[N-3];
        if (A[0] < 0 && A[1] < 0) {
            int altMaxProduct = A[0] * A[1] * A[N-1];
            if (altMaxProduct > maxProduct) {
                maxProduct = altMaxProduct;
            }
        }
        return maxProduct;
    }

    class triangular_triplet  {
        public int solution(int[] A) {
            int N = A.length;
            Arrays.sort(A);

            for (int i = 0; i < N-2; i++) {
                if ((long) A[i] + A[i+1] > A[i+2]) {
                    return 1;
                }
            }

            return 0;
        }
    }

    class unpairedElement {
        public int solution(int[] A) {
            int unpaired = 0;
            for (int i = 0; i < A.length; i++) {
                unpaired ^= A[i];
            }
            return unpaired;
        }
    }

}