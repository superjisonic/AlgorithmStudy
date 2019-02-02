package programmers;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution(new int[] {10,2,3,5,2,6,3,3,1000});
		
		System.out.println(answer);
	}

}

class Solution {
	
	int[][] total;
	int[][] index_max;
	int[][] index_min;
	int[] money;

	
    public int solution(int[] money) {
        int answer = 0;
        
        total = new int[money.length][money.length];
        index_max = new int[money.length][money.length];
        index_min = new int[money.length][money.length];

        this.money = money;
        int max = -1;
        
        for(int i = 0; i<money.length;i++) {
        	for(int j=i;j>=0;j--) {
        		if(i==j) {
        			total[i][j] = money[i];
    	    		index_max[i][j] = i;
    	    		index_min[i][j] = i;
        		}
        		else {
        			for(int k = j; k < i; k++) {
        				if(Math.abs(index_max[j][k]-index_min[k+1][i])>1 && Math.abs(index_min[j][k]-index_max[k+1][i])!= (i-j)) {
	        				if(max < (total[j][k]+total[k+1][i])) {
	        					max = total[j][k]+total[k+1][i];
	        					total[j][i] = max;
	        					index_max[j][i] = index_max[k+1][i];
	        					index_min[j][i] = index_min[j][k];
	        		    	}
        				}
        				else {
        					if(total[j][k] >= total[k+1][i])  {
    	        				if(max < total[j][k]) {
    	        					max = total[j][k];
	    	    					total[j][i] = total[j][k];
	    	    					index_max[j][i] = index_max[j][k];
	    	    					index_min[j][i] = index_min[j][k];
    	        				}
    	    				}
    	    				else {
    	        				if(max < total[k+1][i]) {
		        					max = total[k+1][i];
	    	    					total[j][i] = total[k+1][i];
	    	    					index_max[j][i] = index_max[k+1][i];
	    	    					index_min[j][i] = index_min[k+1][i];
    	        				}
    	    				}
        				}
        			}
        			
        			max = 0;
        			
        			if(Math.abs(i-j)%2==1) {
        				int temp1 = 0;
        				int temp2 = 0;
        				for(int h = j; h <= i; h+=2) {
        					temp1 += money[h];
        				}
        				for(int h = j+1; h<=i; h+=2) {
        					temp2 += money[h];
        				}
        				if(temp1 > total[j][i]) {
        					total[j][i] = temp1;
        					index_max[j][i] = i-1;
        					index_min[j][i] = j;
        				}
        				if(temp2 > total[j][i]) {
        					total[j][i] = temp2;
        					index_max[j][i] = i;
        					index_min[j][i] = j+1;
        				}
        			}
        			if(i >= 3) {
	        			if(total[j][i] < total[j+1][i-2]+money[i]) {
	        				total[j][i] = total[j+1][i-2]+money[i];
	        				index_max[j][i] = i;
	        				index_min[j][i] = index_min[j+1][i-2];
	        			}
        			}
        		}
        	}
        }
        answer = total[0][money.length-1];
        return answer;
    }
}