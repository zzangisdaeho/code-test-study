package chapter01;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.nextLine();
        char target = in.nextLine().charAt(0);
        System.out.println(solution(str, target));
    }

    public static int solution(String str, char target){
        String s = str.toLowerCase();
        char c = Character.toLowerCase(target);

        int result = 0;

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (c == aChar) result++;
        }

        return result;
    }
}
