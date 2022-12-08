package chapter01;

import java.util.Scanner;

public class Q7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String before = scanner.nextLine();

        System.out.println(solution(before));
    }

    private static String solution(String str) {

        String reverse = new StringBuilder(str).reverse().toString();

        return str.equalsIgnoreCase(reverse) ? "YES" : "NO";
    }

}
