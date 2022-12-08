package chapter01;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String before = scanner.nextLine();

        System.out.println(solution(before));
    }

    private static String solution(String str) {

        char[] chars = str.toCharArray();

        StringBuilder stringBuffer = new StringBuilder();

        for (char aChar : chars) {
            boolean upperCase = Character.isUpperCase(aChar);
            char change = upperCase? Character.toLowerCase(aChar) : Character.toUpperCase(aChar);
            stringBuffer.append(change);
        }

        return stringBuffer.toString();
    }
}
