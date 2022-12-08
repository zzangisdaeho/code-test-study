package chapter01;

import java.util.Scanner;

public class Q9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String before = scanner.nextLine();

        System.out.println(solution(before));
    }

    private static int solution(String str) {

        char[] chars = str.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (char aChar : chars) {
            if (Character.isDigit(aChar)) builder.append(aChar);
        }

        return Integer.parseInt(builder.toString());
    }

}
