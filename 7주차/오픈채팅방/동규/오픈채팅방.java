package programmers;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		String[] answer;
		answer = test.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		
		for(int i = 0; i<answer.length;i++){
		System.out.println(answer[i]);
		}
	}

}

class Solution {
	
	ArrayList<String[]> message = new ArrayList<String[]>();
	ArrayList<String> temp = new ArrayList<String>();
	HashMap<String,String> id_name = new HashMap<String, String>();
	
    public String[] solution(String[] record) {
        String[] answer = {};
        
        for(int i = 0; i<record.length;i++) {
        	message.add(record[i].split(" "));
        	if(!id_name.containsKey(message.get(i)[1])) { // 아이디 닉넴이 저장 안되었다면
        		id_name.put(message.get(i)[1], message.get(i)[2]);
        	}
        	else if(message.get(i)[0].equals("Leave")) {
        		String[] temp_string = new String[3];
        		temp_string[0] = message.get(i)[0];
        		temp_string[1] = message.get(i)[1];
        		temp_string[2] = id_name.get(message.get(i)[1]);
        		message.set(i, temp_string);
        	}
        	else if(message.get(i)[0].equals("Change")||message.get(i)[0].equals("Enter")) {
        		id_name.put(message.get(i)[1], message.get(i)[2]);
        	}
        }
        
        for(int i = 0; i<message.size();i++) {
        	if(message.get(i)[0].equals("Enter")) {
        		temp.add(id_name.get(message.get(i)[1])+"님이 들어왔습니다.");
        	}
        	else if(message.get(i)[0].equals("Leave")){
        		temp.add(id_name.get(message.get(i)[1])+"님이 나갔습니다.");
        	}
        	else {
        		continue;
        	}
        }
        
        String[] a_t = new String[temp.size()];
        for(int i = 0; i<temp.size();i++) {
        	a_t[i] = temp.get(i);
        }
        answer = a_t;
        return answer;
    }
}