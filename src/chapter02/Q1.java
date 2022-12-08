package chapter02;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }

        ArrayList<Integer> result = solution(arr);

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }

    private static ArrayList<Integer> solution(int[] arr) {

        ArrayList<Integer> integers = new ArrayList<>();

        int before = 0;
        for (int i : arr) {
            if (i > before){
                integers.add(i);
            }
            before = i;
        }
        return integers;
    }
}
