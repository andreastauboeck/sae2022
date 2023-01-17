package at.ac.fhwn.sae.lesson2;

public class Fibonacci {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            long time = System.currentTimeMillis();
            long result1 = getFibonacciNumberRecursiveSlow(i);
            System.out.println("Output for slow revursive " + i + " : " + result1);
            System.out.println("Calculation took " + (System.currentTimeMillis() - time) + "ms");

            time = System.currentTimeMillis();
            long result2 = getFibonacciNumberRecursive(i);
            System.out.println("Output for revursive " + i + " : " + result2);
            System.out.println("Calculation took " + (System.currentTimeMillis() - time) + "ms");

            time = System.currentTimeMillis();
            long result3 = getFibonacciNumberIterative(i);
            System.out.println("Output for iterative " + i + " : " + result3);
            System.out.println("Calculation took " + (System.currentTimeMillis() - time) + "ms \n");

            Thread.sleep(100);
        }
    }

    private static long getFibonacciNumberRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacciNumberRecursive(0, 1, n - 1);
        }
    }

    private static long getFibonacciNumberRecursive(long nMinusTwo, long nMinusOne, int counter) {
        if (counter == 0) return nMinusOne;
        return getFibonacciNumberRecursive(nMinusOne, nMinusTwo + nMinusOne, --counter);
    }

    public static long getFibonacciNumberRecursiveSlow (int number){
        if (number==0){
            return 0;
        }else if (number==1){
            return 1;
        }else{
            return getFibonacciNumberRecursiveSlow(number-1)+getFibonacciNumberRecursiveSlow(number-2);
        }
    }

    public static long getFibonacciNumberIterative(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            long temp1 = 0;
            long temp2 = 1;
            long result = 0;
            for (int i = 1; i < number; i++) {
                result = temp1 + temp2;
                temp1 = temp2;
                temp2 = result;
            }
            return result;
        }
    }
}
