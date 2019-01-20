package programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
		
		System.out.println(answer);
	}

}

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        for(int i = 0; i<triangle.length-1;i++) {
        	for(int j = 0;j<triangle[i].length;j++) {
        		if(dp[i][j]<triangle[i][j]) {
        			dp[i][j] = triangle[i][j];
        		}
        		if(dp[i+1][j]<dp[i][j]+triangle[i+1][j]) {
        			dp[i+1][j] = dp[i][j]+triangle[i+1][j];
        		}
        		if(dp[i+1][j+1]<dp[i][j]+triangle[i+1][j+1]) {
        			dp[i+1][j+1] = dp[i][j]+triangle[i+1][j+1];
        		}
        	}
        }
        int max = 0;
        
        for(int i = 0; i< triangle[triangle.length-1].length;i++) { // 맨 마지막 줄 탐색
        	if(max < dp[triangle.length-1][i]) {
        		max = dp[triangle.length-1][i];
        	}
        }
        answer = max;
        return answer;
    }
}