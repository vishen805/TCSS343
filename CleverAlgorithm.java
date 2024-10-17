import java.util.Arrays;

public class CleverAlgorithm {
    public static boolean subsetSum(int[] S, int t) {
        int n = S.length;
        int[] L = Arrays.copyOfRange(S, 0, n/2);
        int[] H = Arrays.copyOfRange(S, n/2, n);

        int[] T = new int[(int) Math.pow(2,L.length)];
        int[] W = new int[(int) Math.pow(2,H.length)];
        sum(L,T);
        System.out.println("\n");
        sum(H,W);
        Arrays.sort(T);
        Arrays.sort(W);

        for (int i = 0; i < T.length; i++) {
            if (T[i] <= t) {
                int p = Arrays.binarySearch(W, t - T[i]);
                // System.out.println(p);

                if (p >= 0) {
                    return true;
                }
            }
        }

        // for (int i = 0; i < W.length; i++) {
        //     if (W[i] <= t) {
        //         int p = Arrays.binarySearch(T, t - W[i]);
        //         // System.out.println(p);

        //         if (p >= 0) {
        //             return true;
        //         }
        //     }
        // }
        return false;
    }

    public static void sum(int[] s, int[] x){
        int l = s.length;
        for (int i = 0; i < x.length; i++) {
            int a = 0;
            for (int j = 0; j < l; j++) {
                if ((i & (1 << j)) != 0) {
                    a += s[j];
                }
            }
            x[i] = a;
//            System.out.println(x[i]);

        }
    }


    public static void main(String[] args) {
        int[] S = {3, 5, 4, 7, 9, 2, 5};
        int t = 10;
        System.out.println(subsetSum(S, t));
    }
}
