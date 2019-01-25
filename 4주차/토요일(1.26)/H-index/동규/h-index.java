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
		answer = test.solution(new int[] {3,0,6,1,5});
		
		System.out.println(answer);
	}

}

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;

        Arrays.sort(citations); // Á¤·Ä
        
        for(int i = 0; i < length; i++){
            if(citations[i] >=  length - i){
            	answer = length-i;
            }
        }

        return answer;
    }
}