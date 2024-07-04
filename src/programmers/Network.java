package programmers;

import java.util.ArrayDeque;

public class Network {

    public static void main(String[] args) {

        int computerNum = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        int solution = new Network().solution(computerNum, computers);

        System.out.println("solution = " + solution);
    }

    public int solution(int n, int[][] computers) {

        int answer = 0;

        int[] visitedComputer = new int[n];

        for (int i = 0; i < visitedComputer.length; i++) {
            if(visitedComputer[i] != 1){
                answer++;
                BFS(i, visitedComputer, computers);
            }

        }

        return answer;
    }

    private void BFS(int currentComputer, int[] visitedComputer, int[][] computers){

        ArrayDeque<Integer> linkedComputer = new ArrayDeque<>();

        linkedComputer.addFirst(currentComputer);

        while(!linkedComputer.isEmpty()){
            Integer checkingComputer = linkedComputer.removeLast();
            visitedComputer[checkingComputer] = 1;
            for (int i = 0; i < computers[checkingComputer].length; i++) {
                //방문한 이력이 없고 연결된 컴퓨터인 상태라면
                if(visitedComputer[i] != 1 && computers[checkingComputer][i] == 1){
                    linkedComputer.addFirst(i);
                }
            }
        }

    }
}
