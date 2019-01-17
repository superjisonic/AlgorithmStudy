package programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution(new int[] {1,2,3,9,10,12},7);
		
		System.out.println(answer);
	}

}

class Solution {
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        int first = 0;
        int second = 0;
        
        for(int i = 0; i <scoville.length; i++) {
        	list.add(scoville[i]);
        }
        
        Collections.sort(list, new AscendingInteger()); // input 오름차순 정렬
        
        while(list.get(0)<K) {
        	if(list.size() == 1) {
        		return -1;
        	}
        	list.set(1, list.get(0)+list.get(1)*2);
        	list.remove(0);
        	Collections.sort(list, new AscendingInteger()); // input 오름차순 정렬
        	answer++;
        }
        
        
        return answer;
    }
}

class AscendingInteger implements Comparator<Integer>{
	public int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}
}