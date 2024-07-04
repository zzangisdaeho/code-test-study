package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Scoville {

    public static void main(String[] args) {

        int[] scoville = {2, 1, 3, 9, 10, 12};
        int K = 7;

        int solution = new Scoville().solution(scoville, K);

        System.out.println("solution = " + solution);
    }

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        int count = 0;


        while(!pq.isEmpty()){

            if(pq.peek() >= K){
                return count;
            }
            else{
                if(pq.size() < 2) return -1;

                Integer minScoville = pq.poll();

                Integer nextScoville = pq.poll();

                pq.offer(mixFood(minScoville, nextScoville));
                count++;
            }
        }



        return -1;
    }

    private int mixFood(int scoville1, int scoville2){
        int min = Math.min(scoville1, scoville2);
        int max = Math.max(scoville1, scoville2);

        return min + max*2;
    }
}
