public class budget_num {

    public static void main(String[] args) {
        int a = 3000;
        int b = 5000;
        int budget = 23000;

        int result = solution(a, b, budget);

        System.out.println("result = " + result);
    }

    private static int solution(int a, int b, int budget) {

        int result = 0;
        // a로 최대 채울수 있는 갯수만큼 탐색
        for (int i = 0; i < budget/a + 1; i++) {
            // a로 구매후 남은 예산을 b로 알맞게 채울 수 있는지 검사
            result = (budget- (a * i)) % b == 0 ? ++result : result;
        }
        return result;
    }
}
