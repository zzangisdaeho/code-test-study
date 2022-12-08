package chapter01;

import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String before = scanner.nextLine();

        System.out.println(solution(before));
    }

    private static String solution(String str) {

        char[] chars = str.toCharArray();

        int lp = 0;

        int rp = chars.length - 1;

        while (lp < rp) {
            if (Character.isAlphabetic(chars[lp])) {
                char temp = chars[lp];

                boolean ahead = true;
                while (ahead) {
                    if(lp >= rp) break;
                    if (Character.isAlphabetic(chars[rp])) {
                        chars[lp] = chars[rp];
                        chars[rp] = temp;
                        ahead = false;
                    }
                    rp--;
                }
            }
            lp++;
        }

        return String.valueOf(chars);
    }

}
