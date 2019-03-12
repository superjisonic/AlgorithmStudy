package programmers;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		String answer;
		answer = test.solution(16,16,2,1);
		
		System.out.println(answer);
	}

}

class Solution {
	public String solution(int n, int t, int m, int p) {
	    String answer = "";
	    String full_string = "";
	    String temp = "";
	    int int_temp = 0;
	    
	    
	    /* full 스트링 만들기 */
	    for(int i = 0; i < t*m;i++) {
	    	if(n<=10) { // 10진수 이하일 때
	    		int_temp = i;
	    		while(int_temp>=n) {
		    		temp = Integer.toString(int_temp%n) + temp;
		    		int_temp /= n;
	    		}
	    		temp = Integer.toString(int_temp) + temp;
	    		full_string += temp;
	    		temp = "";
	    	}
	    	else {
	    		int_temp = i; // 10진수 이상일 때
	    		while(int_temp>=n) {
	    			if(int_temp%n == 10) {
	    				temp = "A" + temp;
	    				int_temp /= n;
	    			}
	    			else if(int_temp%n == 11) {
	    				temp = "B" + temp;
	    				int_temp /= n;
	    			}
	    			else if(int_temp%n == 12) {
	    				temp = "C" + temp;
	    				int_temp /= n;
	    			}
	    			else if(int_temp%n == 13) {
	    				temp = "D" + temp;
	    				int_temp /= n;
	    			}
	    			else if(int_temp%n == 14) {
	    				temp = "E" + temp;
	    				int_temp /= n;
	    			}
	    			else if(int_temp%n == 15){
	    				temp = "F" + temp;
	    				int_temp /= n;
	    			}
	    			else {
	    				temp = Integer.toString(int_temp%n) + temp;
	    				int_temp /= n;
	    			}
	    		}
	    		if(int_temp < 10) {
	    			temp = Integer.toString(int_temp)+temp;
	    		}
	    		else if(int_temp == 10) {
    				temp = "A" + temp;
    				int_temp /= n;
    			}
    			else if(int_temp == 11) {
    				temp = "B" + temp;
    				int_temp /= n;
    			}
    			else if(int_temp == 12) {
    				temp = "C" + temp;
    				int_temp /= n;
    			}
    			else if(int_temp == 13) {
    				temp = "D" + temp;
    				int_temp /= n;
    			}
    			else if(int_temp == 14) {
    				temp = "E" + temp;
    				int_temp /= n;
    			}
    			else {
    				temp = "F" + temp;
    				int_temp /= n;
    			}
	    		full_string += temp;
	    		temp = "";
	    	}
	    }
	    for(int i = 0; i<t; i++) {
	    	answer = answer + full_string.charAt(i*m+p-1);	
	    }
	    return answer;
	}
}