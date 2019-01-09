package programmers;
import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution("011");
		
		System.out.println(answer);
	}

}

class Solution {
	
    ArrayList<Integer> numList = new ArrayList<Integer>();
    int input_num[];
    
    public int solution(String numbers) {
    
        int answer = 0;
        input_num = new int[numbers.length()];
        String[] input_string_arr = numbers.split("");
        
        for(int i =0; i<numbers.length(); i++) {
        	input_num[i] = Integer.parseInt(input_string_arr[i]);
        }
        
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        boolean is_prime = false;

        make_couple();

        for(int i = 0; i < numList.size(); i++){
            is_prime = true;
            for(int j = 2; j< numList.get(i); j++){
                if(numList.get(i) % j == 0){
                    is_prime = false;
                    break;
                }
            }
            if(is_prime && numList.get(i) > 1 ){
                answerList.add(i);
            }
        }
        
        answer = answerList.size();
        
        return answer;
    }
    
    public void make_couple() {
    	int length = 1;
    	int num = 0;
    	ArrayList<Integer> tempList = new ArrayList<Integer>();
    	ArrayList<boolean[]> flag = new ArrayList<boolean[]>();
    	ArrayList<boolean[]> flag_temp = new ArrayList<boolean[]>();
    	boolean[] temp_flag;
    	
    	while(length <= input_num.length) {
			tempList = new ArrayList<Integer>();
			flag_temp = new ArrayList<boolean[]>();
    		for(int i = 0; i < input_num.length; i++) {
				for(int j = 0; j < numList.size(); j++) {
					// numList.get(j)에 input_num[i]가 쓰였는지 예외처리 해야함
					if(flag.get(j)[i] == false) {
						tempList.add(numList.get(j)*10+input_num[i]);
						temp_flag = new boolean[input_num.length];
						for(int k = 0; k<flag.get(j).length;k++) {
							temp_flag[k] = flag.get(j)[k];
						}
						temp_flag[i] = true;
						flag_temp.add(temp_flag);
					}
				}
    			if(numList.size() == 0) {
    				tempList.add(input_num[i]);
					temp_flag = new boolean[input_num.length];
    				temp_flag[i] = true;
					flag_temp.add(temp_flag);
    			}
    		}
    		
    		for(int i = 0; i<tempList.size(); i++) {
    			if(!numList.contains(tempList.get(i))){
    				numList.add(tempList.get(i));
    				flag.add(flag_temp.get(i));
    			}
    		}
    		length++;
    	}
    }
}