package chapter01;

import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int inputCount = 0;

        String[] inputs = new String[num];

        while (num > inputCount){
            inputs[inputCount] = scanner.next();
            inputCount++;
        }

        for (String s : solution(inputs)) {
            System.out.println(s);
        }
    }

    private static String[] solution(String[] arr) {

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = reverseOrder(arr[i]);
//        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder(arr[i]).reverse().toString();
        }

        return arr;
    }

    private static String reverseOrder(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            sb.append(aChar);
        }

        return sb.toString();
    }

}
