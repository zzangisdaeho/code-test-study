package chapter02;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i]=kb.nextInt();
        }

        String[] solution = solution(n, a, b);

        for (String s : solution) {
            System.out.println(s);
        }

    }

    private static String[] solution(int n, int[] a, int[] b) {
        String[] results = new String[n];
        for (int i = 0; i < results.length; i++) {
            results[i] = decider(a[i], b[i]);
        }
        return results;
    }

    private static String decider(int a, int b){
        if(a == b) return "D";
        else if(a == 1 && b == 3) return "A";
        else if(a == 2 && b == 1) return "A";
        else if(a == 3 && b == 2) return "A";
        else return "B";
    }
}
