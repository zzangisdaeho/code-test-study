import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Green_Balt {

    public static void main(String[] args) {
        int tileSize = 6;

        int[][] trees = new int[][]{{5,5},{1,4},{3,3},{2,2},{4,1}};

        int result = solution(tileSize, trees);

        System.out.println("result = " + result);
    }

    private static int solution(int tileSize, int[][] trees) {

        //왼쪽순으로 정렬
        List<int[]> treeList = Arrays.asList(trees);
        treeList.sort(Comparator.comparingInt(x -> x[0]));

        int answer = 1;

        //마지막 벨트 경계선에 포함된 나무와 비교. 해당 나무보다 아래있으면 경계선에 포함됨
        int lastLayerTreeNum = 0;
        for (int i = 1; i < treeList.size(); i++) {
            int[] targetTree = treeList.get(i);
            int[] beforeTree = treeList.get(lastLayerTreeNum);

            if(targetTree[1] < beforeTree[1]){
                lastLayerTreeNum = i;
                ++answer;
            }
        }
        return answer;
    }
}
