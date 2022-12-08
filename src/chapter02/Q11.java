package chapter02;

import java.util.Scanner;

public class Q11 {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(solution(n, arr));

    }

    private static int solution(int n, int[][] arr) {

        int[] matchCountArr = new int[n];
        boolean[][] matchedTable = new boolean[n][n];

        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < n; k++) {
                int studentNo = k;
                int studentClassNo = arr[studentNo][j];
                for (int i = 0; i < n; i++) {
                    if (i == studentNo) continue;
                    else if (matchedTable[studentNo][i]) continue;
                    else {
                        if (studentClassNo == arr[i][j]) {
                            matchCountArr[studentNo]++;
                            matchedTable[studentNo][i] = true;
                        }
                    }
                }
            }

        }

        int maxIndex = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (matchCountArr[i] > maxCount) {
                maxCount = matchCountArr[i];
                maxIndex = i;
            }
        }

        return maxIndex + 1;
    }

}
