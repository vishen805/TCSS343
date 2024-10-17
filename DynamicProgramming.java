public class DynamicProgramming {

    public static void main(String[] args) throws Exception {
        int list[] = {3, 7, 2, 5, 8};
        int t = 15;

        System.out.println(P2(list, t));
    }

    public static boolean P2(int[] S, int t) {
        int n = S.length;
        boolean[][] A = new boolean[n + 1][t + 1];

        for (int i = 0; i <= n; i++) {
            A[i][0] = true;
        }

        for (int j = 1; j <= t; j++) {
            if(S[1] == j){
                A[1][j] = true;
            } else {
                A[1][j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (j >= S[i - 1]) {
                    A[i][j] = A[i - 1][j] || A[i - 1][j - S[i - 1]];
                } else {
                    A[i][j] = A[i - 1][j];
                }
            }
        }

        return A[n][t];

    }
}
