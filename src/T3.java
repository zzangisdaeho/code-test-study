public class T3 {

    private int answer = 0;

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};

        int solution = new T3().solution(arr);

        System.out.println("solution = " + solution);
    }

    public int solution(int[] numbers){

        int dfs = DFS(numbers, 0, 0);
        return dfs % 100000;
//        return answer%100000;
    }

    private int DFS(int[] numbers, int index, int sum){
        int count = 0;
        if(index >= numbers.length){
            if(sum == 0){
                return 1;
            }else{
                return 0;
            }
        }else{
            count += DFS(numbers, index+1, sum+numbers[index]);
            count += DFS(numbers, index+1, sum-numbers[index]);
        }
        return count;
    }
}
