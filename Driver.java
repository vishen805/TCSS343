import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;

public class Driver {

    int n;
    int r;
    int t;
    boolean v;
    int[] testList;

    public int[] driver(int n, int r, boolean v) {
        int total = 0;
        int[] S = new int[n];
        Random randomInt = new Random();
        for (int i = 0; i < n; i++) {
            S[i] = randomInt.nextInt(r) + 1;
            total += S[i];
        }
        if (!v) {
            t = total + randomInt.nextInt(r);
        } else {
            t = 0;
            for (int i = 0; i < Math.min(3, n); i++) {
                t += S[i];
            }
        }
        return S;
    }

    @Test
    public void testAll() {

        r = 1000;
        boolean b = false;
        for (int n = 5; n <= 25; n++) {
            testList = driver(n, r, b);
            // System.out.println("Here is a list of size n = " + n + " where r = " + r + " with random numbers between 1 and " + r +
            //         "\ncontaining a subset summing to t = " + t);
            printList(testList);
            System.out.println("Here is the subset(s) summing to t = " + t);
            //print2DArray(BruteForce.checkSums(BruteForce.generateSubsets(testList), t));
            //testBruteForce(testList, t, n);
            //testDynamicProgramming(testList, t, n);
            testCleverAlgorithm(testList, t, n);
            System.out.println("\n");
        }



    }

    public void testBruteForce(int[] S, int t, int n) {
            long start = System.currentTimeMillis();
            BruteForce.checkSums(BruteForce.generateSubsets(testList), t);
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            System.out.println("Runtime for brute force algorithm with list size " + n + ": " + totalTime + " milliseconds");

    }


    public void testCleverAlgorithm(int[] S, int t, int n) {
            long start = System.currentTimeMillis();
            CleverAlgorithm.subsetSum(testList, t);
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            System.out.println("Runtime for clever algorithm with list size " + n + ": " + + totalTime + " milliseconds");

    }

    public void testDynamicProgramming(int[] S, int t, int n) {
            long start = System.currentTimeMillis();
            DynamicProgramming.P2(testList, t);
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            System.out.println("Runtime for dynamic programming algorithm with list size " + n + ": " + + totalTime + " milliseconds");


    }

    public void print2DArray(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print("[");
            for(int j = 0; j < array[i].length - 1; j++) {
                System.out.print(array[i][j] + ", ");
            }
            if(array[i].length > 0) {
                System.out.print(array[i][array[i].length - 1]);
            }
            System.out.println("]");
        }
    }
    public void printList(int[] list) {
        System.out.print("[");
        for(int i = 0; i < list.length - 1; i++) {
            System.out.print(list[i] + ", ");
        }
        if(list.length > 0) {
            System.out.print(list[list.length - 1]);
        }
        System.out.print("]\n");
    }
}
