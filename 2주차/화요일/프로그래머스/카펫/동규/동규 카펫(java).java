package programmers;
import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int[] answer = new int[2];
		answer = test.solution(24, 24);
		
		System.out.println(answer[0]+" "+answer[1]);
	}

}

class Solution {
	
    public int[] solution(int brown, int red) {
        int[] answer = {};
        ArrayList<Integer> red_x = new ArrayList<Integer>();
        int[] temp = new int[2];

        int mod_num = 1;
        while(mod_num <= (red/2)){
            if(red%mod_num == 0){
                red_x.add(red/mod_num);
            }
            mod_num++;
        }
        
        if(red == 1){
            red_x.add(1);
        }

        for(int i = 0; i<red_x.size();i++){
            if(brown == red_x.get(i)*2+(red/red_x.get(i))*2+4){
                temp[0] = red_x.get(i)+2;
                temp[1] = (red/red_x.get(i))+2;
                break;
            }
        }
        
        answer = temp;
        
        return answer;
    }
    
}