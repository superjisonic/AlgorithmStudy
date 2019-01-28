package programmers;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution(new int[] {1,3,2,4,7,6,2,5});
		
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
        
        answer = calcMoney(0,money.length-1);
        answer = total[0][money.length-1];
        return answer;
    }
    
    public int calcMoney(int i, int j) {
    	ArrayList<Integer> max_temp = new ArrayList<Integer>();
    	ArrayList<Integer> index_temp_max = new ArrayList<Integer>();
    	ArrayList<Integer> index_temp_min = new ArrayList<Integer>();
    	
    	if(i<=j) {
	    	if(i == j) { // (0,0) (1,1) 등이라면 채워주고 return
	    		total[i][j] = money[i];
	    		index_max[i][j] = i;
	    		index_min[i][j] = i;
	    		return total[i][j];
	    	}
	    	else {
	    		for(int k = i; k < j; k++) {
	    			if(total[i][k] == 0) { // 값이 없으면 값을 계산
	    				total[i][k] = calcMoney(i,k);
	    			}
	    			if(total[k+1][j] == 0) {
	    				total[k+1][j] = calcMoney(k+1,j);
	    			}
	    			if(Math.abs(i-j)==2) {
	    				int max = -1;
	    				max_temp.add(calcMoney(i,i)+calcMoney(j,j));
	    				index_temp_max.add(index_max[j][j]);
	    				index_temp_min.add(index_min[i][i]);
	    				
	    				max_temp.add(total[i+1][i+1]);
	    				index_temp_max.add(index_max[i+1][i+1]);
	    				index_temp_min.add(index_min[i+1][i+1]);
	    			}
	    			else if(Math.abs(index_max[i][k]-index_min[k+1][j])>1 && Math.abs(index_min[i][k]-index_max[k+1][j])!=money.length-1) { // 더할 수 있다면
	    				max_temp.add(calcMoney(i,k)+calcMoney(k+1,j));
	    				index_temp_max.add(index_max[k+1][j]);
	    				index_temp_min.add(index_min[i][k]);
	    			}
	    			else { // 더할 수 없다면
	    				if(total[i][k] >= total[k+1][j]) {
	    					max_temp.add(total[i][k]);
	    					index_temp_max.add(index_max[i][k]);
	    					index_temp_min.add(index_min[i][k]);
	    				}
	    				else {
	    					max_temp.add(total[k+1][j]);
	    					index_temp_max.add(index_max[k+1][j]);
	    					index_temp_min.add(index_min[k+1][j]);
	    				}
	    			}
	    		}
	    		if((j-i)%2 == 0) {
	    			int max_odd = 0;
	    			for(int h = i; h <=j; h+=2 ) {
	    				max_odd += money[h];
	    			}
	    			max_temp.add(max_odd);
	    			index_temp_max.add(j);
					index_temp_min.add(i);
	    		}
	    		
	    		max(i,j,max_temp,index_temp_max,index_temp_min);
	    	}
	    	return total[i][j];
    	}
    	else {
    		return 0;
    	}
    }
    
    public void max(int i, int j, ArrayList<Integer> max_temp, ArrayList<Integer> index_temp_max, ArrayList<Integer> index_temp_min){
    	int max = -1;
    	for(int k = 0; k<max_temp.size();k++) {
    		if(max <= max_temp.get(k)) {
    			max = max_temp.get(k);
    			index_max[i][j] = index_temp_max.get(k);
    			index_min[i][j] = index_temp_min.get(k);
    		}
    	}
    	total[i][j] = max;
    }
}