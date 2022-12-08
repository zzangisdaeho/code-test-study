package chapter01;

import java.util.Scanner;

public class Q8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String before = scanner.nextLine();

        System.out.println(solution(before));
    }

    private static String solution(String str) {

        char[] chars = str.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (char aChar : chars) {
            if(Character.isAlphabetic(aChar)) builder.append(aChar);
        }

        String strOnlyAlphabet = builder.toString();

        String reverse = new StringBuilder(strOnlyAlphabet).reverse().toString();

        return strOnlyAlphabet.equalsIgnoreCase(reverse) ? "YES" : "NO";
    }

}
