package chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q2 {

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

        for(int x : solution2(n, m, a, b)) System.out.print(x+" ");
    }

    private static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {

        int p1 = 0, p2 = 0;

        ArrayList<Integer> commonList = new ArrayList<>();

        while(p1 < n && p2 < m){
            int target = a[p1];
            if(target == b[p2]) {
                commonList.add(target);
                p2 = 0;
                p1++;
            }else if(p2 < m-1){
                p2++;
            }else{
                p2 = 0;
                p1++;
            }

        }

        commonList.sort(Comparator.comparingInt(value -> value));

        return commonList;
    }

    public static ArrayList<Integer> solution2(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0, p2=0;
        while(p1<n && p2<m){
            if(a[p1]==b[p2]){
                answer.add(a[p1++]);
                p2++;
            }
            else if(a[p1]<b[p2]) p1++;
            else p2++;
        }
        return answer;
    }
}
