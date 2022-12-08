package chapter02;

import java.util.Scanner;

public class Q9 {

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
        int max = 0;

        //수평합
        int horizonSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                horizonSum += arr[i][j];
            }
            if (horizonSum > max) max = horizonSum;
            horizonSum = 0;
        }

        //수직합
        int verticalSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                verticalSum += arr[j][i];
            }
            if (verticalSum > max) max = verticalSum;
            verticalSum = 0;
        }

        //대각선합(우측)
        int rightCrossSum = 0;
        for (int i = 0; i < n; i++) {
            rightCrossSum += arr[i][i];
        }
        if (rightCrossSum > max) max = rightCrossSum;

        //대각선합(좌측)
        int leftCrossSum = 0;
        for (int i = 0; i < n; i++) {
            leftCrossSum += arr[i][n-1-i];
        }
        if (leftCrossSum > max) max = leftCrossSum;

        return max;
    }

}
