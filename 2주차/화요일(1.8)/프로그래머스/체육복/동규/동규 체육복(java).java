package programmers;
import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution(5, new int[] {2,4}, new int[] {1,3,5});
		
		System.out.println(answer);
	}

}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int have_student = n - lost.length;
    
        for(int i = 0; i<lost.length; i++){
            for(int j = 0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    reserve[j] = -1;
                    lost[i] = -1;
                    have_student++;
                    break;
                }
            }
        }
        
        for(int i = 0; i<lost.length; i++){
            for(int j = 0; j<reserve.length; j++){
                if(lost[i] == (reserve[j]-1)){
                    have_student++;
                    reserve[j] = -1;
                    break;
                }
                else if(lost[i] == (reserve[j]+1)){
                    have_student++;
                    reserve[j] = -1;
                    break;
                }
                else{
                    continue;
                }
            }
        }

        answer = have_student;
        return answer;
    }
}