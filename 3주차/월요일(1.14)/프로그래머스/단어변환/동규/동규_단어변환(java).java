package programmers;
import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution("hit","cog",new String[] {"hot","dot","dog","lot","log","cog"});
		
		System.out.println(answer);
	}

}

class Solution {
	String begin;
	String target;
	String words[];
	String now;
	String before;
	String blank_word = null;
	
	boolean was_changed[];
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean exist = false;
        
        this.begin = begin;
        this.target = target;
        this.words = words;
        was_changed = new boolean[words.length];
        
        /* target이 words에 없는 경우 */
        for(int i = 0; i<words.length; i++){
        	blank_word += "0";
            if(words[i].equals(target)){
                exist = true;
                break;
            }
        }
        if(!exist) {
        	return 0;
        }
        
        now = begin;
        
        answer = find();
        
        return answer;
    }
    
    public int find() {
    	
    	boolean this_changed = false;
    	
    	for(int i = 0; i<words.length; i++) {
    		if(target.equals(now)) {
    			return 0;
    		}
    		if(can_change(now,words[i]) && was_changed[i] == false) {
    			before = now;
    			now = words[i];
    			was_changed[i] = true;
    			this_changed = true;
    			break;
    		}
    	}
    	
    	if(!this_changed) {
    		for(int i = 0; i < words.length; i++) {
    			if(words[i].equals(now)){
    				words[i] = blank_word;
    				now = before;
    			}
    		}
    		return find()-2;
    	}
    	
    	return 1+find();
    }
    
    public boolean can_change(String st1, String st2) {
    	
    	int same_char_cnt = 0;
    	
    	for(int i = 0; i<st1.length(); i++) {
    		if(st1.charAt(i) == st2.charAt(i)) {
    			same_char_cnt++;
    		}
    	}
    	
    	if(st1.length()-same_char_cnt == 1) {    	/*다른 게 1개라면*/
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
}