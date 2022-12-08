package chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        int m=kb.nextInt();
        int[] b=new int[m];
        for(int i=0; i<m; i++){
            b[i]=kb.nextInt();
        }

        int[] solution = solution(n, m, a, b);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int n, int m, int[] a, int[] b) {

        int[] ints = new int[n + m];

        for(int i = 0; i < n; i++){
            ints[i] = a[i];
        }

        for(int i = n; i < n+m; i++){
            ints[i] = b[i-n];
        }

        Arrays.sort(ints);

        return ints;

    }
}
