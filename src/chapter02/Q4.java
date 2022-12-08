package chapter02;

import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();

        int[] solution = solution(n);

        for (int i : solution) {
            System.out.print(i + " ");
        }

    }

    private static int[] solution(int n) {
        int[] results = new int[n];
        results[0] = 1;
        results[1] = 1;
        for (int i = 2; i < n; i++) {
            results[i] = results[i-2] + results[i-1];
        }
        return results;
    }

}
