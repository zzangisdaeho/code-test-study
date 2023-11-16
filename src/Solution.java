import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{1,2},{0,1}};

        boolean b = new Solution().canFinish(3, prerequisites);
        System.out.println("b = " + b);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //i번째 수업을 듣기 위해 들어야하는 수업을 value값으로 갖는 array
        int[] pretable = new int[numCourses+1];

        for(int i = 0 ; i < prerequisites.length; i++){
            int[] prerequisite = prerequisites[i];
            //선행
            int pre = prerequisite[1]+1;
            //타겟
            int target = prerequisite[0]+1;

            if(pre == target) return false;

            int iter = pre;
            pretable[target] = pre;
            while(iter != 0){
                if(pretable[iter] == target) return false;
                if(pretable[iter] != 0) iter = pretable[iter];
                if(pretable[iter] == 0) break;
            }


        }

        return true;
    }

}