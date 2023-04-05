package chapter04;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Q1 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        String str=kb.next();
        System.out.println(solution(n, str));
    }

    private static String solution(int n, String str) {

        HashMap<Character, Integer> result = new HashMap<>();

        char[] chars = str.toCharArray();

        for (char aChar : chars) {
            if(result.containsKey(aChar)) result.put(aChar, result.get(aChar)+1);
            else result.put(aChar, 1);
        }

        AtomicReference<Character> big = new AtomicReference<>();
        AtomicInteger bigNum = new AtomicInteger();
        result.entrySet().forEach(entry -> {
            if(entry.getValue() > bigNum.get()){
                big.set(entry.getKey());
                bigNum.set(entry.getValue());
            }
        });

        return big.toString();

    }
}
