package chapter01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q12 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
//        int num = in.nextInt();
        String str = in.next();
        char[] solution = solution(str);

        for (char c : solution) {
            System.out.print(c);
        }
    }

    public static char[] solution(String str){

        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('#', 1);
        mapping.put('*', 0);


        char[] chars = str.toCharArray();

        char[] results = new char[chars.length / 7];

        int index = 0;
        StringBuilder builder = new StringBuilder(7);
        int pointer = 0;
        for (char c : chars) {
            index++;
            builder.append(mapping.get(c));

            if(index % 7 == 0) {
                index = 0;
                String s = builder.toString();
                builder.setLength(0);
                results[pointer] = (char)(Integer.parseInt(s, 2));
                pointer++;
            }
        }

        return results;
    }
}
