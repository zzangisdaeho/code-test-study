import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Missing_Card {

    public static void main(String[] args) {

        int[] cards = new int[]{1, 3, 2, 2, 5, 5, 1};

        int result = solution(cards);
        System.out.println("result = " + result);
    }

    private static int solution(int[] cards) {

        Set<Integer> cardSet = new HashSet<>();

        AtomicInteger answer = new AtomicInteger();

        Map<Integer, Boolean> resultMap = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {
            int cardNum = cards[i];
            boolean addResult = cardSet.add(cardNum);

            resultMap.put(cardNum, addResult);
        }


        //Set에 넣은값이 true이면 한번만 들어갔으므로 짝이 없는 카드
        resultMap.forEach((integer, aBoolean) -> {
            if(aBoolean) {
                answer.set(integer);
            }
        });

        return answer.get();
    }
}
