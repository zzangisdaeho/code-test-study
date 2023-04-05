package chapter04;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x : solution(n, k, arr)) {
            System.out.print(x+" ");
        }
    }

    private static ArrayList<Integer> solution(int n, int k, int[] arr) {
        int lp = 0;
        int rp = lp + k - 1;

        HashMap<Integer, Integer> accumulation = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>();

        for(int i = lp; i <= rp; i++){
            accumulation.put(arr[i], accumulation.getOrDefault(arr[i], 0) + 1);
        }
        results.add(accumulation.size());
        lp++;
        rp++;


        while (rp < n){
            int removed = arr[lp - 1];
            if(accumulation.containsKey(removed)) accumulation.put(removed, accumulation.get(removed) - 1);
            if(accumulation.containsKey(removed) && accumulation.get(removed) == 0) accumulation.remove(removed);

            accumulation.put(arr[rp], accumulation.getOrDefault(arr[rp], 0) + 1);

            results.add(accumulation.size());

            lp++; rp++;
        }


        return results;
    }

}
