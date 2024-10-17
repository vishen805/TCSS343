import java.util.*;

public class BruteForce {


//    public static List<List<Integer>> generateSubsets(List<Integer> S) {
//        int n = S.size();
//        List<List<Integer>> subsets = new ArrayList<>();
//        for(int i = 0; i < (1 << n); i++) {
//            List<Integer> subset = new ArrayList<>();
//            for(int j = 0; j < n; j++) {
//                if((i & (1 << j)) > 0) {
//                    subset.add(S.get(j));
//                }
//            }
//            subsets.add(subset);
//        }
//        if(subsets.size() == 0) {
//            System.out.println("False.");
//            return subsets;
//        }
//        else {
//            System.out.println("True.");
//            return subsets;
//
//        }
//    }
//
//    public static List<List<Integer>> checkSums(List<List<Integer>> subsets, int t) {
//        List<List<Integer>> sums = new ArrayList<>();
//        for(List<Integer> subset : subsets) {
//            int sum = 0;
//            for(int i : subset) {
//                sum += i;
//            }
//            if(sum == t) {
//                sums.add(subset);
//            }
//        }
//        return sums;
//    }

    public static int[][] generateSubsets(int[] S) {
        int n = S.length;
        int[][] subsets = new int[(1 << n)][];
        for(int i = 0; i < (1 << n); i++) {
            int[] subset = new int[n];
            int count = 0;
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) > 0) {
                    subset[count++] = S[j];
                }
            }
            subsets[i] = Arrays.copyOf(subset, count);
        }
        if(subsets.length == 0) {
            return subsets;
        }
        else {
            return subsets;
        }
    }

    public static int[][] checkSums(int[][] subsets, int t) {
        List<int[]> sums = new ArrayList<>();
        for(int[] subset : subsets) {
            int sum = 0;
            for(int i : subset) {
                sum += i;
            }
            if(sum == t) {
                sums.add(subset);
            }
        }
        return sums.toArray(new int[0][]);
    }


    public static void main(String[] args) {
       int[] S = {3, 5, 4, 7, 9, 2};
       int t = 17;
       int[][] subsets = generateSubsets(S);
       int[][] sums = checkSums(subsets, t);
       for(int i = 0; i < sums.length; i++){
            System.out.print("[");
            for(int j = 0; j < sums[i].length; j++){
                System.out.print(sums[i][j]+" ");
            }
            System.out.println("}");
       }
    }
}
