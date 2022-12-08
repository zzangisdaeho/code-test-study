package chapter03;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(solution2(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        int lp = 0;
        int rp = lp + k - 1;

        int maxSum = 0;

        while(rp < n){
            int sum = 0;
            for(int i = lp; i <= rp; i++){
                sum += arr[i];
            }
            if(sum > maxSum) maxSum = sum;

            lp++;
            rp++;
        }

        return maxSum;
    }

    private static int solution2(int n, int k, int[] arr) {
        int lp = 0;
        int rp = lp + k - 1;

        int maxSum = 0;
        for(int i = lp; i <= rp; i++){
            maxSum += arr[i];
        }

        lp++; rp++;

        int windowSum = maxSum;
        while(rp < n){
            windowSum = windowSum - arr[lp-1] + arr[rp];
            maxSum = Math.max(maxSum, windowSum);
            lp++; rp++;
        }

        return maxSum;
    }

}
