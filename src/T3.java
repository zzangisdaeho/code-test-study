public class T3 {

    private int answer = 0;

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};

        int solution = new T3().solution(arr);

        System.out.println("solution = " + solution);
    }

    public int solution(int[] numbers){

        DFS(numbers, 0, 0);
        return answer%100000;
    }

    private void DFS(int[] numbers, int index, int sum){

        if(index >= numbers.length){
            if(sum == 0){
                answer++;
            }
        }else{
            int num = numbers[index];

            DFS(numbers, index+1, sum+num);
            DFS(numbers, index+1, sum-num);
        }


    }
}
