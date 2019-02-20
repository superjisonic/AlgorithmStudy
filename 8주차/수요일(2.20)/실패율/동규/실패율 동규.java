package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer[];
		answer = test.solution(7, new int[] {1,2,3});
		for(int i = 0 ; i<answer.length;i++)
		System.out.println(answer[i]);
	}

}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int same_cnt = 0;
        int same_point = 0;
        int current_stage = 1;
        
        HashMap<Integer, Float> fail_rate = new HashMap<Integer, Float>();
        Arrays.sort(stages);
        
        for(int i = 0; i<stages.length;i++) {
        	if(stages[i]== N+1) { // 끝까지 다봄
        		fail_rate.put(current_stage, (float)same_cnt/(stages.length-same_point));
        		while(current_stage!=N) {
        			current_stage++;
        			fail_rate.put(current_stage,(float)0);
        		}
        		break;
        	}
        	
        	if(i != 0 && stages[i] == stages[i-1]+1) { // 1 증가했다면 거기서부터 머릿수
        		fail_rate.put(current_stage, (float)same_cnt/(stages.length-same_point));
        		current_stage++;
        		same_cnt = 1;
        		same_point = i;
        	}
        	else if(current_stage == stages[i]) { // 이전과 스테이지가 동일하면 카운팅
        		same_cnt++;        		
        	}
        	else { // 2개이상 증가
        		fail_rate.put(current_stage, (float)same_cnt/(stages.length-same_point));
        		current_stage++;
        		same_cnt = 1;
        		same_point = i;
        		
        		for(int j = current_stage; j < stages[i];j++) {
        			fail_rate.put(current_stage,(float)0);
        			current_stage++;
        		}
        	}
        	
        	if(i == stages.length-1) {
        		fail_rate.put(current_stage, (float)same_cnt/(stages.length-same_point));
        		while(current_stage!=N) {
        			current_stage++;
        			fail_rate.put(current_stage,(float)0);
        		}
        	}
        }
        
        Iterator iterator = sortByValue(fail_rate).iterator();
        
        int[] answer_temp = new int[N];
        
        int i = 0;
        while(iterator.hasNext()) {
        	answer_temp[i] = (int)iterator.next();
        	i++;
        }
        answer = answer_temp;
        return answer;
    }
    
    public static List sortByValue(final Map map) {

    	List<String> list = new ArrayList();

    	list.addAll(map.keySet());

    	Collections.sort(list,new Comparator() {
        	public int compare(Object o1,Object o2) {
	        	Object v1 = map.get(o1);
	        	Object v2 = map.get(o2);
	        	return ((Comparable) v2).compareTo(v1);
        	}
    	});
    	return list;
    }
}