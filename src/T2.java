public class T2 {

    public static void main(String[] args) {

        int solution = new T2().solution2(1000000, 3, 1000000);

        System.out.println("solution = " + solution);
    }

    public int solution(int p, int m, int d) {
        int rate = 1;
        while(true){
            int amount = p;
            for(int i = 0; i < m; i++){
                amount += amount * rate/100;
            }
            if(amount > d){
                break;
            }
            rate++;
        }

        return rate;
    }

    public int solution2(int p, int m, int d) {
        int low = 0;
        int high = 20;

        while(low < high){
            int mid = (low + high) /2;
            int amount = p;
            for(int i = 0; i < m; i++){
                amount += amount * mid/100;
            }
            if(amount < d){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return low;
    }
}
