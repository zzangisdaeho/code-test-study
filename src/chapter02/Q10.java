package chapter02;

import java.util.Scanner;

public class Q10 {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(solution(n, arr));

    }

    private static int solution(int n, int[][] arr) {

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = 0, down = 0, left = 0, right = 0;
                boolean u = false, d = false, l = false, r = false;
                if (i == 0) u = true;
                if (j == 0) l = true;
                if (i == n - 1) d = true;
                if (j == n - 1) r = true;

                if (!u) up = arr[i - 1][j];
                if (!d) down = arr[i + 1][j];
                if (!l) left = arr[i][j - 1];
                if (!r) right = arr[i][j + 1];

                int point = arr[i][j];
                if (point > up && point > down && point > left && point > right) {
                    result++;
                }
            }
        }

        return result;
    }

}
