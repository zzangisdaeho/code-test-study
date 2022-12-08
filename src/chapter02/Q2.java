package chapter02;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }

        System.out.println(solution(arr));

    }

    private static int solution(int[] arr) {
        int count = 0;

        int now = 0;

        for (int i : arr) {
            if (i > now) {
                now = i;
                count++;
            }
        }

        return count;
    }
}
