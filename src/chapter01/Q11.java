package chapter01;

import java.util.Scanner;

public class Q11 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }

    public static String solution(String str){
        String s = str.toUpperCase();

        char[] chars = s.toCharArray();

        char current = 0;
        int sameCount = 0;

        StringBuilder builder = new StringBuilder();

        for (char aChar : chars) {
            if(current != aChar){
                current = aChar;
                if(sameCount != 0) builder.append(++sameCount);
                builder.append(current);
                sameCount = 0;
            }else{
                sameCount++;
            }
        }

        if(current != 0) builder.append(++sameCount);

        return builder.toString();
    }
}
