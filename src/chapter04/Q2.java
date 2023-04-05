package chapter04;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Q2 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String a=kb.next();
        String b=kb.next();
        System.out.print(solution(a, b));
    }

    private static String solution(String a, String b) {

        HashMap<Character, Integer> resultMap = new HashMap<>();

        for (char charA : a.toCharArray()) {
            resultMap.put(charA, resultMap.getOrDefault(charA, 0) + 1);
        }

        for (char charB : b.toCharArray()){
            resultMap.put(charB, resultMap.getOrDefault(charB, 0) - 1);
        }

        AtomicBoolean result = new AtomicBoolean(true);

        resultMap.forEach((character, integer) -> {
            if (integer != 0) result.set(false);
        });


        return result.get() ? "YES" : "NO";
    }
}
