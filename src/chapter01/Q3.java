package chapter01;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String before = scanner.nextLine();

        System.out.println(solution(before));
    }

    private static String solution(String str) {

        String[] words = str.split(" ");

        String result = null;
        int resultLength = 0;
        
        for (String word : words) {
            if(word.length() > resultLength){
                result = word;
                resultLength = word.length();
            }
        }
        
        return result;
    }
}
