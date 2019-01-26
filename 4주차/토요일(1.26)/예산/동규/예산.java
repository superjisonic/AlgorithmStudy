package programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution(new int[] {70,80,30,40,100},40);
		
		System.out.println(answer);
	}

}

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int avg = M/budgets.length;
        int allow_index = 0;
        
        int pivot = budgets.length/2;
        int min = 0;
        int max = budgets.length;
        
        Arrays.sort(budgets);
        
        /* 예산이 넉넉한가? */
        int sum = 0;
        for(int i = 0; i< budgets.length; i++) {
        	sum += budgets[i];
        }
        if(sum <= M) { // 예산이 넉넉하다면
        	return budgets[budgets.length-1];
        }
        
        /* 예산이 최저 예산보다 작은 경우 */
        if(avg < budgets[0]) {
        	return avg;
        }
        
        
        /* binary search */
        while(min <= max){
            
            if(budgets[pivot] == avg){
                allow_index = pivot;
                break;
            }
            else if(budgets[pivot] < avg){
                min = pivot + 1;
            }
            else{
                max = pivot - 1;
            }
            pivot = (max+min)/2;

//            if(min > max) {
//            	allow_index = max;
//            	break;
//            }
        }
        
        allow_index = pivot;

        for(int i = 0; i<= allow_index; i++){
            M -= budgets[i];
        }
        
        answer = M/(budgets.length-allow_index-1);

        
        return answer;
    }
}