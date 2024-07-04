package programmers;

import java.util.Arrays;

public class MinWaiting {

    public static void main(String[] args) {
        int[] times = {10, 7};
        int n = 6;

        long solution = new MinWaiting().solution(n, times);

        System.out.println("solution = " + solution);
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long lt = 0;
        long rt = (long) n * times[times.length-1];

        long answer = 0;

        while(lt <= rt){

            long pointer = (lt+rt)/2;

            long availableCount = 0;

            for (int time : times) {
                availableCount = availableCount + pointer / time;
            }

            if(availableCount >= n){
                answer = pointer;
                rt = pointer-1;
            }
            if(availableCount < n){
                lt = pointer+1;
            }
        }


        return answer;
    }
}
