import java.util.List;
import java.util.Map;

public class T1 {

    private Map<Character, List<Character>> keyMap = Map.of(
            '1', List.of('.','Q','Z'),
            '2', List.of('A', 'B', 'C'),
            '3', List.of('D','E','F'),
            '4', List.of('G', 'H', 'I'),
            '5', List.of('J', 'K', 'L'),
            '6', List.of('M', 'N', 'O'),
            '7', List.of('P', 'R', 'S'),
            '8', List.of('T', 'U', 'V'),
            '9', List.of('W', 'X', 'Y')
            );

    public static void main(String[] args) {
        String s = "44335550555666";
        String solution = new T1().solution(s);
        System.out.println("solution = " + solution);
    }

    public String solution(String s) {
        char[] chars = s.toCharArray();

        StringBuilder result = new StringBuilder();

        //같은 숫자 누른 횟수 기억용
        int sameCount = 0;

        //현재 누른것으로 인해 입력중인 상태인 문자
        int lastChar = ' ';

        //edge case
        if(chars.length == 0) return "";

        //첫번째 입력
        lastChar = keyMap.get(chars[0]).get(0);
        sameCount++;

        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            //0이면 lastChar 를 입력하려했던것
            if(aChar == '0'){
                result.append((Character.toString(lastChar)));
                sameCount = 0;
            }else{
                //다른 숫자를 누르면 lastChar가 저장되어야함
                if(chars[i-1] != '0' && aChar != chars[i-1]) {
                    result.append(Character.toString(lastChar));
                    sameCount = 1;
                    lastChar = keyMap.get(aChar).get(0);
                    //같은 숫자를 누르면 lastChar가 변환되어야함.
                }else if (chars[i-1] == '0' && aChar != chars[i-1]){
                    sameCount = 1;
                    lastChar = keyMap.get(aChar).get(0);
                }else{
                    ++sameCount;
                    lastChar = keyMap.get(aChar).get((sameCount-1)%3);
                }
            }
        }

        result.append(Character.toString(lastChar));

        return result.toString();
    }
}
