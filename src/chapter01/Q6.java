package chapter01;

import java.util.*;

public class Q6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String before = scanner.nextLine();

        System.out.println(solution(before));
    }

    private static String solution(String str) {

        char[] chars = str.toCharArray();

        LinkedHashSet<Character> answerSet = new LinkedHashSet<>();

        for (char aChar : chars) {
            answerSet.add(aChar);
        }

        StringBuilder answer = new StringBuilder();
        for (Character character : answerSet) {
            answer.append(character);
        }

        return answer.toString();
    }

}
