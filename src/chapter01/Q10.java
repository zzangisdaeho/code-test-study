package chapter01;

import java.util.Scanner;

public class Q10 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String searchWord = kb.next();
        String target = kb.next();

        int[] result = solution(searchWord, target);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String searchWord, String target) {

        char[] chars = searchWord.toCharArray();

        boolean[] positions = new boolean[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == target.charAt(0))positions[i] = true;
        }

        int[] results = new int[positions.length];

        for (int i = 0; i < positions.length; i++) {
            int nearLeft = findNearLeft(i, positions);
            int nearRight = findNearRight(i, positions);

            results[i] = Math.min(nearLeft, nearRight);
        }

        return results;
    }

    private static int findNearLeft(int index, boolean[] positions) {
        boolean flag = false;
        int result = -1;
        int pointer = index;
        while (result < 0){
            if(positions[pointer]){
                result = index - pointer;
                flag = true;
            }
            else pointer--;

            if(pointer < 0) break;
        }

        if(flag) return result;
        else return Integer.MAX_VALUE;
    }

    private static int findNearRight(int index, boolean[] positions) {
        boolean flag = false;
        int result = -1;
        int pointer = index;
        while (result < 0){
            if(positions[pointer]){
                result = pointer - index;
                flag = true;
            }
            else pointer++;

            if(pointer >= positions.length) break;
        }

        if(flag) return result;
        else return Integer.MAX_VALUE;
    }
}
